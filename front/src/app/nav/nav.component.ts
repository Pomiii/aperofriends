import { Component, OnInit } from '@angular/core';
import {LoginService} from '../service/login.service';
import {AdminGuard} from '../guards/admin.guard';
import {FriendGuard} from '../guards/friend.guard';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(private loginService: LoginService
              ) { }

  ngOnInit() {
  }

}
