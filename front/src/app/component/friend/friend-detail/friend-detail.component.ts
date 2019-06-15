import { Component, OnInit } from '@angular/core';
import {FriendService} from '../../../service/friend.service';
import {ActivatedRoute, Route, Router} from '@angular/router';
import {Friend} from '../../../model/friend';
import {BehaviorSubject} from 'rxjs';

@Component({
  selector: 'app-friend-detail',
  templateUrl: './friend-detail.component.html',
  styleUrls: ['./friend-detail.component.css']
})
export class FriendDetailComponent implements OnInit {

  availableFriends: Friend[] = [];
  editedFriend: Friend;
  friendList: BehaviorSubject<Friend[]>;
  editFriend: boolean;


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

    this.friendService.findFriend(this.idFriend).subscribe(friend => {
      this.editedFriend = friend;
    });

    if (!this.idFriend) {
      this.editFriend = true;
      this.editedFriend = new Friend(this.idFriend, '', '', '', '');

    } else {
      this.editedFriend = this.friendService.availableFriends.find((fri => fri.idFriend === this.idFriend));
      this.editFriend = false;
    }
  }

  onSave() {

  }

  onDelete(idFriend: number) {
    console.log('Delete Friend component ' + this.availableFriends[0].idFriend);
    this.availableFriends.splice(this.availableFriends.findIndex((FriId) => FriId.idFriend === idFriend), 1);
    this.friendService.deleteFriend(idFriend);
    this.router.navigate(['/friend-detail']);
  }
}
