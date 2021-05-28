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

import com.pfe.cigma.PFE.model.Role;
import com.pfe.cigma.PFE.service.IRoleService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	IRoleService RoleService;

	@GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Role> getRoles() {

		return RoleService.getRoles();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Role getRole(@PathVariable("id") int id) {

		return RoleService.getRoleById(id);
	}

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addRole(@RequestBody Role u) {

		Role r= RoleService.addRole(u);
		if(r==null) {
			return new ResponseEntity<>("Role name already exist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new  ResponseEntity<>(r,HttpStatus.OK);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateRole(@RequestBody Role u) {

		Role r= RoleService.updateRole(u);
		if(r==null) {
			return new ResponseEntity<>("Role name already exist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new  ResponseEntity<>(r,HttpStatus.OK);
	}

	@DeleteMapping(path = "/delete/{id}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String deleteRole(@PathVariable("id") int id) {
		RoleService.deleteRoleById(id);
		return "Role has been deleted Succesfully";
	}

	@GetMapping(params = { "pageSize", "pageNumber" })
	public Page<Role> getPages(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		return RoleService.getPage(p);
	}

	@GetMapping(params = { "pageSize", "pageNumber", "roleName" })
	public Page<Role> getPages(@RequestParam("pageSize") int pageSize, @RequestParam("pageNumber") int pageNumber,
			@RequestParam("roleName") String roleName) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		return RoleService.getPagePerName(roleName,p);
	}

}
