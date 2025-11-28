package com.alpha.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alpha.hospital.ResponseStructure;
import com.alpha.hospital.entity.Doctor;
import com.alpha.hospital.exception.DoctorNotFoundException;
import com.alpha.hospital.exception.DuplicateDoctorException;
import com.alpha.hospital.repository.DoctorRepo;

@Service
public class HospitalService {

    @Autowired
    private DoctorRepo doctorRepo;

    public ResponseStructure<Doctor> saveDoctor(Doctor d) {
    	
    	if (doctorRepo.existsById(d.getDid())) {
            throw new DuplicateDoctorException("Doctor with ID " + d.getDid() + " already exists");
        }
    	
        Doctor saved = doctorRepo.save(d);
        ResponseStructure<Doctor> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setMessage("Doctor saved successfully");
        rs.setData(saved);
        return rs;
    }

    public ResponseStructure<Doctor> getDoctor(int id) {
        Doctor d = doctorRepo.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found with id: " + id));

        ResponseStructure<Doctor> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Doctor data fetched");
        rs.setData(d);
        return rs;
    }

    public ResponseStructure<List<Doctor>> getAllDoctors() {
        List<Doctor> list = doctorRepo.findAll();

        ResponseStructure<List<Doctor>> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("All doctors fetched");
        rs.setData(list);
        return rs;
    }

    public ResponseStructure<String> deleteDoctor(int id) {
        Doctor d = doctorRepo.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Cannot delete, doctor not found"));

        doctorRepo.delete(d);

        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Doctor deleted successfully");
        rs.setData("Deleted doctor id: " + id);
        return rs;
    }

    public ResponseStructure<Doctor> updateDoctor(int id, Doctor newDoc) {
        Doctor old = doctorRepo.findById(id)
                .orElseThrow(() -> new DoctorNotFoundException("Doctor not found for update"));

        old.setDname(newDoc.getDname());
        old.setSpecilization(newDoc.getSpecilization());
        old.setPlist(newDoc.getPlist());

        Doctor updated = doctorRepo.save(old);

        ResponseStructure<Doctor> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.OK.value());
        rs.setMessage("Doctor updated successfully");
        rs.setData(updated);
        return rs;
    }
}
