import { Component, OnInit } from '@angular/core';
import {BucketService} from '../service/bucketService';
import {Friend} from '../model/friend';
import {Item} from '../model/item';
import {Bucket} from '../model/bucket';
import {LoginService} from '../service/login.service';
import {BehaviorSubject} from 'rxjs';
import {FriendService} from '../service/friend.service';

@Component({
  selector: 'app-bucket',
  templateUrl: './bucket.component.html',
  styleUrls: ['./bucket.component.css']
})
export class BucketComponent implements OnInit {

  friendBucket: Bucket;
  availableBuckets: Bucket[] = [];
  bucketList: BehaviorSubject<Bucket[]>;


  constructor(private bucketService: BucketService,
              private friendService: FriendService,
              private loginService: LoginService) { }

  ngOnInit() {
    // Permet d'afficher la liste des Friends
    this.bucketService.publishBuckets();

    this.bucketService.bucketListSubject.subscribe(
      (res) => {
        this.availableBuckets = res;
        if (res !== null) {
        }
      }
    );

    this.bucketList = this.bucketService.availableBuckets$;

    console.log(this.bucketList);
  //  console.log(this.bucketList[this.bucketService.bucketFriend]);
    /* this.loginService..subscribe(res => {
      this.username = res;
    });
    this.commandService.commandSubject.subscribe(res => {
      this.command = res;
    });*/
  }

  onPay() {

  }

}
