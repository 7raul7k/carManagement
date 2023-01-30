package ro.mycode.carManagement.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.carManagement.models.Car;
import ro.mycode.carManagement.models.Customer;
import ro.mycode.carManagement.services.CarManagementService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerResources {

    private CarManagementService customerService;

    public CustomerResources(CarManagementService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customers = this.customerService.getallCustomers();

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @GetMapping("/allCars/{owner}")
    public ResponseEntity<List<Car>> getAllCars(@PathVariable String owner) {
        List<Car> cars = this.customerService.showAllCars(owner);

        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        this.customerService.addCustomer(customer);

        return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
    }

    @PostMapping("/addCars")
    public ResponseEntity<Car> addCar(@RequestBody Car car){
        this.customerService.addCars(car);

        return new ResponseEntity<>(car,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<String> deleteCustomer(@RequestParam String fullName,@RequestParam String email){
        this.customerService.removeCustomer(fullName,email);

        return new ResponseEntity<>("Customer was deleted", HttpStatus.ACCEPTED);
    }

}
