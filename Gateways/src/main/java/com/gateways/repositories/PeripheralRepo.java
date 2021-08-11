package com.gateways.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.gateways.models.Peripheral;

@Repository
public interface PeripheralRepo extends JpaRepository<Peripheral, Integer>{

	@Query(value = "select max(id) from peripheral", nativeQuery = true)
	public int getMaxID();
	
	@Query(value = "select * from peripheral where gateway_id = :gateway_id", nativeQuery = true)
	public List<Peripheral> getAllPeripheralToGateway(@Param("gateway_id") int gatewayId);

}
