package ro.mycode.carManagement.services;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import ro.mycode.carManagement.dto.CarDTO;
import ro.mycode.carManagement.dto.CustomerDTO;
import ro.mycode.carManagement.exceptions.CarNotFoundException;
import ro.mycode.carManagement.exceptions.CustomerNotFoundException;
import ro.mycode.carManagement.exceptions.CustomerWasFoundException;
import ro.mycode.carManagement.exceptions.ListEmptyException;
import ro.mycode.carManagement.models.Car;
import ro.mycode.carManagement.models.Customer;
import ro.mycode.carManagement.repo.CarRepo;
import ro.mycode.carManagement.repo.CustomerRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;


    private CarRepo carRepo;

    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public List<Customer> getallCustomers(){

        customerRepo.findAll();
        List<Customer> customers = customerRepo.findAll();

        if(customers.isEmpty() == false){
            return customers;
        }
        throw new ListEmptyException();

    }

    @Transactional
    @Modifying
    public void addCustomer(Customer m){
      Optional<Customer> customer = this.customerRepo.getCustomerByNameAndEmail(m.getFullName(),m.getEmail());
      if(customer.isEmpty()){
         customerRepo.saveAndFlush(m);
      }else{
      throw new CustomerWasFoundException();
    }
    }

    @Transactional
    @Modifying
    public void removeCustomer(String fullName,String email) {
        Optional<Customer> customer = this.customerRepo.getCustomerByNameAndEmail(fullName, email);
        if (customer.isEmpty() == false) {
            customerRepo.delete(customer.get());
        } else {
            throw new CustomerNotFoundException();
        }
    }

    public void addCar(Car car, String fullName, String email){
        Optional<Customer> m = this.customerRepo.getCustomerByNameAndEmail(fullName, email);
        if(m.isEmpty()== false){
            Customer customer = m.get();
            customer.addCar(car);
            customerRepo.save(customer);
        }else{
            throw new CustomerNotFoundException();
        }
    }

    public Optional<Customer> getCustomerByEmail(String email){
        Optional<Customer> m = this.customerRepo.findCustomerByEmail(email);

        if(m.isEmpty()==false){
            return m;
        }else{
            throw new CustomerNotFoundException();
        }
    }

    public Optional<Customer> getCustomerByNameAndEmail(String fullName,String email){
        Optional<Customer> m = this.customerRepo.getCustomerByNameAndEmail(fullName, email);

        if(m.isEmpty()==false){
            return m;
        }else{
            throw new CustomerNotFoundException();
        }
    }

    public void deleteCar(String make,String owner,String email){

        Optional<Car> car = this.carRepo.findCarbyOwnerAndMake(owner,make);
        if(car.isEmpty()==false) {
            Customer customer = this.customerRepo.getCustomerByNameAndEmail(owner, email).get();
            if (customer != null) {
                customer.eraseCar(car.get());
                this.carRepo.delete(car.get());
            }
        }else {
            throw new CarNotFoundException();
        }


    }

    @Transactional
    public void updateCustomer(CustomerDTO customerDTO){
        Optional<Customer> customer = this.customerRepo.findCustomerByEmail(customerDTO.getEmail());

        if(customer.isEmpty()){
            throw new CustomerNotFoundException();
        }else{
            if(customerDTO.getFullName()!=null){
                customer.get().setFullName(customerDTO.getFullName());
            }else if(customerDTO.getAge()>0){
                customer.get().setAge(customerDTO.getAge());
            } else if (customerDTO.getAdress()!=null) {
                customer.get().setAdress(customerDTO.getAdress());
            } else if (customerDTO.getDomain()!=null) {
                customer.get().setDomain(customerDTO.getDomain());
            }

        }
        this.customerRepo.saveAndFlush(customer.get());
    }

    @Transactional
    public void updateCar(CarDTO carDTO){
        Optional<Car> car = this.carRepo.findCarbyOwnerAndMake(carDTO.getOwner(), carDTO.getMake());
        if(car.isEmpty()){
            throw new CarNotFoundException();
        }else if (carDTO.getYear()>0){
            car.get().setYear(carDTO.getYear());
        } else if (carDTO.getEngineType()!=null) {
            car.get().setEngineType(carDTO.getEngineType());
        } else if (carDTO.getHorsePower()>0) {
            car.get().setHorsePower(carDTO.getHorsePower());
        }else if(carDTO.getColor()!=null){
            car.get().setColor(carDTO.getColor());
        }
        this.carRepo.saveAndFlush(car.get());
    }



}
