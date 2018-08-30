package com.qa.springDatabase;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class DVDStoreCustomerController {

	@Autowired
	DVDStoreCustomerRepository dvdStoreCustomerRepository;
	
	@PostMapping("/add")
	public DVDStoreCustomerModel createCustomer(@Valid @RequestBody DVDStoreCustomerModel dscm) {
		return dvdStoreCustomerRepository.save(dscm);
	}
	
	@GetMapping("/")
	public List<DVDStoreCustomerModel> getCustomers(){
		return dvdStoreCustomerRepository.findAll();
	}
	
	@DeleteMapping("/{customerID}")
	public ResponseEntity<?> deleteCustomer(@PathVariable(value = "customerID") Long customerID){
		DVDStoreCustomerModel dscm = dvdStoreCustomerRepository.findById(customerID).orElseThrow(()->
		new ResourceNotFoundException("Customer Delete", "customerID", customerID));
		
		dvdStoreCustomerRepository.delete(dscm);
		return ResponseEntity.ok().build();
	}
}
