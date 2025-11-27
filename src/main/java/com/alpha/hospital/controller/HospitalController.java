package com.alpha.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.alpha.hospital.entity.Doctor;
import com.alpha.hospital.services.HospitalService;

public class HospitalController {
	@Autowired
	private HospitalService hs;
	
	@PostMapping("/saveDoctor")
	public void saveDoctor(@RequestBody Doctor d) {
		hs.saveDoctor(d);
	}
	
	
	@GetMapping("/findDcotor")
	public ResponseStructure<Doctor> findDoctor(@RequestParam int did) {
		return hs.findDoctor(did);
	}
	
	
	@DeleteMapping("/deleteStudent")
	public void deleteDoctor(@RequestParam int did) {
		hs.deleteDoctor(did);
	}
	
	
	@PutMapping("/updateDoctor")
	public void updateDoctor(@RequestParam int did,@RequestParam String dname,@RequestParam String specilization) {
		hs.updateDoctor(did,dname,specilization);
	}


}
