package com.pfe.cigma.PFE.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.pfe.cigma.PFE.DAO.IServiceDAO;
import com.pfe.cigma.PFE.components.FileUploader;
import com.pfe.cigma.PFE.components.FileUploader.FileType;
import com.pfe.cigma.PFE.model.DegitalService;
import com.pfe.cigma.PFE.model.IRLservice;
import com.pfe.cigma.PFE.model.Role;
import com.pfe.cigma.PFE.model.Service;
import com.pfe.cigma.PFE.service.IServiceService;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceController {
	@Autowired
	IServiceService serviceS;
	
	@Autowired
	FileUploader up;


	@GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Service> getAll() {
		return serviceS.findAll();
	}

	@PostMapping(path = "add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Service addService(@RequestBody DegitalService s) {

		return serviceS.addService(s);

	}

	@PostMapping(path = "update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Service updateService(@RequestBody DegitalService s) {

		return serviceS.addService(s);

	}

	@PostMapping(path = "addIRL", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Service addIRLService(@RequestBody IRLservice s) {

		return serviceS.addService(s);

	}

	@PostMapping(path = "updateIRL", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Service updateIRLService(@RequestBody IRLservice s) {

		return serviceS.addService(s);

	}

	@GetMapping(path = "{id}")
	public Service findOne(@PathVariable int id) {
		return serviceS.findoneByid(id);
	}
	
	@DeleteMapping(path ="delete/{id}")
	public boolean deleteone(@PathVariable int id) {
		return serviceS.deleteByid(id);
	}
	
	@GetMapping(path = "isDegital/")
	public List<Service> findAllbytype(@RequestParam("type") Boolean type,@RequestParam("title") String title){
		System.out.println(title);
		return serviceS.findAllBytype(type,title);
	}
	
	@GetMapping(path = "/allByUser/{id}")
	public List<Service> findAllByUser(@PathVariable("id") int id ) {
		return serviceS.findAllbyUser(id);
	}
	
	@GetMapping(path = "/allByUser/{id}/{type}")
	public List<Service> findAllByUserAndType(@PathVariable("id") int id, @PathVariable("type") Boolean type) {
		return serviceS.findAllbyUserAndType(id,type);
	}
	
	@PostMapping(path = "/fileUpload", produces = MediaType.TEXT_PLAIN_VALUE)
	public String uploadFile(@RequestParam(value = "file") MultipartFile file)
			throws IOException {

		
		System.out.println("requesting file");
		File f = up.uploadFile("offersAsset", file);
		return f.getName();
	}
	
	@GetMapping(params = { "pageSize", "pageNumber", "isDegital","title" })
	public Page<Service> getPages(@RequestParam("pageSize") int pageSize, 
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("title") String title,
			@RequestParam("isDegital") Boolean isDegital) {
		
		Pageable p = PageRequest.of(pageNumber, pageSize);
		return serviceS.findAllBytitleAndServiceType(title, p, isDegital);
	}
	



}
