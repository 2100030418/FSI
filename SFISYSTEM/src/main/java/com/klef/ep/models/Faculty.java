package com.klef.ep.models;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="faculty_table")
public class Faculty implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	@Column(length = 20,nullable = false)
    private String fname;
	
	
	@Column(length = 30,nullable = false,unique = true)
    private String email;
	
	@Column(length = 30,nullable = false)
    private String password;
	
	@Column(length = 10,nullable = false)
    private String gender;
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getDob() {
		return dob;
	}


	public void setDob(String dob) {
		this.dob = dob;
	}


	public String getDepartmnt() {
		return departmnt;
	}


	public void setDepartmnt(String departmnt) {
		this.departmnt = departmnt;
	}


	public String getContactno() {
		return contactno;
	}


	public void setContactno(String contactno) {
		this.contactno = contactno;
	}


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	public Blob getImagedata() {
		return imagedata;
	}


	public void setImagedata(Blob imagedata) {
		this.imagedata = imagedata;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Column(length = 20,nullable = false)
    private String dob;
	
	@Column(length = 20,nullable = false)
    private String departmnt;
	
	@Column(length = 30,nullable = false,unique = true)
    private String contactno;
		
	@Column(length = 30,nullable = false)
    private double salary;
	
	
	@Lob
    @Column(nullable = false)
    private Blob imagedata;
	
}
