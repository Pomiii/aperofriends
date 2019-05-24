import { Component, OnInit } from '@angular/core';
import {FormBuilder, Validators} from '@angular/forms';
import {LoginService} from '../service/login.service';
import {Friend} from '../model/friend';
import {Router} from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm = this.fb.group({
    mailFriend: [null, Validators.required],
    passFriend: [null, Validators.compose([
      Validators.required, Validators.minLength(5), Validators.maxLength(255)])
    ]
  });

  signIn = false;

  constructor(private fb: FormBuilder,
              private loginService: LoginService,
              private router: Router
  ) {}

  ngOnInit(): void {
  }

  onSubmit() {
    const friend = new Friend();
    friend.mailFriend = this.loginForm.value.mailFriend;
    friend.passFriend = this.loginForm.value.passFriend;
    this.loginService.signIn(friend);
    this.router.navigate(['/item']);
  }

}
