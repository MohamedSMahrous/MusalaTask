package com.gateways.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Peripheral {

	@Id
	private int id;

	private int UID;
	private String vendor;
	private Date created;
	private String status;

	@JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gatewayId", nullable=false)
	private Gateway gatewayObj;

	public Gateway getGatewayObj() {
		return gatewayObj;
	}

	public void setGatewayObj(Gateway gatewayObj) {
		this.gatewayObj = gatewayObj;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

}
