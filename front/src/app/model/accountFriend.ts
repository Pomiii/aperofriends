import {Bucket} from './bucket';

export class AccountFriend {

  constructor(public idAF: number,
              public nameAccount: string,
              public addressAccount: string,
              public buckets: Bucket) {

  }

}
