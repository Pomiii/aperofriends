import { Component, OnInit } from '@angular/core';
import {Friend} from '../../model/friend';
import {ActivatedRoute, Router} from '@angular/router';
import {FriendService} from '../../service/friend.service';
import {BehaviorSubject} from 'rxjs';

@Component({
  selector: 'app-friend-form',
  templateUrl: './friend-form.component.html',
  styleUrls: ['./friend-form.component.css']
})
export class FriendFormComponent implements OnInit {

  friendList: BehaviorSubject<Friend[]>;
  editFriend: boolean;
  availableFriends: Friend[] = [];
  editedFriend: Friend;

  id: number;

  constructor(private friendService: FriendService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.friendList = this.friendService.availableFriends$;

    this.availableFriends = this.friendService.availableFriends;

    this.id = +this.route.snapshot.params.id;

    this.friendService.findFriend(this.id).subscribe(friend => {
      this.editedFriend = friend;
    });

    if (!this.id) {
      this.editFriend = true;
      this.editedFriend = new Friend(this.id, '', '', '', '');

    } else {
      this.editedFriend = this.friendService.availableFriends.find((fri => fri.idFriend === this.id));
      this.editFriend = false;
      this.friendList = this.editedFriend.friendTab;
    }
    this.router.navigate(['/friend']);
  }

  onSave(){
    if (!this.id) {
      this.friendService.createFriend(this.editedFriend);
      console.log('this.editedFriend ' , this.editedFriend.firstnameFriend);

    } else {
      this.friendService.updateFriend(this.editedFriend);
    }
    // Pour laisser le temps de charger les données
    setTimeout(() => this.router.navigate(['/friend']), 300);
  }
}
