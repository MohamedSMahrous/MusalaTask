package com.gateways.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PeripheralRequest {

	@JsonProperty("UID")
	private int UID;
	private String vendor;
	private Date created;
	private String status;

	private int gatewayId;

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(int gatewayId) {
		this.gatewayId = gatewayId;
	}

}
