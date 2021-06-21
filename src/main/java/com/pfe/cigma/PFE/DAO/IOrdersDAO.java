package com.pfe.cigma.PFE.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.pfe.cigma.PFE.model.Orders;
import com.pfe.cigma.PFE.model.User;


@Repository
public interface IOrdersDAO  extends CrudRepository<Orders,Integer> {
	
	Page<Orders> findAllByTitleContainingAndIsDegital(String title,boolean isdegital,Pageable p);
	Page<Orders> findAllByTitleContainingAndUser(String title,User u,Pageable p);

}
