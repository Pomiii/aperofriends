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

  constructor() { }

  ngOnInit() {
  }



}
