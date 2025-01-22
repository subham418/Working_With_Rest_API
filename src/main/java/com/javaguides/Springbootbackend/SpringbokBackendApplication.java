package com.javaguides.Springbootbackend;

import com.javaguides.Springbootbackend.model.Employee;
import com.javaguides.Springbootbackend.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbokBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringbokBackendApplication.class, args);
	}

	@Autowired
	private ApiRepository apiRepository;

	@Override
	public void run(String... args) {
		Employee employee=new Employee();
		employee.setFirst_name("Abc");
		employee.setLast_name("Sah");
		employee.setEmail_id("sk.gmail");
		apiRepository.save(employee);

		Employee employee1=new Employee();
		employee1.setFirst_name("BCD");
		employee1.setLast_name("Mishra");
		employee1.setEmail_id("sm@gmail.com");
		apiRepository.save(employee1);

		Employee employee2=new Employee();
		employee2.setFirst_name("GEF");
		employee2.setLast_name("Mishra");
		employee2.setEmail_id("sg@gmail.com");
		apiRepository.save(employee2);
	}
}
