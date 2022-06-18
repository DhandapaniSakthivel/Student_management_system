package net.javaguides.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import net.javaguides.sms.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
 
}
