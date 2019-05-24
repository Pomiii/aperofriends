import {HttpClient} from '@angular/common/http';
import {Friend} from '../model/friend';
import {BehaviorSubject, Observable, of} from 'rxjs';
import {map} from 'rxjs/operators';
import {Injectable} from '@angular/core';
import {AccountFriend} from '../model/accountFriend';
import {Bucket} from '../model/bucket';
import {environment} from '../../environments/environment';

@Injectable ({
  providedIn: 'root'
})

export class AccountFriendService {
  // la liste des Friends
  availableAccountFriends: AccountFriend[];

  // la liste observable que l'on rend visible partout dans l'appli
  availableAccountFriends$: BehaviorSubject<AccountFriend[]> = new BehaviorSubject(this.availableAccountFriends);

  constructor(private httpClient: HttpClient) {

  }

  public accountFriendListSubject: BehaviorSubject<AccountFriend[]> = new BehaviorSubject(null);

  public setAccountFriendListSubject(value: AccountFriend[]) {
    if (value) {
      this.accountFriendListSubject.next(value);
    } else {
      this.accountFriendListSubject.next(null);
    }
  }

  /**
   * La fonction getAllFriend() est privée car elle n'a besoin d'être appellée que dans le service.
   */
  public getAllAccountFriend(): Observable<AccountFriend[]> {
    console.log('getAllAccountFriends' + this.availableAccountFriends);
    return this.httpClient.get<AccountFriend[]>(environment.apiUrl + '/accountFriends');
  }

  /**
   * La fonction publishClients() est chargée une fois au démarrage de l'application.
   * Elle récupère la liste des Clients depuis la base de données et met à jour la liste et la liste observable.
   */
  public publishAccountFriends() {
    this.getAllAccountFriend().subscribe(
      accountFriendList => {
        this.availableAccountFriends = accountFriendList;
        this.availableAccountFriends$.next(this.availableAccountFriends);
        this.setAccountFriendListSubject(this.availableAccountFriends);
      });
  }

  /**
   * @param idAF l'id qu'il faut rechercher dans la liste.
   */
  public findAccountFriend(AFid: number): Observable<AccountFriend> {
    if (AFid) {
      if (!this.availableAccountFriends) {
        return this.getAllAccountFriend().pipe(map(accountFriends => accountFriends.find(accountFriend => accountFriend.idAF === AFid)));
      }
      return of(this.availableAccountFriends.find(accountFriend => accountFriend.idAF === AFid));
    } else {
      return of(new AccountFriend(0, '', '', ''));
    }
  }

  /**
   * @param newAccountFriend le nouveau friend à créer
   */
  public createAccountFriend(newAccountFriend: AccountFriend) {
    this.httpClient.post<AccountFriend>(environment.apiUrl + '/createAccountFriend/'
      + newAccountFriend.nameAccount + '/'
      + newAccountFriend.addressAccount + '/'
      + newAccountFriend.phoneAccount, null).subscribe(
      newAccountFriend => {
        this.availableAccountFriends.push(newAccountFriend);
        this.availableAccountFriends$.next(this.availableAccountFriends);
      }
    );
  }

  /**
   * Fonction de mise à jour
   * @param accountFriend
   */
  public updateAccountFriend(accountFriend: AccountFriend) {
    this.httpClient.put<AccountFriend>(environment.apiUrl + '/updateAccountFriend/', accountFriend).subscribe(
      updatedAccountFriend => {
        this.availableAccountFriends$.next(this.availableAccountFriends);
      }
    );
  }

  /**
   * Fonction de suppression
   * @param idAF
   */
  public deleteAccountFriend(idAF: number) {
    this.httpClient.delete(environment.apiUrl + '/deleteAccountFriend/' + idAF).subscribe(

    );
  }
}
