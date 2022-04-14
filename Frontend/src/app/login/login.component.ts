import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AserviceService } from '../aservice.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  x: any;

  admin=new FormGroup(
    {
        username: new FormControl('', Validators.required),
        password: new FormControl('',Validators.required)
        
    })
    constructor(private http: AserviceService,private router:Router) { }
  
    ngOnInit(): void {
    }
    validate()
    {
      this.http.save(this.admin.value).subscribe((result: any)=>{
      console.warn("result",result)    
        this.x=result
        console.warn(this.x.response)

        if(this.x.response=="no"){
          
          (<any>this.router).navigate(["/AdminLogin"])  
          alert("enter correct password");
        }
        else if(this.admin.value.username=='karan'&& this.admin.value.password=='karan')
        {
          
          (<any>this.router).navigate(["/admin"]) 
          alert("Welcome Karan");
                
        }
    })
    }
  }
    
