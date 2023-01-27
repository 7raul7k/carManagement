package ro.mycode.carManagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.carManagement.models.Car;
import ro.mycode.carManagement.models.Customer;
import ro.mycode.carManagement.repo.CustomerRepo;

@SpringBootApplication
public class CarManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarManagementApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner ( CustomerRepo customerRepo){
		return args -> {

           Customer customer = customerRepo.findCustomerByEmail("alilburn2r@msu.edu").get();

		   Car car = new Car("Audi","Allianora Lilburn",2009,"benzina",120,"gray");




		   customer.addCar(car);


//
		   customerRepo.save(customer);







		};
	}

}
