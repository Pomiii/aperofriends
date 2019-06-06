import {Item} from '../model/item';
import {BehaviorSubject, Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Injectable} from '@angular/core';
import {TypeItem} from '../model/typeItem';
import {environment} from '../../environments/environment';

@Injectable ({
  providedIn: 'root'
})

export class ItemService {

  // la liste des Items
  availableItems: Item[];

  // la liste observable que l'on rend visible partout dans l'appli
  availableItems$: BehaviorSubject<Item[]> = new BehaviorSubject(this.availableItems);

  constructor(private httpClient: HttpClient) {

  }

  public itemListSubject: BehaviorSubject<Item[]> = new BehaviorSubject(null);

  public setItemListSubject(value: Item[]) {
    if (value) {
      this.itemListSubject.next(value);
    } else {
      this.itemListSubject.next(null);
    }
  }

  /**
   * La fonction getAllItem() est privée car elle n'a pas besoin d'être appellée que dans le service.
   */
  public getAllItem(): Observable<Item[]> {
    console.log('getAllItems' + this.availableItems$);
    return this.httpClient.get<Item[]>('http://localhost:8080/aperofriends/items');
  }

  /**
   * La fonction publishItems() est chargée une fois au démarrage de l'application.
   * Elle récupère la liste des Items depuis la base de données et met à jour la liste et la liste observable.
   */
  public publishItems() {
    this.getAllItem().subscribe(
      ItemList => {
        this.availableItems = ItemList;
        this.availableItems$.next(this.availableItems);
        this.setItemListSubject(this.availableItems);
      });
  }

  /**
   * @param idItem l'id qu'il faut rechercher dans la liste.
   */
  public findItem(itemId: number): Observable<Item> {
    if (itemId) {
      if (!this.availableItems) {
        return this.getAllItem().pipe(map(items => items.find(item => item.idItem === itemId)));
      }
      return of(this.availableItems.find(item => item.idItem === itemId));
    } else {
      return of(new Item('', '', new TypeItem(0, '' ) , 0));
    }
  }

  /**
   * @param newItem
   */
  public createItem(newItem: Item, typeItemString: string) {
    console.log('newItem ++++++ ' + newItem);
    this.httpClient.post<Item>(environment.apiUrl + '/createItem/' + typeItemString, newItem).subscribe(
      bite => {
        console.log('newItem ---', bite);
        this.availableItems.push(bite);
        this.availableItems$.next(this.availableItems);
      }
    );
  }

  /**
   * Fonction de mise à jour d'un Friend
   * @param item
   */
  public updateItem(item: Item) {
    this.httpClient.put<Item>(environment.apiUrl + '/updateItem', item).subscribe(
      updatedItem => {
        this.availableItems$.next(this.availableItems);
      }
    );
  }

  /**
   * Fonction de suppression
   * @param friend
   */
  public deleteItem(idItem: number) {
    this.httpClient.delete<Item>(environment.apiUrl + '/deleteItem/' + idItem).subscribe(
    );
  }
}
