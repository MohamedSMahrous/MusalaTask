package com.gateways.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateways.controllers.GatewayRequest;
import com.gateways.models.Gateway;
import com.gateways.models.Peripheral;
import com.gateways.models.PeripheralRequest;
import com.gateways.repositories.GatewayRepository;
import com.gateways.repositories.PeripheralRepo;

@Service
public class GatewayService {

	
	
	@Autowired
	GatewayRepository gatewayRepo;
	
	@Autowired
	PeripheralRepo peripheralRepo;
	
	
	
	public List<Gateway> getAllGateways(){
	
		return gatewayRepo.findAll();
		
	}
	
	public Gateway getById(int id) {
		Optional<Gateway> returnObj = gatewayRepo.findById(id);
		if(returnObj.isPresent())
			return returnObj.get();
		else
			return new Gateway();
	}

	public Gateway addGateway(GatewayRequest gatewayRequest) {
		
		int maxIdInGateway = gatewayRepo.getMaxID();
		int maxIdInPeriphral = peripheralRepo.getMaxID();
		Gateway gateway = new Gateway();
		gateway.setId(maxIdInGateway + 1);
		gateway.setIpv4(gatewayRequest.getIpv4());
		gateway.setName(gatewayRequest.getName());
		gateway.setSerialNumber(gatewayRequest.getSerialNumber());
		
		Gateway savedGateway = gatewayRepo.save(gateway);
		for(PeripheralRequest p : gatewayRequest.getPeripherals()) {
			maxIdInPeriphral++;
			Peripheral peripheral = new Peripheral();
			
			peripheral.setGatewayObj(savedGateway);
			peripheral.setId(maxIdInPeriphral);
			peripheral.setCreated(p.getCreated());
			peripheral.setUID(p.getUID());
			peripheral.setStatus(p.getStatus());
			peripheral.setVendor(p.getVendor());
			peripheralRepo.save(peripheral);
		}
		List<Peripheral> savePeripherals = peripheralRepo.getAllPeripheralToGateway(savedGateway.getId());
		savedGateway.setPeripherals(savePeripherals);
		return savedGateway;
		
	}
	
}
