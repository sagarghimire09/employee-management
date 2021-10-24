package com.example.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

//    @Bean
//    CommandLineRunner runner(UserService userService) {
//        return args -> {
//            userService.saveRole(new Role(null, "ROLE_ADMIN"));
//            userService.saveUser(new AppUser(null, "John", "Doe", "johndoe", "password", null));
//            userService.addRoleToUser("johndoe", "ROLE_ADMIN");
//        };
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
