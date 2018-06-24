package com.finreach.IPBlacklistMonitor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.finreach.IPBlacklistMonitor.model.IPAddress;
import com.finreach.IPBlacklistMonitor.repository.IPAddressRepository;


// REST API controller for reading and managing IP Address filters.

@RestController
@RequestMapping("/api/v1/ip")
public class IPAddressController {
	
	@Autowired
	IPAddressRepository ipAddressRepo;

	// Get current blacklist configuration
	@GetMapping
	public List<IPAddress> list(){
		
		return ipAddressRepo.findAll();
	}
	
	// Add a filtering configuration to the blacklist
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public void create(@RequestBody IPAddress ipAddress) {
		
		ipAddressRepo.save(ipAddress);
	}
	
	
	// Delete a filtering configuration from the blacklist
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id){
		
		ipAddressRepo.deleteById(id);
	}
	
	// Check if an IP address is present in the blacklist
	@GetMapping("/{id}")
	public boolean isBlackListed(@PathVariable("id") Long id) {
		
		return ipAddressRepo.existsById(id);
	}
}
