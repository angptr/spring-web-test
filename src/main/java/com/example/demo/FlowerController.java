package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.AllArgsConstructor;
	
@Controller
@AllArgsConstructor
public class FlowerController {
	
	private FlowerService service;
	
//	function to show add new flower form when click add flower button
	@GetMapping("/flowers/add")
	public String showForm(Model model) {
		model.addAttribute("flower", new Flower());
		return "add_flower";
	}
	 
//	function to save flower after add or edit
	@PostMapping("/flowers/save")
	public String saveFlower(@ModelAttribute("flower") Flower flower) {		
		service.save(flower);
		return "redirect:/";
	}
	
	@GetMapping("")
	public String showHomePage(Model model) {
		model.addAttribute("listFlowers", service.getAllFlowers());
		return "index";
	}
	
//	function to edit flower when click edit button
	@GetMapping("/flowers/edit/{id}")
	public String updateFlowerById(@PathVariable("id") Long id, Model model) {
		Flower flower = service.getFlowerById(id);		
		model.addAttribute("flower", flower);
		return "update_flower";
	}
	
//	function to delete flower when click edit button
	@GetMapping("/flowers/delete/{id}")
	public String deleteFlowerById(@PathVariable("id") Long id) {
		service.deleteFlower(id);
		return "redirect:/";
	}

}
