import { Component, OnInit } from '@angular/core';
// import { MatSnackBar } from '@angular/material/snack-bar';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  loginData = {
    email: '',
    password: '',
  }
  constructor() { }

  ngOnInit(): void {
  }

  formSubmit() {
    console.log('Submit Button clicked');

    if (this.loginData.email.trim() == '' || this.loginData.email == null) {
      Swal.fire('Email is requird', 'error'); return;
    }

    else if (this.loginData.password.trim() == '' || this.loginData.password == null) {
      Swal.fire('password is requird', 'error'); return;
    }

  }
}
