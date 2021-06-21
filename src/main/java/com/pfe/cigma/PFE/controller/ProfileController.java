package com.pfe.cigma.PFE.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import com.pfe.cigma.PFE.model.Profile;
import com.pfe.cigma.PFE.model.User;
import com.pfe.cigma.PFE.service.IRoleService;
import com.pfe.cigma.PFE.service.IProfileService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/profiles")
public class ProfileController {
	@Autowired
	IProfileService ProfileService;

	@Autowired
	IRoleService roleService;

	@GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Profile> getProfiles() {

		return ProfileService.getProfiles();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Profile getProfile(@PathVariable("id") int id) {

		return ProfileService.getProfileById(id);
	}

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addProfile(@RequestBody Profile u) {

		System.out.println("add received");

		Profile Profile = ProfileService.addProfile(u);
		if (Profile == null) {
			return new ResponseEntity<>("Profile already exist", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(Profile, HttpStatus.OK);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Profile updateProfile(@RequestBody Profile u) {

		return ProfileService.updateProfile(u);
	}

	@DeleteMapping(path = "/delete/{id}")
	public String deleteProfile(@PathVariable("id") int id) {
		ProfileService.deleteProfileById(id);
		return "Profile has been deleted Succesfully";
	}

	@PostMapping(path = "/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> profileByUser(@RequestBody User u) {
       Profile pro = ProfileService.findProfileByUser(u);
       if (pro == null) {
			return new ResponseEntity<>("Profile not found", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(pro, HttpStatus.OK);
	}

	@GetMapping(params = { "pageSize", "pageNumber" })
	public Page<Profile> getPages(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		return ProfileService.getPage(p);
	}
	
	@PostMapping(path = "allByUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Profile> getProfilesByUsers(@RequestBody List<User> users) {

		return ProfileService.findAllByUsers(users);
	}

}
