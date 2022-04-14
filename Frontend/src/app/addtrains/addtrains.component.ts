import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClientService } from '../http-client.service';

@Component({
  selector: 'app-addtrains',
  templateUrl: './addtrains.component.html',
  styleUrls: ['./addtrains.component.css']
})
export class AddtrainsComponent implements OnInit {
  Train:any;

  addTrains=new FormGroup(
    {
        train_id: new FormControl('', Validators.required),
        train_name: new FormControl('',Validators.required),
        from: new FormControl('',Validators.required),
        to:new FormControl('',Validators.required) ,
        cost: new FormControl('',Validators.required),
        seats: new FormControl('',Validators.required)
    })
    constructor(private httpClientService: HttpClientService,
    private router: Router) { }
  
    ngOnInit(): void {
    }
    Trains()
    {
      this.httpClientService.Train(this.addTrains.value).subscribe((result: any)=>{
      console.warn("result",result)
      alert("Train is added into the list");
      (<any>this.router).navigate(["/Trains"]);
    })

    }
  
  }


  