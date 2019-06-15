import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlertModule } from 'ngx-bootstrap';
import { HeaderComponent } from './body/header/header.component';
import { AccordionModule } from 'ngx-bootstrap/accordion';
import { ButtonsModule } from 'ngx-bootstrap/buttons';
import { CarouselModule } from 'ngx-bootstrap/carousel';
import { CollapseModule } from 'ngx-bootstrap/collapse';
import { BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { BsDropdownModule } from 'ngx-bootstrap/dropdown';
import { ModalModule } from 'ngx-bootstrap/modal';
import { PaginationModule } from 'ngx-bootstrap/pagination';
import { PopoverModule } from 'ngx-bootstrap/popover';
import { ProgressbarModule } from 'ngx-bootstrap/progressbar';
import { RatingModule } from 'ngx-bootstrap/rating';
import { SortableModule } from 'ngx-bootstrap/sortable';
import { TabsModule } from 'ngx-bootstrap/tabs';
import { TimepickerModule } from 'ngx-bootstrap/timepicker';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { FooterComponent } from './body/footer/footer.component';
import { ItemComponent } from './component/item/item.component';
import { LoginComponent } from './component/login/login.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FriendComponent } from './component/friend/friend.component';
import { ItemDetailComponent } from './component/item/item-detail/item-detail.component';
import { BucketComponent } from './component/bucket/bucket.component';
import { BucketAccountComponent } from './component/bucket/bucket-account/bucket-account.component';
import { NavComponent } from './body/nav/nav.component';
import { ItemFormComponent } from './component/item/item-form/item-form.component';
import { FriendFormComponent } from './component/friend/friend-form/friend-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { JwtInterceptor } from './security/http-interceptor/jwt.interceptor';
import { FriendGuard } from './security/guards/friend.guard';
import { AdminGuard } from './security/guards/admin.guard';
import { FriendDetailComponent } from './component/friend/friend-detail/friend-detail.component';
import { BucketFormComponent } from './component/bucket/bucket-form/bucket-form.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    ItemComponent,
    LoginComponent,
    FriendComponent,
    ItemDetailComponent,
    BucketComponent,
    BucketAccountComponent,
    NavComponent,
    ItemFormComponent,
    FriendFormComponent,
    FriendDetailComponent,
    BucketFormComponent,
  ],
  imports: [
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    AlertModule.forRoot(),
    AccordionModule.forRoot(),
    ButtonsModule.forRoot(),
    CarouselModule.forRoot(),
    CollapseModule.forRoot(),
    BsDatepickerModule.forRoot(),
    BsDropdownModule.forRoot(),
    ModalModule.forRoot(),
    PaginationModule.forRoot(),
    PopoverModule.forRoot(),
    ProgressbarModule.forRoot(),
    RatingModule.forRoot(),
    SortableModule.forRoot(),
    TabsModule.forRoot(),
    TimepickerModule.forRoot(),
    TooltipModule.forRoot()
  ],
  providers: [FriendGuard, AdminGuard, {
    provide: HTTP_INTERCEPTORS,
    useClass: JwtInterceptor,
    multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
