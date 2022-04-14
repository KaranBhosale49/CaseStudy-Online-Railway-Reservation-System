import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

export class userlogin {
  constructor(
    public  username: String,
    public  password: String,
  ) {
  }
}
@Injectable({
  providedIn: 'root'
})
export class PassengerloginService {

  constructor(private httpClient: HttpClient) {
  }
  saveResto(data: any)
   {
      return this.httpClient.post<userlogin[]>('http://localhost:9006/Secure/auth',data)
   }
//     //for login
//  loginUser(token:any){
//     localStorage.setItem("token",token);
//     return true;
//   }
//   //to check user is loggedin or not
//   isLoggedIn(){
//     let token = localStorage.getItem("token");
//     if(token== undefined || token==='' || token==null){
//       return false;
//     } else{
//       return true;
//     }
//   }
//   //to logout user
//   logout(){
//     localStorage.removeItem("token");
//     return true;
//   }
}
