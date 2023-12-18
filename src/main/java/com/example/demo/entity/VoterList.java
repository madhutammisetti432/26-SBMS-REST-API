package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class VoterList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VOTER-ID")
	private Integer id;
	@Column(name = "VOTER-NAME")
	private String name;
	@Column(name = "VOTER-ADDRESS")
	private String address;
	@Column(name = "VOTER-CONSISTENCY")
	private String consistency;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getConsistency() {
		return consistency;
	}

	public void setConsistency(String consistency) {
		this.consistency = consistency;
	}

	public VoterList(Integer id, String name, String address, String consistency) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.consistency = consistency;
	}

	public VoterList() {

	}

	@Override
	public String toString() {
		return "VoterList [id=" + id + ", name=" + name + ", address=" + address + ", Consistency=" + consistency + "]";
	}

}
