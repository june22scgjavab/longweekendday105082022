package com.example;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import com.example.dto.CustomerDTO;
import com.example.exception.CustomerException;
import com.example.service.CustomerService;

@SpringBootApplication
public class SpringdatademoApplication implements CommandLineRunner {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(SpringdatademoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//addCustomer();
		//findCustomer();
		findAllCustomer();
		//updateCustomer();
		//deleteCustomer();

	}

	private void deleteCustomer() {
		try {
			customerService.deleteCustomer(10);
		} catch (CustomerException e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}

	}

	private void updateCustomer() {
		try {
			customerService.updateCustomer(10, "akash01@infy.com");
		} catch (CustomerException e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}

	}

	private void findAllCustomer() {
		try {
			List<CustomerDTO> customerDTOList = customerService.findAll();
			System.out.println(customerDTOList);
		} catch (CustomerException e) {

			System.out.println(environment.getProperty(e.getMessage()));
		}

	}

	
	private void findCustomer() {
		try {
			CustomerDTO customerDTO = customerService.getCustomer(1);
			System.out.println(customerDTO);
		} catch (CustomerException e) {
			System.out.println(environment.getProperty(e.getMessage()));
		}

	}

	private void addCustomer() {
		try {
			CustomerDTO customerDTO = new CustomerDTO();
			customerDTO.setCustomerId(10);
			customerDTO.setName("Akash Kumar");
			customerDTO.setEmailId("akash@infy.com");
			customerDTO.setDateOfBirth(LocalDate.of(1980, 10, 20));

			customerService.addCustomer(customerDTO);
		} catch (CustomerException e) {

			System.out.println(environment.getProperty(e.getMessage()));
		}

	}

}
