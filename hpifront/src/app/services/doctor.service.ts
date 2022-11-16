import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './healper';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http:HttpClient) { }

  getAllDoctors(){
    return this.http.get<any>(`${baseUrl}/getalldoctors`)
  }
  
   registerDoctor(doctor: any) {
    console.log(doctor);
    return this.http.post(`${baseUrl}/createdoctor`, doctor);
  }
}
