package com.pfe.cigma.PFE.controller;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import com.pfe.cigma.PFE.DAO.IRoleDAO;
import com.pfe.cigma.PFE.DAO.IUserDAO;
import com.pfe.cigma.PFE.components.FileUploader;
import com.pfe.cigma.PFE.components.FileUploader.FileType;
import com.pfe.cigma.PFE.model.Role;
import com.pfe.cigma.PFE.model.User;
import com.pfe.cigma.PFE.service.IRoleService;
import com.pfe.cigma.PFE.service.IUserService;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	IUserService userService;

	@Autowired
	FileUploader up;

	@Autowired
	IRoleService roleService;

	@GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getUsers() {

		return userService.getUsers();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public User getUser(@PathVariable("id") int id) {

		return userService.getUserById(id);
	}

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addUser(@RequestBody User u) {
		System.out.println("add received");
		User user = userService.addUser(u);
		if (user == null) {
			return new ResponseEntity<>("Email or username already exist", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public User updateUser(@RequestBody User u) {

		return userService.updateUser(u);
	}

	@DeleteMapping(path = "/delete/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		userService.deleteUserById(id);
		return "User has been deleted Succesfully";
	}

	@GetMapping(params = { "pageSize", "pageNumber" })
	public Page<User> getPages(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		return userService.getPage(p);
	}

	@GetMapping(params = { "pageSize", "pageNumber", "name", "famName", "roleId" })
	public Page<User> getFiltredPages(@RequestParam("pageSize") int pageSize,
			@RequestParam("pageNumber") int pageNumber, @RequestParam("name") String name,
			@RequestParam("famName") String famName, @RequestParam("roleId") int roleId) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		Role r=null;
		try {
			r = roleService.getRoleById(roleId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
       
		return userService.getFiltredPages(name, famName, p, r);
	}

	@PostMapping(path = "/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody User u) throws Exception {
		User user = userService.login(u);
		if (user == null) {
			return new ResponseEntity<>("Email or password is incorrect", HttpStatus.NOT_FOUND);
		}
//		if(user.isEmailVerified()==false) {
//			return new ResponseEntity<>("Email is not verified,please check your email inbox",HttpStatus.NOT_ACCEPTABLE);
//		}
//		
//		if(!user.getAccountStatus().equals("normal")) {
//			return new ResponseEntity<>("your account is blocked , please check your email",HttpStatus.NOT_ACCEPTABLE);
//		}

		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PostMapping(path = "/fileUpload", produces = MediaType.TEXT_PLAIN_VALUE)
	public String uploadFile(@RequestParam(value = "file") MultipartFile file)
			throws IOException {

		
		System.out.println("requesting file");
		File f = up.uploadFile("profilePic", file);
		return f.getName();
	}

//	@GetMapping(path = "/role", produces = MediaType.APPLICATION_JSON_VALUE)
//	public List<User> getUsers(@RequestParam(value="roleId") int id) {
//        Role r = IRoleDAO.findById(id).get();
//		return userDao.findAllByRole(r);
//	}

}
