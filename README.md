# Welcome to the Microprofile GraphQL + JPA Car Dealership Sample.

## Setup
Navigate to `./CarDealership` and run `mvn install` to build the project and download all dependencies.

Run `mvn liberty:run` to start the OpenLiberty server with the CarDealership app.

Navigate to [http://localhost:9080/CarDealership/graphql/schema.graphql](http://localhost:9080/CarDealership/graphql/schema.graphql) to view the GraphQL schema for the CarDealership app.

Navigate to [http://localhost:9080/CarDealership/graphql-ui](http://localhost:9080/CarDealership/graphql-ui) to open the Graph*i*QL interface to send GraphQL queries/mutations to the server.

##  Sample Queries/Mutations

### Add multiple cars to populate the database:
```
mutation {
  addNewCars(newCars: [
    {VIN: "LC0001", make: "Lamborghini", model: "Countach", color: red, year: "1974", doors: 2, horsepower: 747, seats: 2, convertible: false, cost: 52000.00, dealerID: 1},
    {VIN: "LR0001", make: "Lamborghini", model: "Reventon", color: grey, year: "2009", doors: 2, horsepower: 641, seats: 2, convertible: false, cost: 1200000.00, dealerID: 2},
    {VIN: "LAV0001", make: "Lamborghini", model: "Aventador SuperVeloce LP750-4", color: red, year: "2016", doors: 2, horsepower: 690, seats: 2, convertible: true, cost: 569999.99, dealerID: 3},
    {VIN: "LLFA0001", make: "Lexus", model: "LFA", color: yellow, year: "2010", doors: 2, horsepower: 563, seats: 2, convertible: true, cost: 375000.00, dealerID: 4},
    {VIN: "PCGT0001", make: "Porche", model: "Carrera GT", color: silver, year: "2005", doors: 2, horsepower: 605, seats: 2, convertible: true, cost: 135856.00, dealerID: 5},
    {VIN: "PO10001", make: "Koenigsegg", model: "One:1", color: white, year: "2005", doors: 2, horsepower: 1360, seats: 2, convertible: false, cost: 7200000.00, dealerID: 1},
    {VIN: "FM0001", make: "Ferrari", model: "550 Maranello", color: black, year: "2000", doors: 2, horsepower: 479, seats: 2, convertible: false, cost: 200000.00, dealerID: 2},
    {VIN: "FF120001", make: "Ferrari", model: "F12", color: red, year: "2012", doors: 2, horsepower: 730, seats: 2, convertible: false, cost: 325000.00, dealerID: 3}]) {
      VIN
      make
      model
      color
      cost
  }
}
```

### Lookup car by VIN:
```
query {
  lookupCar(VIN: "LC0001") {
    color
    year
    make
    model
  }
}
```

### Get all cars in the database:
```
query {
  getAllCars {
    VIN
    year
    color
    make
    model
  }
}
```

### Get all convertibles (with optional color param)
```
query {
  getAllConvertibles(color: "red") {
    VIN
    year
    color
    make
    model
  }
}
```
