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
  

  
  constructor(private userService: UserService,) { }


  public user = {

    fullName: '',
    password: '',
    // dob:Date='',
    dob:'',
    maritalstatus:'',
    gender:'',
    address:'',
    email: '',
    phone: '',
  }
  
  ngOnInit(): void {
  }


  formSubmit() {
    // alert('submit')
    // console.log(this.user);
    // if (this.user.fullName == '' || this.user.fullName == null) {
    //   // alert('User is requirsd');
    //   Swal.fire('User Name Requird','info');
    //   return;
    // }
    // else if(this.user.email == '' || this.user.email == null)
    // {
    //   // alert('Email is requird');
    //   Swal.fire('Email is requird','info');
    //   return;
    // }
    // else if(this.user.dob == '' || this.user.dob == null)
    // {
    //   // alert('Email is requird');
    //   Swal.fire('date is requird','info');
    //   return;
    // }
    // else if(this.user.maritalstatus == '' || this.user.maritalstatus == null)
    // {
    //   // alert('Email is requird');
    //   Swal.fire('maritalstatus is requird','info');
    //   return;
    // }
    // else if(this.user.gender == '' || this.user.gender == null)
    // {
    //   // alert('Email is requird');
    //   Swal.fire('maritalstatus is requird','info');
    //   return;
    // }
    // else if(this.user.address == '' || this.user.address == null)
    // {
    //   // alert('Email is requird');
    //   Swal.fire('maritalstatus is requird','info');
    //   return;
    // }
    // else if(this.user.password == '' || this.user.password == null)
    // {
    //   // alert('Email is requird');
    //   Swal.fire('Password is requird','info');
    //   return;
    // }
    // else if(this.user.phone == '' || this.user.phone == null)
    // {
    //   Swal.fire('Phone Number  is requird','info');
    //   return;
    // }
  

    //addUser:userservices
    this.userService.addUser(this.user).subscribe(
      (data:any) => {
        //success
        console.log(this.user.fullName);
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
