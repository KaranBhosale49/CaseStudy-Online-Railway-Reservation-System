import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

export class Seats {
  constructor(
    public  id: String,
    public  train: String,
    public  startStation: String,
    public  destination: String,
    public  date: String,
    public  name:String,
  	public  age:String,
  	public  gender:String,
	  public  seats:String,
    public  email:String,
  ) {
  }
}


@Injectable({
  providedIn: 'root'
})
export class PnrService {
  constructor(private httpClient: HttpClient) { }

  getorders()
  {
    return this.httpClient.get<Seats[]>('http://localhost:9001/book/orders') 
   } 
}





