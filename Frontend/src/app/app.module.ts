import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClientModule} from '@angular/common/http'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AddtrainsComponent } from './addtrains/addtrains.component';
import { AdminComponent } from './admin/admin.component';
import { DetailsComponent } from './details/details.component';
import { HomeComponent } from './home/home.component';
import { PnrComponent } from './pnr/pnr.component';
import { RegisteruserComponent } from './registeruser/registeruser.component';
import { ReservationComponent } from './reservation/reservation.component';
import { TrainComponent } from './train/train.component';
import { TraindataComponent } from './traindata/traindata.component';
import { UpdatetrainsComponent } from './updatetrains/updatetrains.component';
import { UserComponent } from './user/user.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatButtonModule} from "@angular/material/button"
import { NgxCaptchaModule } from 'ngx-captcha';
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddtrainsComponent,
    AdminComponent,
    DetailsComponent,
    HomeComponent,
    PnrComponent,
    RegisteruserComponent,
    ReservationComponent,
    TrainComponent,
    TraindataComponent,
    UpdatetrainsComponent,
    UserComponent,
    UserloginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    BrowserAnimationsModule,
    MatButtonModule,
    NgxCaptchaModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
