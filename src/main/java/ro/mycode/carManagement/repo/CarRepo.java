package ro.mycode.carManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.carManagement.models.Car;

import java.util.Optional;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {


    @Query("SELECT car from Car car where car.owner = ?1 AND car.make = ?2")
    Optional<Car> findCarbyOwnerAndMake(String owner,String make);




}
