import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {LoginService} from '../service/login.service';
import {Friend} from '../model/friend';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginForm = this.fb.group({
    username: [null, Validators.required],
    password: [null, Validators.compose([
      Validators.required, Validators.minLength(5), Validators.maxLength(255)])
    ]
  });

  constructor(private fb: FormBuilder,
              private loginService: LoginService,
  ) {}

  onSubmit() {
    const friend = new Friend();
    friend.mailFriend = this.loginForm.value.maiFriend;
    friend.passFriend = this.loginForm.value.passFriend;
    this.loginService.signIn(friend);
  }

}
