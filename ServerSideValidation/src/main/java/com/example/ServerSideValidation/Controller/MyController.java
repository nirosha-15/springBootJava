package com.example.ServerSideValidation.Controller;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ServerSideValidation.entities.LoginData;



@Controller
public class MyController {

	@GetMapping("/form")
	public String openForm(Model model) {
		System.out.println("opening form");
		model.addAttribute("loginData", new LoginData());
		return "form";
	}
	@GetMapping("/nirosha")
	public String getHello() {
		return "welcome dear";
	}
	@GetMapping("/komala")
	public String getKHello() {
		return "welcome dear";
	}
	//handler for process form
	@PostMapping("/process")
	public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result)
	{
		
		if(result.hasErrors())
		{
			
			System.out.println(result);
			return "form";
		}
		
		System.out.println(loginData);
		//data process
		return "success";
	}
}
