
package com.task.metquay.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.task.metquay.model.Employee;
import com.task.metquay.services.EmployeeService;

@Controller
public class AppController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("")
	public String getHome(Model model) {
		List<Employee> employeelist = employeeService.listallEmployee();
		model.addAttribute("employeelist", employeelist);
		return "index";
	}
	@GetMapping("/new")
	public String newEmployee(Model model) {
      Employee employee= new Employee();
      model.addAttribute("employee", employee);
		return "new_employee";
	}
	@PostMapping(value = "/add")
	private String addEmployee(@ModelAttribute("employee")Employee employee) {
		employeeService.save(employee);
		return "redirect:/";
	}
	@GetMapping(value = "/edit/{id}")
	public String showUpdateForm(@PathVariable("id")Long id,Model model) {
		//ModelAndView mav = new ModelAndView("edit_form");
		Employee employee = employeeService.getedit(id);
		model.addAttribute("employee", employee);
		return "edit_form";
		
	}
	@RequestMapping(value = "/delete/{id}")
	public String deleteEmployee(@PathVariable("id")Long id)
	{
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
	}
	@PostMapping(value = "/update/{id}")
	public String updateEmployee(@PathVariable("id") long id,Model model,@Valid Employee employee,BindingResult result) {
		if (result.hasErrors()) {
			employee.setId(id);
			return "edit_form";
		}
		employeeService.updateUserbyId(employee);
		return "redirect:/";
		
	
	}
	
}
