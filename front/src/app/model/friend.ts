import {Bucket} from './bucket';
import {Item} from './item';
import {BehaviorSubject} from 'rxjs';

export class Friend {

  constructor(public idFriend?: number,
              public firstnameFriend?: string,
              public lastnameFriend?: string,
              public mailFriend?: string,
              public passFriend?: string,
              public bucket?: Item[],
              public role?: string[]) {
  }
}
