import { Component, OnInit } from '@angular/core';
import {ItemService} from '../service/item.service';
import {AccountFriendService} from '../service/accountFriendService';
import {AccountFriend} from '../model/accountFriend';
import {Item} from '../model/item';
import {BehaviorSubject} from 'rxjs';
import {ActivatedRoute, Router} from '@angular/router';
import {Friend} from '../model/friend';

@Component({
  selector: 'app-account-friends',
  templateUrl: './account-friends.component.html',
  styleUrls: ['./account-friends.component.css']
})
export class AccountFriendsComponent implements OnInit {

  availableAccountFriends: AccountFriend[] = [];
  editedAccountFriend: AccountFriend;
  editAccountFriend: boolean;
  accountFriendList: BehaviorSubject<AccountFriend[]>;

  idAF: number;

  constructor(private accountFriendService: AccountFriendService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    // Permet d'afficher la liste des Friends
    this.accountFriendService.publishAccountFriends();

    this.accountFriendService.accountFriendListSubject.subscribe(
      (res) => {
        this.availableAccountFriends = res;
        if (res !== null) {
        }
      }
    );

    this.accountFriendList = this.accountFriendService.availableAccountFriends$;

    this.availableAccountFriends = this.accountFriendService.availableAccountFriends;

    this.idAF = +this.route.snapshot.params.idAF;

    this.accountFriendService.findAccountFriend(this.idAF).subscribe(accountFriend => {
      this.editedAccountFriend = accountFriend;
    });

    if (!this.idAF) {
      this.editAccountFriend = true;
      this.editedAccountFriend = new AccountFriend(this.idAF, '', '', '');
    } else {
      this.editedAccountFriend = this.accountFriendService.availableAccountFriends.find((af => af.idAF === this.idAF));
      this.editAccountFriend = false;
    }
    this.router.navigate(['/accountFriend']);

  }

  onSave(){
    if (!this.idAF) {
      this.accountFriendService.createAccountFriend(this.editedAccountFriend);
      console.log('this.editedAccountFriend ' , this.editedAccountFriend.nameAccount);

    } else {
      this.accountFriendService.updateAccountFriend(this.editedAccountFriend);
    }
    // Pour laisser le temps de charger les données
    setTimeout(() => this.router.navigate(['/accountFriend']), 300);
  }

  onDelete(idAF: number) {
    this.availableAccountFriends.splice(this.availableAccountFriends.findIndex((AfId) => AfId.idAF === idAF), 1);
    console.log('onDelete AccountFriend idAF ' + idAF);
    this.accountFriendService.deleteAccountFriend(idAF);
    this.router.navigate(['/accountFriend']);
  }

}
