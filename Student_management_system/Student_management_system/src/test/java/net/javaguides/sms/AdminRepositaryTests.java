package net.javaguides.sms;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import net.javaguides.sms.entity.Admin;
import net.javaguides.sms.entity.Student;
import net.javaguides.sms.repository.AdminRepository;
import net.javaguides.sms.repository.StudentRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class AdminRepositaryTests {
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
	 Admin admin = new Admin();
	 admin.setUsername("java@gmail.com");
	 admin.setPassword("12345678");
	 
	 Admin saveAdmin=adminRepository.save(admin);
	 Admin exitAdmin=entityManager.find(Admin.class, saveAdmin.getId());
	 assertThat(exitAdmin.getUsername()).isEqualTo(admin.getUsername());
	}
	
	@Test
	public void getStudentTest() {
	Student student=studentRepository.findById(1L).get();
	Assertions.assertThat(student.getId()).isEqualTo(1L);
	}
	
	
	@Test
	public void getListOfStudentsTest() {
	List<Student> students=studentRepository.findAll();
	Assertions.assertThat(students.size()).isGreaterThan(0);
	}
	
	
	@Test
	public void updateStudentTest() {
	Admin admin=adminRepository.findById(1L).get();
	Assertions.assertThat(admin.getUsername()).isNotEqualTo("sdhandapani321@gmail.com");
	}
	
}
