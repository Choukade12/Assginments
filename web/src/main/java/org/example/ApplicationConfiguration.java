package org.example;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public EmployeeService EmployeeService(){return new EmployeeServiceImple();};
}
