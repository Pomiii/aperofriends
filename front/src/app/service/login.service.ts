import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Friend} from '../model/friend';
import {JsonWebToken} from '../model/jwt';
import {Router} from '@angular/router';
import {environment} from '../../environments/environment';
import * as jwt_decode from 'jwt-decode';
import {BehaviorSubject} from 'rxjs';
import {Bucket} from '../model/bucket';
import {BucketService} from './bucketService';
import {Item} from '../model/item';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  itemList : Item[] = [];

  signInError = false;

  signUpError = false;

  userRoles: BehaviorSubject<string> = new BehaviorSubject('');

  constructor(private httpClient: HttpClient,
              private router: Router,
              private bucketService: BucketService) {
    this.getUserRoles();
  }

  public get loggedIn(): boolean {
    return sessionStorage.getItem(environment.accessToken) !== null;
  }

  signIn(friend: Friend) {
    sessionStorage.removeItem(environment.accessToken);
    this.httpClient.post<JsonWebToken>(environment.apiUrl + '/sign-in', friend).subscribe(
      token => {
        sessionStorage.setItem(environment.accessToken, token.token);

        this.bucketService.initBucket(friend.mailFriend);
        console.log('SignIn: ' + friend.mailFriend);
        this.bucketService.setBucketItemsSubject(this.bucketService.listItemValues);
        this.router.navigate(['']);
      },
      error => {
        console.log('Error while Sign In');
        this.signInError = true;
      });
  }

  signUp(friend: Friend) {
    this.httpClient.post<Friend>( environment.apiUrl + '/sign-up', friend).subscribe(
      newFriend => {
        console.log('SignUp: ' + friend.mailFriend + ' ' + friend.idFriend  + ' ' + friend.firstnameFriend);
      },
      error => {
        console.log('Error while Sign Up');
        this.signUpError = true;
      });
  }

   signOut() {
    sessionStorage.removeItem(environment.accessToken);
    console.log('Sign Out ')
    this.router.navigate(['']);
   }

  private getUserRoles() {
    if (sessionStorage.getItem(environment.accessToken)) {
      const decodedToken: any = jwt_decode(sessionStorage.getItem(environment.accessToken));
      const authorities: string = decodedToken.auth;
      this.userRoles.next(authorities);
    }
  }

}
