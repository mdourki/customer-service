package com.jeetp.customerservice;

import com.jeetp.customerservice.entities.Customer;
import com.jeetp.customerservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


@SpringBootApplication
@RequiredArgsConstructor
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    private final RepositoryRestConfiguration restConfiguration;
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository ) {
        restConfiguration.exposeIdsFor(Customer.class);
        return args -> {
            customerRepository.save(new Customer(null , "Mohamed" , "Mohamed@gmail.com"));
            customerRepository.save(new Customer(null , "Simo" , "Simo@gmail.com"));
            customerRepository.save(new Customer(null , "Hassan" , "Hassan@gmail.com"));
            customerRepository.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }
}
