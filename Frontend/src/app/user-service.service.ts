import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';


export class orders {
  constructor(
    // public  _id: String,
    public  train: String,
    public  startStation: String,
    public  destination: String,
    public  name:String,
  	public  age:String,
  	public  gender:String,
	  public  seats:String,
    public  date:String,
    public  email:String
  ) {
  }
}
@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private httpClient: HttpClient) {
 }
 save(data: any)
  {
     return this.httpClient.post<orders[]>('http://localhost:9001/book/orders/addorder',data)
  }
}
