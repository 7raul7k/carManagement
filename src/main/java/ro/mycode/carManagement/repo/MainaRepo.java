package ro.mycode.carManagement.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mycode.carManagement.models.Car;

@Repository
public interface MainaRepo extends JpaRepository<Car,Long> {
}
