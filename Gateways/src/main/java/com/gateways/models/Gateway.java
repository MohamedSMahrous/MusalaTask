package com.gateways.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Gateway {

	@Id
	private int id;
	private String serialNumber;
	private String name;
	private String ipv4;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "gatewayObj",fetch = FetchType.EAGER)
	private List<Peripheral> peripherals = new ArrayList<Peripheral>();
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	public List<Peripheral> getPeripherals() {
		return peripherals;
	}

	public void setPeripherals(List<Peripheral> peripherals) {
		this.peripherals = peripherals;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
