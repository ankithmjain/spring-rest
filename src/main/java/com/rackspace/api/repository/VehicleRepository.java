package com.rackspace.api.repository;

import java.util.List;
import java.util.Optional;

import com.rackspace.api.entity.Vehicle;

public interface VehicleRepository {

	public List<Vehicle> findAll();

	public Optional<Vehicle> findOne(String id);

	public Optional<Vehicle> findByVin(String email);

	public Vehicle create(Vehicle vehicle);

	public Vehicle update(Vehicle vehicle);

	public void delete(Vehicle vehicle);
}