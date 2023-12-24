package com.da.appointmentapp.service;

import com.da.appointmentapp.entity.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAllAppointments();
    Appointment save(Appointment appointment);
    void delete(Long id);
}
