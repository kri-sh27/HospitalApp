import { Component, OnInit } from '@angular/core';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-adddoctor',
  templateUrl: './adddoctor.component.html',
  styleUrls: ['./adddoctor.component.css']
})
export class AdddoctorComponent implements OnInit {
  public doctor={username:'',password:'',fullName:'',phoneNo:'',speciality:'',timing:''}
  speciality:any
  constructor(private ds:DoctorService) { }

  ngOnInit(): void {
  } 
  onChange(e:any){

    this.speciality=e.value;

    // console.log(this.gender);

  }
  formSubmit(){

    this.ds.registerDoctor(this.doctor).subscribe((data)=>{
      console.log(data);
    });
  
  }

}
