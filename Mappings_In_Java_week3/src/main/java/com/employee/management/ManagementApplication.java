package com.employee.management;

import com.employee.management.entities.Laptop;
import com.employee.management.entities.Student;
import com.employee.management.repositories.LaptopRepository;
import com.employee.management.repositories.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(StudentRepository studentRepository, LaptopRepository laptopRepository) {
		return args -> {
			// Create Laptop
			Laptop laptop = new Laptop();

			laptop.setModelNumber("1221");
			laptop.setBrand("HP");


			Student student = new Student();
			student.setStudentName("John");
			student.setAbout("test");
			student.setLaptop(laptop);
			laptop.setStudent(student);

			studentRepository.save(student);

		};
	}

}
