import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Friend} from '../model/friend';
import {JsonWebToken} from '../model/jwt';
import {Router} from '@angular/router';
import {environment} from '../../environments/environment';
import * as jwt_decode from 'jwt-decode';
import {BehaviorSubject} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  friendRoles: BehaviorSubject<string[]> = new BehaviorSubject([]);

  constructor(private httpClient: HttpClient, private router: Router) {
    this.getFriendRoles();
  }

  public get loggedIn(): boolean {
    return sessionStorage.getItem(environment.accessToken) !== null;
  }

  signIn(friend: Friend) {
    this.httpClient.post<JsonWebToken>(environment.apiUrl + 'friend/sign-in', friend).subscribe(
      token => {
        sessionStorage.setItem(environment.accessToken, token.token);

        this.getFriendRoles();

        this.router.navigate(['']);
      },
      error => console.log('Error while login'));
  }


  signOut() {
    sessionStorage.removeItem(environment.accessToken);
  }

  private getFriendRoles() {
    if (sessionStorage.getItem(environment.accessToken)) {
      const decodedToken = jwt_decode(sessionStorage.getItem(environment.accessToken));
      // @ts-ignore
      const authorities: Array<any> = decodedToken.auth;
      this.friendRoles.next(authorities.map(authority => authority.authority));
    }
  }
}
