import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { PassengerloginService } from '../passengerlogin.service';

@Component({
  selector: 'app-userlogin',
  templateUrl: './userlogin.component.html',
  styleUrls: ['./userlogin.component.css']
})
export class UserloginComponent implements OnInit {
  x: any;
   siteKey:string;
  adminlog=new FormGroup(
    {
  
        username: new FormControl('',Validators.required),
        password: new FormControl('',Validators.required),
        
    })
    constructor(private http: PassengerloginService,private router:Router) {  this.siteKey="6LfyLQ,cfAAAAAKtvCCNGejBHALZCraJpwkEjrKlN";}
     
    ngOnInit(): void {
      localStorage.setItem('key','token');
    }
    validate()
    {
    
      this.http.saveResto(this.adminlog.value).subscribe((result: any)=>{
      console.warn("result",result)    
       this.x=result
       localStorage.setItem('key',this.x.response)
        console.warn(this.x.response)
        if(this.x.response=="no"){ 
          (<any>this.router).navigate(["/userlogin"])  
        }
        else
        {
          (<any>this.router).navigate(["/user"])
          alert("Welcome");
        }
    })
    }

  } 