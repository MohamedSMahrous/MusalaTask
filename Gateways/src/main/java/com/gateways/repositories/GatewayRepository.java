package com.gateways.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.gateways.models.Gateway;

@Repository
public interface GatewayRepository extends JpaRepository<Gateway, Integer>{

	@Query(value = "select max(id) from gateway", nativeQuery = true)
	public int getMaxID();

}
