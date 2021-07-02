package com.pfe.cigma.PFE.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pfe.cigma.PFE.model.Entreprise;
import com.pfe.cigma.PFE.model.EntrepriseRecruitments;
import com.pfe.cigma.PFE.model.Orders;

public interface IEntrepriseService {

	Entreprise addEntreprise(Entreprise e);

	Entreprise updateEntreprise(Entreprise e);

	boolean DeleteEntreprise(int i);

	Entreprise getEntrepriseById(int id);

	List<Entreprise> getEntreprises();

	Page<Entreprise> getEntreprisePage(Pageable p);

	Page<Entreprise> findAllbyTitleAndOwnerid(String title, int userID, Pageable p);

	Page<Entreprise> findAllbyTitle(String title, Pageable p);

	

}
