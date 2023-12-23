package com.da.appointmentapp.controller;

import com.da.appointmentapp.entity.Appointment;
import com.da.appointmentapp.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/appointment")
public class AppointmentController {
    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @GetMapping("/list")
    ResponseEntity<List<Appointment>> getAppointments(){
        try {
            List<Appointment> appointments = appointmentService.getAllAppointments();
            return ResponseEntity.ok(appointments);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @PostMapping("/save")
    ResponseEntity<AppointmentDto> saveAppointment(@RequestBody Appointment appointment){
        appointmentService.save(appointment);
        return ResponseEntity.ok().build();
    }
}
