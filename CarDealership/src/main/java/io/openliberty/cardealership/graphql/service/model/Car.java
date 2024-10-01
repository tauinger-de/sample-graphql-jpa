package io.openliberty.cardealership.graphql.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import org.eclipse.microprofile.graphql.Enum;
import org.eclipse.microprofile.graphql.Ignore;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.NonNull;

@Entity
@Table(name = "Car")
@NamedQuery(name = "findAllCars", query = "SELECT c FROM Car c")
@NamedQuery(name = "findAllConvertibles", query = "SELECT c FROM Car c WHERE c.convertible = TRUE")
public class Car {

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Name("VIN")
	@NonNull
    @Column(name = "vin")
	private String vin;

	@Column(name = "make")
	private String make;

	@Column(name = "model")
	private String model;

	@Column(name = "color")
	private Color color;

	@Name("year")
	@Column(name = "modelYear") // "year" is a keyword in SQL
	private int year;

	@Column(name = "doors")
	private int doors;

	@Column(name = "seats")
	private int seats;

	@Name("horsepower")
	@Column(name = "hp")
	private int hp;

	@Column(name = "convertible")
	private boolean convertible;

	@Column(name = "cost")
	private double cost;

	@Column(name = "dealerID")
	private int dealerID;

	@Ignore
	private int internalCode;

	public Car() {}

	public Car(String vin, Color color, String make, String model, int year, int doors, int seats, int hp, boolean convertible, double cost, int dealerID) {
		this.vin = vin;
		this.make = make;
		this.model = model;
		this.color = color;
		this.year = year;
		this.doors = doors;
		this.seats = seats;
		this.hp = hp;
		this.convertible = convertible;
		this.cost = cost;
		this.dealerID = dealerID;
	}

	@Enum("Color")
	public enum Color {
		black, blue, green, grey, red, silver, white, yellow
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getDoors() {
		return doors;
	}

	public void setDoors(int doors) {
		this.doors = doors;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public boolean isConvertible() {
		return convertible;
	}

	public void setConvertible(boolean convertible) {
		this.convertible = convertible;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getDealerID() {
		return dealerID;
	}

	public void setDealerID(int dealerID) {
		this.dealerID = dealerID;
	}

	@Ignore
	public int getInternalCode() {
		return internalCode;
	}
	
	@Ignore
	public void setInternalCode(int internalCode) {
		this.internalCode = internalCode;
	}
}
