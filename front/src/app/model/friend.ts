import {Bucket} from './bucket';
import {BehaviorSubject} from 'rxjs';

export class Friend {

  bucketList: Bucket[] = [];
  friendTab: BehaviorSubject<Friend[]>;

  constructor(public idFriend: number,
              public firstnameFriend: string,
              public lastnameFriend: string,
              public mailFriend: string,
              public passFriend: string) {
  }
}
