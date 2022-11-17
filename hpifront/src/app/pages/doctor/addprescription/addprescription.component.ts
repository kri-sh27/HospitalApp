import { Component, OnInit } from '@angular/core';
import { AddprescriptionService } from 'src/app/services/addprescription/addprescription.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-addprescription',
  templateUrl: './addprescription.component.html',
  styleUrls: ['./addprescription.component.css']
})
export class AddprescriptionComponent implements OnInit {

  constructor(private addprescription:AddprescriptionService) { }

 addprescriptionandfees={
  "id":'',
  "prescription":"",
  "charges":""
 }
  ngOnInit(): void {
  }


  formSubmit() {
    // alert('submit')
    console.log(this.addprescriptionandfees);
    if (this.addprescriptionandfees.id == null) {
      // alert('User is requirsd');
      Swal.fire('id is Requird','info');
      return;
    }
    else if(this.addprescriptionandfees.prescription == '' || this.addprescriptionandfees.prescription == null)
    {
      // alert('Email is requird');
      Swal.fire('Prescription is required','info');
      return;
    }
  //add rescription
    this.addprescription.addprescription(this.addprescriptionandfees).subscribe(
      (data:any) => {
        //success
        console.log(this.addprescriptionandfees.id);
        console.log(data);
        // alert("sucess");
        Swal.fire('presciption added Successfully','success');
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
