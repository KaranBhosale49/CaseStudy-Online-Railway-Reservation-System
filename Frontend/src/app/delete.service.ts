import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';


export class Seats {
  constructor(
    public  _id: String,
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
export class DeleteService {

  constructor(private httpClient: HttpClient) { }

  getCurrentResto(id: string)
  {
    return this.httpClient.get(`${'http://localhost:9001/book/orders'}/${id}`)
  }

  getorders()
  {
    return this.httpClient.get<Seats[]>('http://localhost:9001/book/orders') 
   }

   deleteResto(id: any)
   {
     return this.httpClient.delete<Seats[]>(`${'http://localhost:9001/book/orders/delete'}/${id}`)
   }
}
