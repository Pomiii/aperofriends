import {Bucket} from './bucket';

export class Friend {

  bucketList: Bucket[] = [];

  constructor(public idFriend: number,
              public firstnameFriend: string,
              public lastnameFriend: string,
              public mailFriend: string,
              public phoneFriend: string,
              public passFriend: string) {
  }
}
