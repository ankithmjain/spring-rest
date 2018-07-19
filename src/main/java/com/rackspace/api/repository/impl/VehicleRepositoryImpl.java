package com.rackspace.api.repository.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.rackspace.api.repository.VehicleRepository;
import com.rackspace.api.entity.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Vehicle> findAll() {
		TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findAll", Vehicle.class);
		return query.getResultList();
	}

	@Override
	public Optional<Vehicle> findByVin(String vin) {
		TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findByVin", Vehicle.class);
		query.setParameter("pVin", vin);
		List<Vehicle> vehicles = query.getResultList();
		if (!vehicles.isEmpty()) {
			return Optional.of(vehicles.get(0));
		} else {
			return Optional.empty();
		}
	}

	@Override
	public Optional<Vehicle> findOne(String id) {
		return Optional.ofNullable(em.find(Vehicle.class, id));
	}

	@Override
	public Vehicle create(Vehicle vehicle) {
		em.persist(vehicle);
		return vehicle;
	}

	@Override
	public Vehicle update(Vehicle vehicle) {
		return em.merge(vehicle);
	}

	@Override
	public void delete(Vehicle vehicle) {
		em.remove(vehicle);
	}
}