package com.pfe.cigma.PFE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.cigma.PFE.model.AddOrdersToServiceRequest;
import com.pfe.cigma.PFE.model.Orders;
import com.pfe.cigma.PFE.service.IOrdersService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	IOrdersService ordersService;

	@PostMapping("/add")
	public Orders addOrder(@RequestBody Orders o) {

		return ordersService.addOrder(o);

	}

	@PutMapping("update")
	public Orders updateOrder(@RequestBody Orders o) {

		return ordersService.addOrder(o);

	}

	@DeleteMapping("delete/{id}")
	public boolean deleteOrder(@PathVariable("id") int id) {
		return ordersService.deleteOrderByid(id);

	}

	@GetMapping("/{id}")
	public Orders getOne(@PathVariable("id") int id) {
		return ordersService.findOne(id);
	}

	@GetMapping("/all")
	public List<Orders> findAll() {
		return ordersService.getAll();
	}

	@GetMapping(params = { "pageSize", "pageNumber", "title", "isDegital" })
	public Page<Orders> getPageByTilteAndType(
			@RequestParam("pageSize") int pageSize,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("title") String title,
			@RequestParam("isDegital") Boolean isDegital) {
		
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		return ordersService.findAllbyTitleAndType(title, isDegital,p );

	}
	
	@GetMapping(params = { "pageSize", "pageNumber", "title", "userID" })
	public Page<Orders> getPageByTilteAndUser(
			@RequestParam("pageSize") int pageSize,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("title") String title,
			@RequestParam("userID") int id,
			@RequestParam("sortAsc") boolean sort ) {
		Pageable p = null;
		if(sort) {
			p = PageRequest.of(pageNumber, pageSize,Sort.by(Sort.Direction.ASC, "createdDate"));
		}else {
			p = PageRequest.of(pageNumber, pageSize,Sort.by(Sort.Direction.DESC, "createdDate"));
		}
		

		return ordersService.findAllbyTitleAndUserid(title, id, p);

	}
	
	@PostMapping(path = "/addService" )
	public ResponseEntity<?> addService(@RequestBody AddOrdersToServiceRequest serviceRequest) {
		return ordersService.addServiceToOrder(serviceRequest.getOrderId(), serviceRequest.getServiceId());
		
	}
	
	@PostMapping(path = "/removeService" )
	public ResponseEntity<?> removeService(@RequestBody AddOrdersToServiceRequest serviceRequest) {
		return ordersService.deleteServiceFromOrder(serviceRequest.getOrderId(), serviceRequest.getServiceId());
		
	}

}
