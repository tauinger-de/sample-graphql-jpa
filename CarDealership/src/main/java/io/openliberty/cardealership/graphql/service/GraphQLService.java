package io.openliberty.cardealership.graphql.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.GraphQLException;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import io.openliberty.cardealership.graphql.service.model.Car;
import io.openliberty.cardealership.graphql.service.model.Car.Color;

@GraphQLApi
@ApplicationScoped
public class GraphQLService {
	
	@Inject
    private CarDAO inventory;

	@Query("lookupCar")
	@Description("Returns the car with the associated VIN number")
	@Transactional
    public Car getCar(@Name("VIN") String vin) {
		return inventory.getCar(vin);
    }
	
	@Mutation("addNewCar")
	@Description("Adds a new Car to the database")
	@Transactional
	public Car addCar(@Name("newCar") Car car) {
		return inventory.addCar(car);
	}
	
	@Mutation("addNewCars")
	@Description("Adds new Cars to the database")
	@Transactional
	public List<Car> addCars(@Name("newCars") List<Car> cars) {
		List<Car> newCars = new ArrayList<Car>();
		for (Car car : cars) {
			newCars.add(inventory.addCar(car));
		}
		return newCars;
	}
	
	@Mutation("updateCar")
	@Description("Updates a care in the database")
	@Transactional
	public Car updateCar(Car car) {
		return inventory.updateCar(car);
	}
	
	@Mutation("removeCar")
	@Description("Removes the Car with the associated VIN from the database")
	@Transactional
	public Car removeCar(@Name("VIN") String vin) {
		return inventory.removeCar(vin);
	}

	@Query("getAllCars")
	@Description("Returns all of the Cars in the database")
	@Transactional
    public List<Car> getCars() {
		return inventory.getCars();
    }

	@Query("getAllConvertibles")
	@Description("Returns all of the convertibles in the database, optionally, filter on color")
	@Transactional
    public List<Car> getConvertibles(Color color) throws GraphQLException {
		List<Car> cars = inventory.getConvertibles();
		if (color != null) {
			try {
				return cars.stream().filter(c -> c.getColor().equals(color)).collect(Collectors.toList());
			} catch (Exception e) {
				throw new GraphQLException(e, cars);
			}
		}
		return cars;
    }
}
