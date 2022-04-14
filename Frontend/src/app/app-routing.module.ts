import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TrainComponent } from './train/train.component';
import { AddtrainsComponent } from './addtrains/addtrains.component';
import { UpdatetrainsComponent } from './updatetrains/updatetrains.component';
import { ReservationComponent } from './reservation/reservation.component';
import { DetailsComponent } from './details/details.component';
import { AdminComponent } from './admin/admin.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisteruserComponent } from './registeruser/registeruser.component';
import { UserloginComponent } from './userlogin/userlogin.component';
import { UserComponent } from './user/user.component';
import { PnrComponent } from './pnr/pnr.component';
import { TraindataComponent } from './traindata/traindata.component';
import { AuthGuard } from './auth.guard';

const routes: Routes = [
  {path:'',redirectTo:"home",pathMatch:"full"},
  {path:'Trains',component: TrainComponent},
  {path:'update/:id',component: UpdatetrainsComponent},
  {path:'add',component: AddtrainsComponent},
  {path:'bookSeats', component: ReservationComponent},
  {path:'cancel',component: DetailsComponent},
  {path: 'admin',component: AdminComponent},
  {path: 'home', component: HomeComponent},
  {path: 'AdminLogin', component: LoginComponent},
  {path: 'userreg', component: RegisteruserComponent},
  {path: 'userLogin', component: UserloginComponent},
  {path: 'user', component: UserComponent},
  {path: 'pnr', component: PnrComponent},
  {path: 'trainData', component: TraindataComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
