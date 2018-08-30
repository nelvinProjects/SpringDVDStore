package com.qa.springDatabase;

import java.util.List;
import java.util.stream.Collectors;

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
@RequestMapping("/dvd")
public class DVDStoreDVDSController {

	@Autowired
	DVDStoreRepository dvdStoreRepository;
	
	@PostMapping("/add")
	public DVDStoreDVDSModel addDVD(@Valid @RequestBody  DVDStoreDVDSModel dsdm) {
		return dvdStoreRepository.save(dsdm);
	}
	
	@GetMapping("/")
	public List<DVDStoreDVDSModel> getAllDVDs(){
		return dvdStoreRepository.findAll();
	}
	
	@GetMapping("/avaliable")
	public List<DVDStoreDVDSModel> getFreeDVDs(){
		return dvdStoreRepository.findAll().stream().filter(x -> !x.getRented()).collect(Collectors.toList());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteDVD(@PathVariable(value = "id") Long dvdID){
		DVDStoreDVDSModel dsdm = dvdStoreRepository.findById(dvdID).orElseThrow(()->
		new ResourceNotFoundException("DVD Delete", "dvdID", dvdID));
		
		dvdStoreRepository.delete(dsdm);
		return ResponseEntity.ok().build();
	}
	
	@Autowired
	DVDStoreOrderRepository orderRepository;

	
	@PostMapping("/order/add")
	public DVDStoreDVDSModel createOrder(@Valid @RequestBody DVDStoreOrdersModel dsom) {
		orderRepository.save(dsom);
		Long id = dsom.getDvdID();
		DVDStoreDVDSModel updateDSOM = dvdStoreRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Order DVD update", "id", id));
		updateDSOM.setRented(true);
		DVDStoreDVDSModel updateData = dvdStoreRepository.save(updateDSOM);
		return updateData;
	}
	
	@GetMapping("/order")
	public List<DVDStoreOrdersModel> getAllOrder(){
		return orderRepository.findAll();
	}
	
	@DeleteMapping("/order/{id}")
	public ResponseEntity<?> deleteOrder(@PathVariable(value = "id")Long orderID){
		DVDStoreOrdersModel dsom = orderRepository.findById(orderID).orElseThrow(()->
		new ResourceNotFoundException("Order Remove", "id", orderID));
		Long dvdId = dsom.getDvdID();
		orderRepository.delete(dsom);
		
		
		DVDStoreDVDSModel updateDSOM = dvdStoreRepository.findById(dvdId).orElseThrow(()->
		new ResourceNotFoundException("Order DVD update", "id", dvdId));
		updateDSOM.setRented(false);
		DVDStoreDVDSModel updateData = dvdStoreRepository.save(updateDSOM);
		
		return ResponseEntity.ok().build();
	}
	
}
