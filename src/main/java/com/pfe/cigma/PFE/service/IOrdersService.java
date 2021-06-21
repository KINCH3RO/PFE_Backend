package com.pfe.cigma.PFE.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import com.pfe.cigma.PFE.model.Orders;
import com.pfe.cigma.PFE.model.Service;

public interface IOrdersService {

	Orders addOrder(Orders o);

	Orders updateOrder(Orders o);

	boolean deleteOrderByid(int id);

	Orders findOne(int id);

	List<Orders> getAll();

	Page<Orders> findAllbyTitleAndType(String title, boolean type, Pageable p);
	
	Page<Orders> findAllbyTitleAndUserid(String title, int userID, Pageable p);
	
	ResponseEntity<?> addServiceToOrder(int orderId,int serviceId);
	
	ResponseEntity<?> deleteServiceFromOrder(int orderId,int serviceId);

}
