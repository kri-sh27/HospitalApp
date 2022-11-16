import { HttpResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AppointmentlistService } from 'src/app/services/appointmentlist.service';

@Component({
  selector: 'app-appointmentlist',
  templateUrl: './appointmentlist.component.html',
  styleUrls: ['./appointmentlist.component.css']
})
export class AppointmentlistComponent implements OnInit {

  constructor(private appointmentservice:AppointmentlistService) { }
   appointlist: any;
    ngOnInit(): void {
      this.getAllAppointments();

  }
  getAllAppointments(){this.appointmentservice.getAllAppointments().subscribe((aptlist)=>{
    this.appointlist= aptlist.body;
    console.log((this.appointlist));
  })
  }

}

