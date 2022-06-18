package net.javaguides.sms.service.impl;
import org.springframework.stereotype.Service;

import net.javaguides.sms.repository.AdminRepository;
import net.javaguides.sms.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService {

	private AdminRepository adminRepository;
	
	public AdminServiceImpl(AdminRepository adminRepository) {
		super();
		this.adminRepository = adminRepository;
	}

}







