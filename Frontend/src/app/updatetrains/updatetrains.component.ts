import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { HttpClientService } from '../http-client.service';

@Component({
  selector: 'app-updatetrains',
  templateUrl: './updatetrains.component.html',
  styleUrls: ['./updatetrains.component.css']
})
export class UpdatetrainsComponent implements OnInit {
  Train:any;
  
  editResto=new FormGroup(
    {
      train_id: new FormControl('', Validators.required),
      train_name: new FormControl('',Validators.required),
      from: new FormControl('',Validators.required),
      to:new FormControl('',Validators.required) ,
      cost: new FormControl('',Validators.required),
      seats: new FormControl('',Validators.required)
    })

  constructor(private router:ActivatedRoute,private http: HttpClientService) { }

  ngOnInit(): void {
    this.http.getCurrentResto(this.router.snapshot.params['id']).subscribe((result: any)=>{
   console.warn("result",result)
   this.editResto.patchValue({
    train_id: result.train_id,
    train_name: result.train_name,
    from:result.from,
    to:result.to,
    cost: result.cost,
    seats: result.seats
   })
  }

  )
  }
  collection()
  {
    this.http.updateResto(this.router.snapshot.params['id'],this.editResto.value).subscribe((result: any)=>{
      alert("Updated the train details");
      (<any>this.router).navigate("/Trains");
    })
  }

}
