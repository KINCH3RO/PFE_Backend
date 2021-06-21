package com.pfe.cigma.PFE.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pfe.cigma.PFE.DAO.IOrdersDAO;
import com.pfe.cigma.PFE.DAO.IServiceDAO;
import com.pfe.cigma.PFE.DAO.IUserDAO;
import com.pfe.cigma.PFE.model.Orders;
import com.pfe.cigma.PFE.model.User;

@Service
@Transactional
public class OrderServiceImpl implements IOrdersService {

	@Autowired
	IOrdersDAO ordersDAO;

	@Autowired
	IUserDAO userDAO;

	@Autowired
	IServiceDAO serviceDAO;

	@Override
	public Orders addOrder(Orders o) {

		// TODO Auto-generated method stub
		return ordersDAO.save(o);
	}

	@Override
	public Orders updateOrder(Orders o) {
		// TODO Auto-generated method stub
		return ordersDAO.save(o);
	}

	@Override
	public boolean deleteOrderByid(int id) {
		// TODO Auto-generated method stub
		ordersDAO.deleteById(id);
		return true;
	}

	@Override
	public Orders findOne(int id) {
		// TODO Auto-generated method stub
		return ordersDAO.findById(id).get();
	}

	@Override
	public List<Orders> getAll() {
		// TODO Auto-generated method stub
		return (List<Orders>) ordersDAO.findAll();
	}

	@Override
	public Page<Orders> findAllbyTitleAndType(String title, boolean type, Pageable p) {
		// TODO Auto-generated method stub
		return ordersDAO.findAllByTitleContainingAndIsDegital(title, type, p);
	}

	@Override
	public Page<Orders> findAllbyTitleAndUserid(String title, int userID, Pageable p) {
		// TODO Auto-generated method stub;
		Optional<User> foundUser = userDAO.findById(userID);
		if (foundUser.isEmpty()) {
			return null;
		}
		return ordersDAO.findAllByTitleContainingAndUser(title, foundUser.get(), p);
	}

	@Override
	public ResponseEntity<?> addServiceToOrder(int orderId, int serviceId) {

		Optional<Orders> optionalOrder = ordersDAO.findById(orderId);
		if (optionalOrder.isEmpty()) {
			return new ResponseEntity<>("Order  not found", HttpStatus.BAD_GATEWAY);
		}

		Optional<com.pfe.cigma.PFE.model.Service> optionalService = serviceDAO.findById(serviceId);
		if (optionalService.isEmpty()) {
			return new ResponseEntity<>("Service not found", HttpStatus.BAD_GATEWAY);
		}
		Orders order= optionalOrder.get();
		com.pfe.cigma.PFE.model.Service foundService=optionalService.get();

		if (order.getServices().contains(foundService)) {
			return new ResponseEntity<>("service  Already  in the order", HttpStatus.BAD_GATEWAY);
		}
		order.getServices().add(foundService);
		ordersDAO.save(order);
		return new ResponseEntity<>("Service  Added succesfully", HttpStatus.OK);

	}

	@Override
	public ResponseEntity<?> deleteServiceFromOrder(int orderId, int serviceId) {

		Optional<Orders> optionalOrder = ordersDAO.findById(orderId);
		if (optionalOrder.isEmpty()) {
			return new ResponseEntity<>("Order  not found", HttpStatus.BAD_GATEWAY);
		}

		Optional<com.pfe.cigma.PFE.model.Service> optionalService = serviceDAO.findById(serviceId);
		if (optionalService.isEmpty()) {
			return new ResponseEntity<>("Service not found", HttpStatus.BAD_GATEWAY);
		}
		Orders order= optionalOrder.get();
		com.pfe.cigma.PFE.model.Service foundService=optionalService.get();

		if (!order.getServices().contains(foundService)) {
			return new ResponseEntity<>("Service doesn't exist in the order", HttpStatus.BAD_GATEWAY);
		}

		order.getServices().remove(foundService);
		ordersDAO.save(order);

		// TODO Auto-generated method stub
		return new ResponseEntity<>("Service removed succesfully", HttpStatus.OK);
	}

}
