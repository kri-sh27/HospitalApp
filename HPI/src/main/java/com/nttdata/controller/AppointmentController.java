package com.nttdata.controller;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.nttdata.model.Appointment;
import com.nttdata.model.Doctor;
import com.nttdata.repository.AppointmentRepository;
import com.nttdata.repository.DoctorRepository;
import com.nttdata.service.AppointmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    @Autowired
    private DoctorRepository doctorRepository;

    public AppointmentController() {
    }

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

   /** GET request to return specific appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.GET)
    public Optional<Appointment> findById(@PathVariable Long appointmentId) {
        return appointmentService.findById(appointmentId);
    }

    /** GET request to return all appointments **/
    @RequestMapping(path = "/", method = RequestMethod.GET)
    List<Appointment> findAll() {
        return appointmentService.findAll();
    }

    /** GET request to return all appointments based on a date range and ordered by price **/
    @RequestMapping(method = RequestMethod.GET)
    public List<Appointment> findByDateRangeSortedByPrice(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("startDate") LocalDate startDate,
                                                              @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") LocalDate endDate) {
        return appointmentService.findByDateRangeSortedByPrice(startDate, endDate);
    }

    /** POST request to add new appointments **/
    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointment create(@RequestBody Appointment appointment) {
        return appointmentService.create(appointment);
    }

    /** PUT request to update appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Appointment update(@PathVariable Long appointmentId, @RequestBody Appointment appointment) {
        return appointmentService.update(appointmentId, appointment);
    }

    /** PATCH request to update status of an appointment **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.PATCH, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Appointment updateStatus(@PathVariable Long appointmentId, @RequestBody Appointment appointment) {
        return appointmentService.updateStatus(appointmentId, appointment);
    }

    /** DELETE request to delete specific appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable Long appointmentId) {
        appointmentService.deleteById(appointmentId);
    }
    @RequestMapping(path = "/Doctor", method = RequestMethod.GET)
    public List<Doctor> findById() {
        return doctorRepository.findAll();
    }
    
//    getting appointment by doctor id
    @RequestMapping(path = "/getappointbyid/{username}", method = RequestMethod.GET)
    public List<Appointment> findByDoctorId(@PathVariable String username ) {
    	
    	System.out.println("username");
    	System.out.println(username);
        return appointmentRepository.findBynameOfDoctor(username); 
    }
    
}
