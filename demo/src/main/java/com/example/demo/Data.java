package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Data {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "empID")
	public Long aemp;

	@Column(name = "empName")
	public String aname;

	@Column(name = "empLast")
	public String alast;

	public Data(){}
	
	public Long getAemp() {
		return aemp;
	}

	public void setAemp(Long aemp) {
		this.aemp = aemp;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getAlast() {
		return alast;
	}

	public void setAlast(String alast) {
		this.alast = alast;
	}

	@Override
	public String toString() {
		return "Data [aemp=" + aemp + ", aname=" + aname + ", alast=" + alast + "]";
	}

}
