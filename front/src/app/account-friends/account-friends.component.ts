import { Component, OnInit } from '@angular/core';
import {ItemService} from '../service/item.service';
import {AccountFriendService} from '../service/accountFriendService';
import {AccountFriend} from '../model/accountFriend';
import {Item} from '../model/item';

@Component({
  selector: 'app-account-friends',
  templateUrl: './account-friends.component.html',
  styleUrls: ['./account-friends.component.css']
})
export class AccountFriendsComponent implements OnInit {


  availableItems: Item[] = [];

  accountFriendList: AccountFriend[] = [];

  constructor(private accountFriendService: AccountFriendService) { }

  ngOnInit() {
    this.accountFriendService.getAllAccountFriend().subscribe(accountFriends => this.accountFriendList = accountFriends);
    console.log('this.itemList ' + this.accountFriendList);
  }

}
