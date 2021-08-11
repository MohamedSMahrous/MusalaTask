package com.gateways.controllers;

import java.util.List;

import com.gateways.models.Peripheral;
import com.gateways.models.PeripheralRequest;

public class GatewayRequest {
	
	private String serialNumber;
	private String name;
	private String ipv4;

	private List<PeripheralRequest> peripherals;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
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

	public List<PeripheralRequest> getPeripherals() {
		return peripherals;
	}

	public void setPeripherals(List<PeripheralRequest> peripherals) {
		this.peripherals = peripherals;
	}

}
