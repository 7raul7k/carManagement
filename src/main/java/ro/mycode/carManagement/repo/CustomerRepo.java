package ro.mycode.carManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.carManagement.models.Customer;

import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {

    @Query("SELECT customer from Customer customer where customer.fullName = ?1 AND customer.email = ?2")
    Optional<Customer> getCustomerByNameAndEmail(String fullName, String email);


    @Modifying
    @Query("UPDATE Customer m set m.fullName = ?1 where m.email = ?2")
    void updateFullName(String newFullName, String email);


    @Modifying
    @Query("UPDATE Customer m set m.age = ?1 where m.email = ?2")
    void updateAge(int age, String email);

    @Modifying
    @Query("UPDATE Customer m set m.adress = ?1 where m.email = ?2")
    void updateAdress(String adress,String email);

    @Modifying
    @Query("UPDATE Customer m set m.domain = ?1 where m.email = ?2")
    void updateDomain(String newDomain,String email);


    Optional<Customer> findCustomerByEmail(String email);


}
