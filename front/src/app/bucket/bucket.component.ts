import { Component, OnInit } from '@angular/core';
import {BucketService} from '../service/bucketService';
import {Friend} from '../model/friend';
import {Item} from '../model/item';
import {Bucket} from '../model/bucket';
import {LoginService} from '../service/login.service';

@Component({
  selector: 'app-bucket',
  templateUrl: './bucket.component.html',
  styleUrls: ['./bucket.component.css']
})
export class BucketComponent implements OnInit {

  friendBucket: Bucket;

  constructor(private bucketService: BucketService,
              private loginService: LoginService) { }

  ngOnInit() {
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
