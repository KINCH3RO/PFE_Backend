package com.pfe.cigma.PFE.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pfe.cigma.PFE.DAO.IEntrepriseDAO;
import com.pfe.cigma.PFE.DAO.IUserDAO;
import com.pfe.cigma.PFE.model.Entreprise;
import com.pfe.cigma.PFE.model.Orders;
import com.pfe.cigma.PFE.model.User;

@Service
@Transactional
public class EntrepriseServiceImpl implements IEntrepriseService{

	@Autowired
  IEntrepriseDAO entrepriseDAO;
	@Autowired
	IUserDAO userDAO;
	
	@Override
	public Entreprise addEntreprise(Entreprise e) {
		// TODO Auto-generated method stub
		return entrepriseDAO.save(e);
	}

	@Override
	public Entreprise updateEntreprise(Entreprise e) {
		// TODO Auto-generated method stub
		return entrepriseDAO.save(e);
	}

	@Override
	public boolean DeleteEntreprise(int i) {
		// TODO Auto-generated method stub
		 entrepriseDAO.deleteById(i);
		 return true;
	}

	@Override
	public Entreprise getEntrepriseById(int id) {
		// TODO Auto-generated method stub
		return entrepriseDAO.findById(id).get();
	}

	@Override
	public List<Entreprise> getEntreprises() {
		// TODO Auto-generated method stub
		return (List<Entreprise>) entrepriseDAO.findAll();
	}

	@Override
	public Page<Entreprise> getEntreprisePage(Pageable p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Entreprise> findAllbyTitleAndOwnerid(String title, int userID, Pageable p) {
		// TODO Auto-generated method stub
		Optional<User> foundUser = userDAO.findById(userID);
		if (foundUser.isEmpty()) {
			return null;
		}
		return entrepriseDAO.findAllByNameContainingAndOwner(title, foundUser.get(), p);
	}

	@Override
	public Page<Entreprise> findAllbyTitle(String title, Pageable p) {
		// TODO Auto-generated method stub
		return entrepriseDAO.findAllByNameContaining(title, p);
	}

}
