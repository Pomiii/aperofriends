import { Component, OnInit } from '@angular/core';
import {Friend} from '../model/friend';
import {FriendService} from '../service/friend.service';
import {Router, ActivatedRoute} from '@angular/router';
import {BehaviorSubject, Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
  styleUrls: ['./friend.component.css']
})
export class FriendComponent implements OnInit {

  availableFriends: Friend[] = [];
  editedFriend: Friend;
  friendList: BehaviorSubject<Friend[]>;

  idFriend: number;

  constructor(private friendService: FriendService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    // Permet d'afficher la liste des Friends
    this.friendService.publishFriends();

    this.friendService.friendListSubject.subscribe(
      (res) => {
        this.availableFriends = res;
        if (res !== null) {
        }
      }
    );

    this.friendList = this.friendService.availableFriends$;

    this.availableFriends = this.friendService.availableFriends;

    this.idFriend = +this.route.snapshot.params.idFriend;

    console.log('friendList ' + this.friendList);

    this.friendService.findFriend(this.idFriend).subscribe(friend => {this.editedFriend = friend; });
  }

  onDelete(idFriend: number) {
    this.availableFriends.splice(this.availableFriends.findIndex((FriId) => FriId.idFriend === idFriend), 1);
    this.friendService.deleteFriend(idFriend);
    this.router.navigate(['/friend']);
  }

}
