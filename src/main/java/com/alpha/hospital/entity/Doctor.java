package com.alpha.hospital.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Doctor {
	
	@Id
	private int did;
	@NotBlank(message="Doctor name cannot be blank")
	private String dname;
	@NotBlank(message="Specialization cannot be blank")
	
	private String specilization;
	
	@OneToMany(cascade = CascadeType.ALL)
	List<Patient>plist;
	
	
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getSpecilization() {
		return specilization;
	}
	public void setSpecilization(String specilization) {
		this.specilization = specilization;
	}
	public List<Patient> getPlist() {
		return plist;
	}
	public void setPlist(List<Patient> plist) {
		this.plist = plist;
	}
	public Doctor(int did, String dname, String specilization, List<Patient> plist) {
		super();
		this.did = did;
		this.dname = dname;
		this.specilization = specilization;
		this.plist = plist;
	}
	public Doctor() {
		super();
	}
	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", specilization=" + specilization + ", plist=" + plist
				+ "]";
	}
	
	
}
