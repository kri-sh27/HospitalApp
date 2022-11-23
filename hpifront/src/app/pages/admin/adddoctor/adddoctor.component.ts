import { Component, OnInit } from '@angular/core';
import { DoctorService } from 'src/app/services/doctor.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-adddoctor',
  templateUrl: './adddoctor.component.html',
  styleUrls: ['./adddoctor.component.css']
})
export class AdddoctorComponent implements OnInit {
  public doctor = { username: '', password: '', email: '', dob: '', fullName: '', phone: '', speciality: '', timing: '' }
  speciality: any
  public user = {

    username: '',
    fullName: '',
    password: '',
    dob: '',
    maritalstatus: '',
    gender: '',
    address: '',
    email: '',
    phone: '',
  }
  constructor(private us: UserService) { }

  ngOnInit(): void {
    
  }
  onChange(e: any) {

    this.speciality = e.value;

    // console.log(this.gender);

  }
  formSubmit() {

    this.us.addDoctor(this.doctor).subscribe(
      (data) => {
      console.log(data);
    
      Swal.fire('Doctor Registered Successfully', 'success');
    },
     (error) => {
      //error
      console.log(error);
      // alert("something went wrong");
      Swal.fire('Username already present try with another username', 'error');

    }
    )
  }

}
