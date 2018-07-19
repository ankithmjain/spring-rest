package com.rackspace.api.service.impl;

import java.util.List;
import java.util.Optional;

import com.rackspace.api.entity.Vehicle;
import com.rackspace.api.exception.BadRequestException;
import com.rackspace.api.exception.NotFoundException;
import com.rackspace.api.repository.VehicleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rackspace.api.service.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {

	private VehicleRepository repository;

	public VehicleServiceImpl(VehicleRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Vehicle> findAll() {
		return repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Vehicle findOne(String id) {
		return repository.findOne(id)
				.orElseThrow(() -> new NotFoundException("Vehicle with id " + id + " does not exist"));
	}

	@Override
	@Transactional
	public Vehicle create(Vehicle vehicle) {
		Optional<Vehicle> mayExists = repository.findByVin(vehicle.getVin());
		if (mayExists.isPresent()) {
			throw new BadRequestException("Vehicle with vin " + vehicle.getVin() + " already exists");
		}
		return repository.create(vehicle);
	}

	@Override
	@Transactional
	public Vehicle update(String id, Vehicle vehicle) {
		repository.findOne(id).orElseThrow(() -> new NotFoundException("Vehicle with id " + id + " does not exist"));
		return repository.update(vehicle);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Vehicle existing = repository.findOne(id)
				.orElseThrow(() -> new NotFoundException("Vehicle with id " + id + " does not exist"));
		repository.delete(existing);
	}
}