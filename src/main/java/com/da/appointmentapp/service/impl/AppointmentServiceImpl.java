package com.da.appointmentapp.service.impl;

import com.da.appointmentapp.entity.Appointment;
import com.da.appointmentapp.exception.AppointmentNotFoundException;
import com.da.appointmentapp.repository.AppointmentRepository;
import com.da.appointmentapp.service.AppointmentService;
import com.da.appointmentapp.util.MapperUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private final MapperUtil mapperUtil;
    private  final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(MapperUtil mapperUtil, AppointmentRepository appointmentRepository) {
        this.mapperUtil = mapperUtil;
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }
    @Override
    public Appointment save(Appointment appointment) {
     return   appointmentRepository.save(appointment);


    }

    @Override
    public void delete(Long id) {
       Appointment appointment= appointmentRepository.findById(id).orElseThrow(()->new AppointmentNotFoundException("Appointment does not exist in the database."));
   appointmentRepository.delete(appointment);
    }
}
