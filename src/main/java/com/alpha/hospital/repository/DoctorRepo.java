package com.alpha.hospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.hospital.entity.Doctor;

public interface DoctorRepo extends JpaRepository<Doctor, Integer> {

}
