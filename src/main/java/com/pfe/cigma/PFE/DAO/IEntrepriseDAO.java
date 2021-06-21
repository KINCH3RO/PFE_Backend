package com.pfe.cigma.PFE.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pfe.cigma.PFE.model.Entreprise;

import com.pfe.cigma.PFE.model.User;

@Repository
public interface IEntrepriseDAO extends CrudRepository<Entreprise, Integer> {
	
	Page<Entreprise> findAllByNameContainingAndOwner(String name,User u,Pageable p);
	Page<Entreprise> findAllByNameContaining(String name,Pageable p);

}
