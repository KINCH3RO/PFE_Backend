package com.pfe.cigma.PFE.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.pfe.cigma.PFE.model.Profile;
import com.pfe.cigma.PFE.model.User;

public interface IProfileService {
	
	Profile addProfile(Profile U);
	Profile updateProfile(Profile u);
	Profile findProfileByUser(User u);
	boolean deleteProfile(Profile u);	
	List<Profile> getProfiles();
	Profile getProfileById(int id);
	boolean deleteProfileById(int id);
	Page<Profile> getPage(Pageable p);
	List<Profile> findAllByUsers(List<User> users);
	Page<Profile> findAllByCountryAndLangAndSpeciality(String country,String lang,String spec,Pageable p);
	boolean getProfileStatus(int id);
	String getSpecialisation(int userId);
	
	
}
