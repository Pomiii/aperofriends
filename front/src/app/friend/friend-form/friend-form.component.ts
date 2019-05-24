import { Component, OnInit } from '@angular/core';
import {Friend} from '../../model/friend';
import {ActivatedRoute, Router} from '@angular/router';
import {FriendService} from '../../service/friend.service';
import {BehaviorSubject} from 'rxjs';
import {FormBuilder, Validators} from '@angular/forms';
import {Bucket} from '../../model/bucket';
import {LoginService} from '../../service/login.service';

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

  signUpForm = this.fb.group({
    firstnameFriend: [null, Validators.required],
    lastnameFriend: [null, Validators.required],
    mailFriend: [null, Validators.required],
    passFriend: [null, Validators.compose([
      Validators.required, Validators.minLength(5), Validators.maxLength(255)])
    ]
  });
  signUp = false;

  newFriend: Friend;

  id: number;

  constructor(private friendService: FriendService,
              private loginService: LoginService,
              private fb: FormBuilder,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    this.newFriend = new Friend(0, '' , '', '', '', null, null);

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

  onSubmit(){
    if (!this.id) {
      const friend = new Friend(0, '' , '', '', '', null, null);
      friend.firstnameFriend = this.signUpForm.value.firstnameFriend;
      friend.lastnameFriend = this.signUpForm.value.lastnameFriend;
      friend.mailFriend = this.signUpForm.value.mailFriend;
      friend.passFriend = this.signUpForm.value.passFriend;
      this.loginService.signUp(friend);
      console.log('Sign Up new Friend = ', friend.mailFriend);

    } else {
      this.friendService.updateFriend(this.editedFriend);
    }
    // Pour laisser le temps de charger les données
    setTimeout(() => this.router.navigate(['/friend']), 300);
  }

  addFriend() {
    this.friendService.addFriend(this.newFriend);
  }
}
