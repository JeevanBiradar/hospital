package com.alpha.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alpha.hospital.ResponseStructure;
import com.alpha.hospital.entity.Doctor;
import com.alpha.hospital.services.HospitalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/doctor")
public class HospitalController {

    @Autowired
    private HospitalService service;

    @PostMapping("/save")
    public ResponseStructure<Doctor> save(@Valid @RequestBody Doctor d) {
        return service.saveDoctor(d);
    }

    @GetMapping("/get/{id}")
    public ResponseStructure<Doctor> get(@PathVariable int id) {
        return service.getDoctor(id);
    }

    @GetMapping("/get-all")
    public ResponseStructure<List<Doctor>> getAll() {
        return service.getAllDoctors();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseStructure<String> delete(@PathVariable int id) {
        return service.deleteDoctor(id);
    }

    @PutMapping("/update/{id}")
    public ResponseStructure<Doctor> update(@PathVariable int id, @Valid @RequestBody Doctor d) {
        return service.updateDoctor(id, d);
    }
}

