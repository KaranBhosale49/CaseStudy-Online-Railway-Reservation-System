import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router} from '@angular/router';
import { HttpClientService, Trains } from '../http-client.service';
import { TraindataService } from '../traindata.service';
import { UserServiceService } from '../user-service.service';
@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.css']
})
export class ReservationComponent implements OnInit {
  [x: string]: any;
  bookSeats=new FormGroup(
    {
      // id: new FormControl('',Validators.required),
      train: new FormControl('',Validators.required),
      startStation: new FormControl('',Validators.required),
      destination:new FormControl('',Validators.required),
      name:new FormControl('',Validators.required),
      age:new FormControl('',Validators.required),
      gender:new FormControl('',Validators.required),
      seats:new FormControl('',Validators.required),
      date: new FormControl('',Validators.required),
      email: new FormControl('',[Validators.required, Validators.email])

    })
    trains: Trains[]=[];
    constructor(private httpClientService: UserServiceService, private router: Router, private httpClientServic: HttpClientService, private httpClientServi: TraindataService) { }
  
    ngOnInit(): void {
      this.httpClientServic.getTrains().subscribe((result)=>{
        console.warn(result)
        this.trains=result
      })
    }
    
    collect()
    {
      this.httpClientService.save(this.bookSeats.value).subscribe((result: any)=>{
      console.warn("result",result);
      (<any>this.router).navigate(["/pnr"])
      alert('Booked your ticket!!')
      })
    }
  }
    
