import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ItemComponent} from './item/item.component';
import {ItemDetailComponent} from './item/item-detail/item-detail.component';
import {FriendComponent} from './friend/friend.component';
import {BucketComponent} from './bucket/bucket.component';
import {AccountFriendsComponent} from './account-friends/account-friends.component';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  {path: '', component: ItemComponent},
  {path: 'item', component: ItemComponent},
  {path: 'item-detail', component: ItemDetailComponent},
  {path: 'item/:id', component: ItemDetailComponent},
  {path: 'friend', component: FriendComponent},
  {path: 'bucket', component: BucketComponent},
  {path: 'accountFriend', component: AccountFriendsComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
