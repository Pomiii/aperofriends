import {HttpClient} from '@angular/common/http';
import {Friend} from '../model/friend';
import {BehaviorSubject, Observable, of} from 'rxjs';
import {map} from 'rxjs/operators';
import {Injectable} from '@angular/core';

@Injectable ({
  providedIn: 'root'
})

export class FriendService {
  // la liste des Friends
  availableFriends: Friend[];

  // la liste observable que l'on rend visible partout dans l'appli
  availableFriends$: BehaviorSubject<Friend[]>= new BehaviorSubject(this.availableFriends);

  constructor(private httpClient: HttpClient) {

  }

  /**
   * La fonction getAllFriend() est privée car elle n'a besoin d'être appellée que dans le service.
   */
  public getAllFriend(): Observable<Friend[]> {
    console.log('getAllItems' + this.availableFriends)
    return this.httpClient.get<Friend[]>('http://localhost:8080/aperofriends/friends');
  }

  /**
   * La fonction publishClients() est chargée une fois au démarrage de l'application.
   * Elle récupère la liste des Clients depuis la base de données et met à jour la liste et la liste observable.
   */
  public publishFriends() {
    this.getAllFriend().subscribe(
      FriendList => {
        this.availableFriends = FriendList;
        this.availableFriends$.next(this.availableFriends);
      });
  }

  /**

   * @param idFriend l'id qu'il faut rechercher dans la liste.
   */
  public findFriend(idFriend: number): Observable<Friend> {
    if (idFriend) {
      if (!this.availableFriends) {
        return this.getAllFriend().pipe(map(friends => friends.find(friend => friend.idFriend === idFriend)));
      }
      return of(this.availableFriends.find(friend => friend.idFriend === idFriend));
    } else {
      return of(new Friend(0, '', '', ''));
    }
  }

  /**
   * @param newFriend le nouveau friend à créer
   */
  public createFriend(newFriend: Friend) {
    this.httpClient.post<Friend>('http://localhost:8080//aperofriends/createFriend', newFriend).subscribe(
      newFriend => {
        this.availableFriends.push(newFriend);
        this.availableFriends$.next(this.availableFriends);
      }
    )
  }

  /**
   * Fonction de mise à jour d'un Friend
   * @param friend
   */
  public updateFriend(friend: Friend) {
    this.httpClient.put<Friend>('http://localhost:8080//aperofriends/updateFriend', friend).subscribe(
      updatedFriend => {
        this.availableFriends$.next(this.availableFriends);
      }
    );
  }

}
