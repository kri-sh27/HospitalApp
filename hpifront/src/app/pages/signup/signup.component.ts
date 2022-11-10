import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';
// import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  submitted = false;
  gender: any;
  // maritalstatus:any;
  

  
  constructor(private userService: UserService,) { }


  public user = {

    username:'',
    fullName: '',
    password: '',
    dob:'',
    maritalstatus:'',
    gender:'',
    address:'',
    email: '',
    phone: '',
  }
  
  ngOnInit(): void {
  }
  onChange(e:any){
    this.gender=e.value;
    // console.log(this.gender);
  }

  formSubmit() {
    //addUser:userservices
    this.userService.addUser(this.user).subscribe(
      (data:any) => {
        //success
        console.log(this.user.username);
        console.log(data);
        // alert("sucess");
        Swal.fire('User Registered Successfully','User ID is '+ data.id,'success');
      },
      (error) => {
        //error
        console.log(error);
        // alert("something went wrong");
        Swal.fire('something went wrong','error');

      }
    )
  }




}
