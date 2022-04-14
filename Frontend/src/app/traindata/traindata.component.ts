import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TraindataService, Trains } from '../traindata.service';
@Component({
  selector: 'app-traindata',
  templateUrl: './traindata.component.html',
  styleUrls: ['./traindata.component.css']
})
export class TraindataComponent implements OnInit {
  [x: string]: any;

  trains: Trains[] = [];

  constructor(private httpClientService: TraindataService) { }

  ngOnInit(): void {
    this.httpClientService.getTrains().subscribe((result)=>{
      
      this.trains=result
    })
  }

}
