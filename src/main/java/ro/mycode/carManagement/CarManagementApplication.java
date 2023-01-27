package ro.mycode.carManagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.carManagement.resources.Customer;
import ro.mycode.carManagement.services.CustomerService;

import java.util.List;

@SpringBootApplication
public class CarManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarManagementApplication.class, args);
	}


	@Bean
	CommandLineRunner commandLineRunner (CustomerService customerService){
		return args -> {

           Customer customer = new Customer("ceva","popescuandrei@gmail.com",25,"Iasi","Marketing");

		   customerService.updateDomain("Marketing",customer.getFullName(),customer.getEmail());
		};
	}

}
