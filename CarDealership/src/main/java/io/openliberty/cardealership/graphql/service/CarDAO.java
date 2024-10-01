package io.openliberty.cardealership.graphql.service;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import io.openliberty.cardealership.graphql.service.model.Car;

@ApplicationScoped
public class CarDAO {

	@PersistenceContext(name = "jpa-unit")
    private EntityManager em;

	// CREATE
	public Car addCar(Car newCar) {
		em.persist(newCar);
		return newCar;
	}

	// RETRIEVE
    public Car getCar(String vin) {
    	return em.find(Car.class, vin);
    }

    // UPDATE
	public Car updateCar(Car newCar) {
		Car oldCar = em.merge(newCar);
		return oldCar;
	}

	// DELETE
	public Car removeCar(String vin) {
		Car car = em.find(Car.class, vin);
		em.remove(car);
		return car;
	}
	
	public List<Car> getCars() {
		return em.createNamedQuery("findAllCars", Car.class).getResultList();
	}
	
	public List<Car> getConvertibles() {
		return em.createNamedQuery("findAllConvertibles", Car.class).getResultList();
	}
}
