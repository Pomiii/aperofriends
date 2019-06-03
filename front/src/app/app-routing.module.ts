import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ItemComponent} from './item/item.component';
import {ItemDetailComponent} from './item/item-detail/item-detail.component';
import {FriendComponent} from './friend/friend.component';
import {BucketComponent} from './bucket/bucket.component';
import {AccountFriendsComponent} from './account-friends/account-friends.component';
import {LoginComponent} from './login/login.component';
import {FriendFormComponent} from './friend/friend-form/friend-form.component';
import {AdminGuard} from './guards/admin.guard';
import {FriendDetailComponent} from './friend/friend-detail/friend-detail.component';
import {ItemFormComponent} from './item/item-form/item-form.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: ItemComponent},
  {path: 'item-detail', component: ItemDetailComponent, canActivate: [AdminGuard]},
  {path: 'item-form', component: ItemFormComponent, canActivate: [AdminGuard]},
  {path: 'friend-detail', component: FriendDetailComponent},
  {path: 'friend-form', component: FriendFormComponent},
  {path: 'bucket', component: BucketComponent},
  {path: 'accountFriend', component: AccountFriendsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
