package com.gateways.controllers;

import java.util.List;

import org.apache.commons.validator.routines.InetAddressValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gateways.models.Gateway;
import com.gateways.models.PeripheralRequest;
import com.gateways.repositories.PeripheralRepo;
import com.gateways.services.GatewayService;
import com.gateways.services.PeripheralService;

@RestController
public class GatewayController {

	@Autowired
	GatewayService gatewayService;

	@Autowired
	PeripheralService peripheralService;

	private final InetAddressValidator validator = new InetAddressValidator();

	@RequestMapping(path = "/getAll", method = RequestMethod.GET)
	public List<Gateway> getAllGateways() {
		return gatewayService.getAllGateways();
	}

	@RequestMapping(path = "/getById", method = RequestMethod.GET)
	public Gateway getGatewayById(@RequestParam int id) {
		return gatewayService.getById(id);
	}

	@RequestMapping(path = "/addGateway", method = RequestMethod.POST)
	public ResponseEntity<?> addGateway(@RequestBody GatewayRequest gatewayRequest) {

		if (!validator.isValidInet4Address(gatewayRequest.getIpv4()))
			return new ResponseEntity<String>("Ipv4 Not Correct", HttpStatus.BAD_REQUEST);

		if (gatewayRequest.getPeripherals().size() > 10)
			return new ResponseEntity<String>("Can't Add More Than 10 Peripherals To One Gateway",
					HttpStatus.BAD_REQUEST);

		Gateway gateway = gatewayService.addGateway(gatewayRequest);

		return new ResponseEntity<Gateway>(gateway, HttpStatus.OK);

	}

	@RequestMapping(path = "/addPeripheral", method = RequestMethod.POST)
	public ResponseEntity<?> addPeripheralToGateway(@RequestBody PeripheralRequest peripheralRequest) {

		boolean added = peripheralService.addPeripheral(peripheralRequest);
		if (added)
			return new ResponseEntity<String>("Peripheral Added Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Gateway Not Found And Peripheral Not Added", HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(path = "/deletePeripheral", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteeripheralToGateway(@RequestParam int peripheralId) {
		
		boolean deleted = peripheralService.deleteById(peripheralId);
		if(deleted)
			return new ResponseEntity<String>("Peripheral Deleted Successfully", HttpStatus.OK);
		else
			return new ResponseEntity<String>("Peripheral Not Found", HttpStatus.BAD_REQUEST);

	}

}
