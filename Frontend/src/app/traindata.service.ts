import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

export class Trains {
  constructor(
    public  train_id: number,
    public  train_name: String,
    public  from: String,
    public  to: String,
    public  cost: number,
    public  seats:number
  ) {
  }
}

@Injectable({
  providedIn: 'root'
})

export class TraindataService{
  [x: string]: any;
  constructor(
    private httpClient: HttpClient
  ) { }

  getTrains(){
      return this.httpClient.get<Trains[]>('http://localhost:9000/admincontrols/Trains');
  }
  
  updateResto(data:any)
  {
    return this.httpClient.post<Trains[]>('http://localhost:9000/admincontrols/regexfrom',data)
  }

  updateRest(data:any)
  {
    return this.httpClient.post<Trains[]>('http://localhost:9000/admincontrols/regexto',data)
  }

}