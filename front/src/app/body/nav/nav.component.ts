import { Component, OnInit } from '@angular/core';
import {LoginService} from '../../service/login.service';
import {AdminGuard} from '../../security/guards/admin.guard';
import {FriendGuard} from '../../security/guards/friend.guard';

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
