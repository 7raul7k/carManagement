package ro.mycode.carManagement.rest;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.mycode.carManagement.dto.CarDTO;
import ro.mycode.carManagement.dto.CustomerDTO;
import ro.mycode.carManagement.models.Car;
import ro.mycode.carManagement.models.Customer;
import ro.mycode.carManagement.services.CustomerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class CustomerResources {

    private CustomerService customerService;

    public CustomerResources(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> getAllCustomer() {

        log.info("Rest request to get all users");
        List<Customer> customers = this.customerService.getallCustomers();

        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){

        log.info("Rest request to add {} user",customer);
        this.customerService.addCustomer(customer);

        return new ResponseEntity<>(customer,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<String> deleteCustomer(@RequestParam String fullName,@RequestParam String email){

        log.info("Rest request to delete  customer");
        this.customerService.removeCustomer(fullName,email);

        return new ResponseEntity<>("Customer was deleted", HttpStatus.ACCEPTED);
    }

    @PutMapping("/addCar")
    public ResponseEntity<String> addCar(@RequestBody Car car,String name,String email){

        log.info("Rest requrest to add {} car",car);
       this.customerService.addCar(car,name,email);

        return new ResponseEntity<>("Car added!",HttpStatus.ACCEPTED);

    }

    @GetMapping("/getCustomerByEmail/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email){

        log.info("Rest request to get customer by email");
        Customer customer = this.customerService.getCustomerByEmail(email).get();
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @GetMapping("/getCustomerByNameAndEmail/{name}&{email}")
    public ResponseEntity<Customer> getCustomerByNameAndEmail(@PathVariable String name,@PathVariable String email){

        log.info("Rest request to get customer by name and email");
        Customer customer = this.customerService.getCustomerByNameAndEmail(name, email).get();
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @DeleteMapping("/deleteCar/{make}&{owner}&{email}")
    public ResponseEntity<String> deleteCar(@PathVariable String make,@PathVariable String owner,@PathVariable String email){

        log.info("Rest request to delete car ");
        this.customerService.deleteCar(make,owner,email);

        return new ResponseEntity<>("Car was deleted",HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateCustomer")
    public ResponseEntity<String> updateCustomer(@RequestBody CustomerDTO customerDTO){

        log.info("Rest request to update customer with {}",customerDTO.getEmail());
        this.customerService.updateCustomer(customerDTO);

        return new ResponseEntity<>("Customer was updated!",HttpStatus.ACCEPTED);
    }

    @PutMapping("/updateCar")
    public ResponseEntity<String> updateCar(@RequestBody CarDTO carDTO){

        log.info("Rest request to update car with {} ",carDTO.getMake());
        this.customerService.updateCar(carDTO);

        return new ResponseEntity<>("Car was updated!",HttpStatus.ACCEPTED);
    }



}
