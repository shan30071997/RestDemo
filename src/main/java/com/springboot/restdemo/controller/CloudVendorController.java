package com.springboot.restdemo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.restdemo.model.CloudVendor;
import com.springboot.restdemo.response.ResponseHandler;
import com.springboot.restdemo.service.CloudVendorService;


@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {

	CloudVendor cloudVendor;
	CloudVendorService cloudVendorService;
	
	public CloudVendorController(CloudVendorService cloudVendorService) {
		this.cloudVendorService = cloudVendorService;
	}


	
	  @GetMapping("/search/id") 
	  public ModelAndView getCloudVendorDetails(@ModelAttribute @RequestParam("vendorId") String vendorId, Model model) {
	  ModelAndView modelAndView = new ModelAndView("listVendors");
	  return modelAndView.addObject("vendors", cloudVendorService.getCloudVendor(vendorId)); 
	  
	  }
	  
	  @GetMapping("/search") 
	  public ModelAndView search() {
	  ModelAndView modelAndView = new ModelAndView("searchvendor");
	  CloudVendor cloudVendor = new CloudVendor();
	  return modelAndView.addObject("cloudVendor",cloudVendor); 
	  }
	
	  
	  
	  @GetMapping()
		public ModelAndView index() {
			ModelAndView modelAndView = new ModelAndView("index");
			return modelAndView.addObject("cloudVendor", new CloudVendor());
			
		}
	  
	@GetMapping("/add")
	public ModelAndView addVendorDetails() {
		//List<CloudVendor> cloudVendors= cloudVendorService.getAllCloudvendors();
		ModelAndView modelAndView = new ModelAndView("addVendor");
		//modelAndView.addObject("vendors", cloudVendors);
		return modelAndView.addObject("cloudVendor", new CloudVendor());
		
	}
	

	@GetMapping("/cloudvendors")
	public ModelAndView getCloudVendorDetails() {
		List<CloudVendor> cloudVendors= cloudVendorService.getAllCloudvendors();
		ModelAndView modelAndView = new ModelAndView("listVendors");
		return modelAndView.addObject("vendors", cloudVendors);
		
		
	}
	
	@PostMapping("/showadded")
	public ModelAndView createCloudVendorDetails(@ModelAttribute CloudVendor cloudVendor2, Model model) {
		
		CloudVendor cloudVendor = cloudVendorService.createCloudVendor(cloudVendor2);
		ModelAndView modelAndView = new ModelAndView("listVendors");
		System.out.println(cloudVendor2.toString());
		return modelAndView.addObject("vendors",cloudVendor);
	}
	
	@PutMapping
	public String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor) {
		cloudVendorService.updateCloudVendor(cloudVendor);
		return "Cloud vendor updated successfully";
	}
	
	@GetMapping("/delete/{vendorId}")
	public ModelAndView deleteCloudVendorDetails(@ModelAttribute @PathVariable("vendorId") String vendorId, Model model) {
		cloudVendorService.deleteCloudVendor(vendorId);
		List<CloudVendor> cloudVendors= cloudVendorService.getAllCloudvendors();
		ModelAndView modelAndView = new ModelAndView("listVendors");
		return modelAndView.addObject("vendors", cloudVendors);
		
	}
}
