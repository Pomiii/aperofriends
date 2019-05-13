import {BehaviorSubject} from 'rxjs';

export class AccountFriend {

  accountFriendTab: BehaviorSubject<AccountFriend[]>;

  constructor(public idAF: number,
              public nameAccount: string,
              public addressAccount: string,
              public phoneAccount: string) {

  }

}
