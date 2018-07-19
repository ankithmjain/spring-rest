package com.rackspace.api.service;

import java.util.List;

import com.rackspace.api.entity.Vehicle;

public interface VehicleService {

	public List<Vehicle> findAll();

	public Vehicle findOne(String id);

	public Vehicle create(Vehicle vehicle);

	public Vehicle update(String id, Vehicle vehicle);

	public void delete(String id);
}