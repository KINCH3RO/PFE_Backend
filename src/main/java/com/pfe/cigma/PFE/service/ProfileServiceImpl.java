package com.pfe.cigma.PFE.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pfe.cigma.PFE.DAO.IRoleDAO;
import com.pfe.cigma.PFE.DAO.IProfileDAO;
import com.pfe.cigma.PFE.model.Education;
import com.pfe.cigma.PFE.model.Profile;
import com.pfe.cigma.PFE.model.User;

@Service
@Transactional
public class ProfileServiceImpl implements IProfileService {

	@Autowired
	IProfileDAO ProfileDAO;

	@Override
	public Profile addProfile(Profile U) {

		// TODO Auto-generated method stub
	 Profile pro = ProfileDAO.findByUser(U.getUser());
	 if(pro !=null) {
		 return null;
	 }
		return ProfileDAO.save(U);
	}

	@Override
	public Profile updateProfile(Profile u) {
		// TODO Auto-generated method stub
		return ProfileDAO.save(u);
	}

	@Override
	public boolean deleteProfile(Profile u) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Profile> getProfiles() {
		// TODO Auto-generated method stub
		return (List<Profile>) ProfileDAO.findAll();
	}

	@Override
	public Profile getProfileById(int id) {
		// TODO Auto-generated method stub
		return ProfileDAO.findById(id).get();
	}

	@Override
	public boolean deleteProfileById(int id) {
		// TODO Auto-generated method stub
		ProfileDAO.deleteById(id);
		return true;
	}

	@Override
	public Page<Profile> getPage(Pageable p) {
		// TODO Auto-generated method stub
		return ProfileDAO.findAll(p);
	}

	@Override
	public Profile findProfileByUser(User u) {
		// TODO Auto-generated method stub
		return ProfileDAO.findByUser(u);
	}

	@Override
	public List<Profile> findAllByUsers(List<User> users) {
		// TODO Auto-generated method stub
		return ProfileDAO.findAllByUserIn(users);
	}

}
