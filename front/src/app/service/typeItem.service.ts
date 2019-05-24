import {Injectable} from '@angular/core';
import {TypeItem} from '../model/typeItem';
import {BehaviorSubject, Observable, of} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Item} from '../model/item';
import {environment} from '../../environments/environment';

@Injectable ({
  providedIn: 'root'
})

export class TypeItemService {
  // la liste des TypeItems
  availableTypeItems: TypeItem[];

  // la liste observable que l'on rend visible partout dans l'appli
  availableTypeItems$: BehaviorSubject<TypeItem[]> = new BehaviorSubject(this.availableTypeItems);

  constructor(private httpClient: HttpClient) {

  }
  public typeItemListSubject: BehaviorSubject<TypeItem[]> = new BehaviorSubject(null);

  public setTypeItemListSubject(value: TypeItem[]) {
    if (value) {
      this.typeItemListSubject.next(value);
    } else {
      this.typeItemListSubject.next(null);
    }
  }

  /**
   * La fonction getAllTypeItem() est privée car elle n'a besoin d'être appellée que dans le service.
   */
  public getAllTypeItem(): Observable<TypeItem[]> {
    return this.httpClient.get<TypeItem[]>('http://localhost:8080/aperofriends/typeItems/');
  }

  /**
   * La fonction publishItems() est chargée une fois au démarrage de l'application.
   * Elle récupère la liste des Items depuis la base de données et met à jour la liste et la liste observable.
   */
  public publishTypeItems() {
    this.getAllTypeItem().subscribe(
      TypeItemList => {
        this.availableTypeItems = TypeItemList;
        this.availableTypeItems$.next(this.availableTypeItems);
        this.setTypeItemListSubject(this.availableTypeItems);

      });
  }

  /**
   * @param idTypeItem l'id qu'il faut rechercher dans la liste.
   */
  public findTypeItem(typeItemId: number): Observable<TypeItem> {
    if (typeItemId) {
      if (!this.availableTypeItems) {
        return this.getAllTypeItem().pipe(map(typeItems => typeItems.find(typeItem => typeItem.idTypeItem === typeItemId)));
      }
      return of(this.availableTypeItems.find(typeItem => typeItem.idTypeItem === typeItemId));
    } else {
      return of(new TypeItem(0, ''));
    }
  }

  /**
   * @param newTypeItem
   */
  public createTypeItem(newTypeItem: TypeItem) {
    this.httpClient.post<TypeItem>(environment.apiUrl + '/createTypeItem', newTypeItem).subscribe(
      newTypeItem => {
        this.availableTypeItems.push(newTypeItem);
        this.availableTypeItems$.next(this.availableTypeItems);
      }
    )
  }

  /**
   * Fonction de mise à jour d'un Friend
   * @param typeItem
   */
  public updateTypeItem(typeItem: TypeItem) {
    this.httpClient.put<TypeItem>(environment.apiUrl + '/updateTypeItem', typeItem).subscribe(
      updatedItem => {
        this.availableTypeItems$.next(this.availableTypeItems);
      }
    );
  }
}
