package com.alpha.hospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Patient {
	
	@Id
	private int pid;
	private String pname;
	private String diease;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getDiease() {
		return diease;
	}
	public void setDiease(String diease) {
		this.diease = diease;
	}
	
	public Patient(int pid, String pname, String diease) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.diease = diease;
	}
	
	public Patient() {
		super();
	}
	
	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", diease=" + diease + "]";
	}
	
}
