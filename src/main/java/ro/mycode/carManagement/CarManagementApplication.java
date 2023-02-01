package ro.mycode.carManagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.mycode.carManagement.services.CustomerService;

@SpringBootApplication
public class CarManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (CustomerService customerService){
		return args ->{

			// findByNameAndEmail
//			Customer customer = customerService.getCustomerByNameAndEmail("Andrei Popescu","andreipopescu@gmail.com").get();
//			System.out.println(customer);

//			//findByEmail
//			Customer customer = customerService.getCustomerByEmail("andreipopescu@gmail.com").get();
//			System.out.println(customer);
//
			//addCar
//			Car car = new Car("Audi","Andrei Popescu",2013,"benzina",230,"albastru");
//		    customerService.addCar(car,"Andrei Popescu","andreipopescu@gmail.com");
//			List<Car> m = customerService.getCustomerByEmail("andreipopescu@gmail.com").get().getCarList();
//			for(Car c : m ){
//				System.out.println(c);

//			//deleteCar
//			customerService.deleteCar("Audi","Andrei Popescu","andreipopescu@gmail.com");

			//getAllCustomers
//			List<Customer> customers = customerService.getallCustomers();
//			System.out.println(customers);

			//addCustomer
//			Customer customer = new Customer("Cristian Popovici","cristianpopovici@gmail.com",23,"Bucuresti","IT");
//			customerService.addCustomer(customer);

			//removeCustomer
//			customerService.removeCustomer("Cristian Popovici","cristianpopovici@gmail.com");



	};



}
}
