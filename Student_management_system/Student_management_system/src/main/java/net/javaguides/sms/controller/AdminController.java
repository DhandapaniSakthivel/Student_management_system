package net.javaguides.sms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import net.javaguides.sms.entity.Admin;
import net.javaguides.sms.repository.AdminRepository;

@Controller
public class AdminController {
	
	@Autowired
	private AdminRepository repo;
	
	@GetMapping("/signup")
	public String adminLogin(Model model) {
		model.addAttribute("signup", new Admin());
		return "signup";
	}
	
	@GetMapping(path="/")
	public String getUsers(@RequestParam(name="username") String username, @RequestParam(name="password") String password) {
	  	String value = null;
	  	Admin admin = new Admin();
	  	List<Admin> admins = repo.findAll();
	  	
	  	try {
	  		if(!admins.isEmpty() && admins.size()>0)
	  		{

	  			for(Admin a : admins)

	  			{

	  				if(username.equals(a.getUsername()) && password.equals(a.getPassword()))
	  				{

	  					value = "redirect:/students";
	  					break;
	  				}
	  				else
	  				{

	  					value = "redirect:/homePage";
	  				}
	  			}
	  		}
	  	}
	  catch(Exception e)
	  {
		  System.out.println("Admin table is empty"+e.getMessage());
	  }
	  	
	  		return value;
	  	
	}
	
	@PostMapping("/signup")
	public String processRegistration(@ModelAttribute("admin")Admin admin)
	{
		repo.save(admin);
		return "redirect:/homePage";
	}
	
}
