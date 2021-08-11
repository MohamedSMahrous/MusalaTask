package com.gateways.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gateways.models.Gateway;
import com.gateways.models.Peripheral;
import com.gateways.models.PeripheralRequest;
import com.gateways.repositories.PeripheralRepo;

@Service
public class PeripheralService {

	@Autowired
	PeripheralRepo peripheralRepo;

	@Autowired
	GatewayService gatewayService;

	public boolean addPeripheral(PeripheralRequest peripheralRequest) {

		Gateway gateway = gatewayService.getById(peripheralRequest.getGatewayId());
		if (gateway != null && gateway.getId() != 0) {

			Peripheral peripheral = new Peripheral();
			peripheral.setId(peripheralRepo.getMaxID() + 1);
			peripheral.setCreated(peripheralRequest.getCreated());
			peripheral.setStatus(peripheralRequest.getStatus());
			peripheral.setUID(peripheralRequest.getUID());
			peripheral.setVendor(peripheralRequest.getVendor());
			peripheral.setGatewayObj(gateway);
			
			peripheralRepo.save(peripheral);
			
			return true;
		} else {
			return false;
		}

	}

	public boolean deleteById(int peripheralId) {
		try {
			Optional<Peripheral> p = peripheralRepo.findById(peripheralId);
			if(p.isPresent())
				peripheralRepo.delete(p.get());
			else
				return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

}
