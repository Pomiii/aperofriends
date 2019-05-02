import { Component, OnInit } from '@angular/core';
import {Friend} from '../model/friend';
import {FriendService} from '../service/friend.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-friend',
  templateUrl: './friend.component.html',
  styleUrls: ['./friend.component.css']
})
export class FriendComponent implements OnInit {

  friendList: Friend[] = [];
  idFriend: number;
  availableFriends: Friend[] =[];
  editedFriend: Friend;

  constructor(private friendService: FriendService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.availableFriends = this.friendService.availableFriends;

    this.idFriend = +this.route.snapshot.params.idFriend;

    console.log('friend ' + this.friendList);

    this.friendService.getAllFriend().subscribe(friends => this.friendList = friends);

    this.friendService.findFriend(this.idFriend).subscribe(friend => {this.editedFriend = friend;})
  }

}
