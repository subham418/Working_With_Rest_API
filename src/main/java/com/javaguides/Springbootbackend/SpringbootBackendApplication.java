package com.javaguides.Springbootbackend;

import com.javaguides.Springbootbackend.model.Employee;
import com.javaguides.Springbootbackend.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private ApiRepository apiRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee();
		employee.setFname("Subham");
		employee.setLname("Sah");
		employee.setEmailid("sk.gmail");
		apiRepository.save(employee);

		Employee employee1=new Employee();
		employee1.setFname("Shivam");
		employee1.setLname("Mishra");
		employee1.setEmailid("sm@gmail.com");
		apiRepository.save(employee1);

		Employee employee2=new Employee();
		employee2.setFname("Shalu");
		employee2.setLname("Mishra");
		employee2.setEmailid("sg@gmail.com");
		apiRepository.save(employee2);
	}
}
