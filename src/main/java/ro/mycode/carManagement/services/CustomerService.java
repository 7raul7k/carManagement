package ro.mycode.carManagement.services;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import ro.mycode.carManagement.exceptions.CustomerNotFoundException;
import ro.mycode.carManagement.exceptions.CustomerWasFoundException;
import ro.mycode.carManagement.exceptions.ListEmptyException;
import ro.mycode.carManagement.repo.CustomerRepo;
import ro.mycode.carManagement.resources.Customer;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private CustomerRepo customerRepo;

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

    @Transactional
    @Modifying
    public void updateFullName(String newName,String fullName,String email){
        Optional<Customer> customer = this.customerRepo.getCustomerByNameAndEmail(fullName,email);
        if(customer.isEmpty()==false){
            this.customerRepo.updateFullName(newName,email);
        }else{
            throw new CustomerNotFoundException();
        }

    }

    @Transactional
    @Modifying
    public void updateAge(int newAge,String fullName,String email){
        Optional<Customer> customer = this.customerRepo.getCustomerByNameAndEmail(fullName,email);
        if(customer.isEmpty()==false){
            this.customerRepo.updateAge(newAge,email);
        }else{
            throw new CustomerNotFoundException();
        }
    }

    @Transactional
    @Modifying
    public void updateAdress(String newAdress,String fullName,String email){
        Optional<Customer> customer = this.customerRepo.getCustomerByNameAndEmail(fullName,email);
        if(customer.isEmpty()==false){
            this.customerRepo.updateAdress(newAdress,email);
        }else{
            throw new CustomerNotFoundException();
        }
    }

    @Transactional
    @Modifying
    public void updateDomain(String newDomain,String fullName,String email){
        Optional<Customer> customer = this.customerRepo.getCustomerByNameAndEmail(fullName,email);
        if(customer.isEmpty()==false){
            this.customerRepo.updateDomain(newDomain,email);
        }else{
            throw new CustomerNotFoundException();
        }
    }

}
