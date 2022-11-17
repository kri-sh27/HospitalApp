import { Component, OnInit } from '@angular/core';
import { AppointmentlistforadminService } from 'src/app/services/appointmentlistforadmin.service';

@Component({
  selector: 'app-appointmentlistforadmin',
  templateUrl: './appointmentlistforadmin.component.html',
  styleUrls: ['./appointmentlistforadmin.component.css']
})
export class AppointmentlistforadminComponent implements OnInit {

  constructor(private ap:AppointmentlistforadminService) { }
 appointmentlist:any;
  ngOnInit(): void {
  this.getAllAppointmentForAdmin();
  }

  getAllAppointmentForAdmin(){
    this.ap.getAllAppointmentForAdmin().subscribe((res)=>{
      console.log(res);
      this.appointmentlist=res;
    })

  }

}
