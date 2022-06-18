package net.javaguides.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.javaguides.sms.entity.Admin;
import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.AdminRepository;
import net.javaguides.sms.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementSystemApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public void run(String... args) throws Exception {		

		Student student1 = new Student("Dhandapani", "S", "dhandapani123@gmail.com",23,"ECE",8.2);
		studentRepository.save(student1);

		Student student2 = new Student("Hareesh", "R", "hareesh456@gmail.com",24,"ECE",8.3);
		studentRepository.save(student2);

		Student student3 = new Student("Vijay", "kumar", "vijay789@gmail.com",22,"ECE",8.2);
		studentRepository.save(student3);
		
		Admin admin = new Admin("admin","Savd@1234");
		adminRepository.save(admin);
		
	}

	}
	


