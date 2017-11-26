package com.skyline.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skyline.entity.property.Property;
import com.skyline.entity.student.Student;
import com.skyline.service.serviceInterface.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping("student-list")
	public String listStudents(Model theModel){
		
		// get students
	    List<Student> theStudents = studentService.getAll();
	    
	    theModel.addAttribute("students", theStudents);	
		
		return "student-list";
	}
	
	@GetMapping("student-detail")
	public String addStudent(Model theModel){
		
		
	Student theStudent = new Student();	
	
	theModel.addAttribute("student",theStudent);
		
		return "student-detail";
	}
		
	@PostMapping("saveStudent")
	public String saveStudent(
			@Valid @ModelAttribute("student") Student theStudent,
			BindingResult theBindingResult, Model theModel){
		
		
		if(theBindingResult.hasErrors()){
			
			return"student-detail";
		}else{	
			studentService.saveOrUpdate(theStudent);			
			return "redirect:/displayProperty?theId=" + theStudent.getId() + "&saved=1";
		}			
	}

	@GetMapping("displayStudent")
	public String displayStudent(@RequestParam("theId") int studentId, @RequestParam(value="saved", required=false) boolean saved,
			Model theModel){
			
		Student theStudent = studentService.find(studentId);
				
		if(saved){
			theModel.addAttribute("saved", true); 
		}	
		
		theModel.addAttribute("student", theStudent);
		
		return "student-detail";	
	} 
}
