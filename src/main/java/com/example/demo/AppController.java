package com.example.demo;

import java.util.List;

import javax.persistence.Column;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.lowagie.text.DocumentException;

@Controller
public class AppController {

	@Autowired
	private UserRepository repo;
	
	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		
		return "signup_form";
	}
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		repo.save(user);
		
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String listUsers(Model model) {			
		return "users";
	}
	
	@GetMapping("/candidat")
	public String candidat(Model model) {	
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);	
		return "candidat";
	}
	   
	@Autowired
	 private StudentService service1;
	 
	 List<String> courses; 

	 @RequestMapping(value = "/form" , method = RequestMethod.GET)
	 public String home(Model model, Student student) {
	  model.addAttribute("courses", courses);
	  return "form2";
	 }
	 @RequestMapping(value = "/affiche",method = RequestMethod.POST)
	 public String register(@ModelAttribute("student") Student student, Model model) {
	  service1.save(student);
	  
	  return "welcome2";
	 }
	 
	 @Autowired
	 JdbcTemplate jdbcTemplate;
	 @GetMapping(path="/nombre")
	 public ResponseEntity<List<User>> getAllUsers(){
		   List<User> users= jdbcTemplate.query("select  count(id) from users",new BeanPropertyRowMapper(User.class));
		   return new ResponseEntity<>(users,HttpStatus.OK);		   
	 }

//	 @GetMapping("/listBySession1")
//	 public ResponseEntity<List<CountSession1>> getAllBySession1(){
//		   List<CountSession1> student= StudentService.listBySession1();
//		   return new ResponseEntity<>(student,HttpStatus.OK);	
//	 }

		 
		@Autowired
		    private UserServices service;		     

		public void setService(UserServices service) {
			this.service = service;
		}


		 @GetMapping("/users/export/cvs")
		    public void exportCSV(HttpServletResponse response) throws Exception {

		        //set file name and content type
		        String filename = "users.csv";;
		        response.setContentType("text/csv");
		        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
		                "attachment; filename=\"" + filename + "\"");
		        List<User> listUsers = service.listAll();
		        //create a csv writer
		        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		        String[] csvHeader = {"id", "email"  };
		        String[] nameMapping = {"id", "email" };
		         
		        csvWriter.writeHeader(csvHeader);
		        
		        for (User user : listUsers) {
		            csvWriter.write(user, nameMapping);
		        }
		        
		        csvWriter.close();
		        
		    }
	 
	
		    @GetMapping("/users/export/pdf")
		    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
		        response.setContentType("application/pdf");
		        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		        String currentDateTime = dateFormatter.format(new Date());
		         
		        String headerKey = "Content-Disposition";
		        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
		        response.setHeader(headerKey, headerValue);
		         
		        List<User> listUsers = service.listAll();
		         
		        UserPDFExporter exporter = new UserPDFExporter(listUsers);
		        exporter.export(response);
		         
		    }
}


