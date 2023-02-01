package ro.mycode.carManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.carManagement.models.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    @Query("SELECT customer from Customer customer where customer.fullName = ?1 AND customer.email = ?2")
    Optional<Customer> getCustomerByNameAndEmail(String fullName, String email);



    Optional<Customer> findCustomerByEmail(String email);


}
