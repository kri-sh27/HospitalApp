import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './healper';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  constructor(private http:HttpClient) { }
  public addappointment(appointment:any){
    console.log(appointment);
    return this.http.post(`${baseUrl}/api/v1/appointments`,appointment)
  }
}
