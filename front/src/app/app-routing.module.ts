import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ItemComponent} from './component/item/item.component';
import {ItemDetailComponent} from './component/item/item-detail/item-detail.component';
import {FriendComponent} from './component/friend/friend.component';
import {BucketComponent} from './component/bucket/bucket.component';
import {LoginComponent} from './component/login/login.component';
import {FriendFormComponent} from './component/friend/friend-form/friend-form.component';
import {AdminGuard} from './security/guards/admin.guard';
import {FriendDetailComponent} from './component/friend/friend-detail/friend-detail.component';
import {ItemFormComponent} from './component/item/item-form/item-form.component';
import {BucketAccountComponent} from './component/bucket/bucket-account/bucket-account.component';

const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: '', component: ItemComponent},
  {path: 'item-detail', component: ItemDetailComponent},
  {path: 'item-form', component: ItemFormComponent, canActivate: [AdminGuard]},
  {path: 'friend', component: FriendComponent},
  {path: 'friend-detail', component: FriendDetailComponent},
  {path: 'friend-form', component: FriendFormComponent},
  {path: 'bucket', component: BucketComponent},
  {path: 'bucket-account', component: BucketAccountComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
