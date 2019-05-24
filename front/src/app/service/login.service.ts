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

  userRoles: BehaviorSubject<string> = new BehaviorSubject('');

  constructor(private httpClient: HttpClient, private router: Router) {
    this.getUserRoles();
  }

  public get loggedIn(): boolean {
    return sessionStorage.getItem(environment.accessToken) !== null;
  }

  signIn(friend: Friend) {
    this.httpClient.post<JsonWebToken>(environment.apiUrl + '/sign-in', friend).subscribe(
      token => {
        sessionStorage.setItem(environment.accessToken, token.token);

        this.getUserRoles();

        this.router.navigate(['']);
      },
      error => console.log('Error while Sign In'));
  }

  signUp(friend: Friend) {
    this.httpClient.post<Friend>( environment.apiUrl + '/sign-up', friend).subscribe(
      newFriend => {
      },
      error => console.log('Error while Sign Up'));
  }

   signOut() {
    sessionStorage.removeItem(environment.accessToken);
  }

  private getUserRoles() {
    if (sessionStorage.getItem(environment.accessToken)) {
      const decodedToken = jwt_decode(sessionStorage.getItem(environment.accessToken));
      const authorities: string = decodedToken.auth;
      this.userRoles.next(authorities);
    }
  }
}
