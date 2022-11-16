import { Component, OnInit } from '@angular/core';
import { AppointmentService } from 'src/app/services/appointment.service';
import { DoctorService } from 'src/app/services/doctor.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-appointment',
  templateUrl: './appointment.component.html',
  styleUrls: ['./appointment.component.css']
})
export class AppointmentComponent implements OnInit {

  constructor(private appointmentservice:AppointmentService,private ds:DoctorService) { }

  public appointment={
    "id": '',
    "createdAt": '',
    "appointmentDate": '',
    "appointmentStartTime": '',
    "appointmentEndTime": '',
    "nameOfDoctor": '',
    "status": '',
    "price": ''
}
list:any[]=[]
  ngOnInit(): void {
    this.getdoctor();
  }

  getprice(){
    for (let i=0;i<this.list.length;i++){
      if (this.list[i].name==this.appointment.nameOfDoctor)
      this.appointment.price=this.list[i].price.toString();
    }
  }
  getdoctor(){
    this.ds.getdoctor().subscribe((data:any)=>this.list=data);
  }

  formSubmit() {
    // alert('submit')
    console.log(this.appointment);
    if (this.appointment.id == null) {
      // alert('User is requirsd');
      Swal.fire('id is Requird','info');
      return;
    }
    else if(this.appointment.appointmentDate == '' || this.appointment.appointmentDate == null)
    {
      // alert('Email is requird');
      Swal.fire('Date is required','info');
      return;
    }
    //addUser:userservices
    this.appointmentservice.addappointment(this.appointment).subscribe(
      (data:any) => {
        //success
        console.log(this.appointment.id);
        console.log(data);
        // alert("sucess");
        Swal.fire('Booked Successfully','success');
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
