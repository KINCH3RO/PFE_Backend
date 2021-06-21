package com.pfe.cigma.PFE.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
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
import org.springframework.web.multipart.MultipartFile;

import com.pfe.cigma.PFE.components.FileUploader;
import com.pfe.cigma.PFE.model.Entreprise;
import com.pfe.cigma.PFE.model.Orders;
import com.pfe.cigma.PFE.service.IEntrepriseService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/entreprises")
public class EntrepriseController {

	@Autowired
	IEntrepriseService EntrepriseService;
	
	@Autowired
	FileUploader up;
	
	@PostMapping("/add")
	public Entreprise addEntreprise(@RequestBody Entreprise o) {

		return EntrepriseService.addEntreprise(o);

	}

	@PutMapping("update")
	public Entreprise updateEntreprise(@RequestBody Entreprise o) {

		return EntrepriseService.addEntreprise(o);

	}

	@DeleteMapping("delete/{id}")
	public boolean deleteEntreprise(@PathVariable("id") int id) {
		return EntrepriseService.DeleteEntreprise(id);

	}

	@GetMapping("/{id}")
	public Entreprise getOne(@PathVariable("id") int id) {
		return EntrepriseService.getEntrepriseById(id);
	}

	@GetMapping("/all")
	public List<Entreprise> findAll() {
		return EntrepriseService.getEntreprises();
	}
	
	
	@PostMapping(path = "/fileUpload", produces = MediaType.TEXT_PLAIN_VALUE)
	public String uploadFile(@RequestParam(value = "file") MultipartFile file)
			throws IOException {

		
		System.out.println("requesting file");
		File f = up.uploadFile("companyPic", file);
		return f.getName();
	}
	
	@GetMapping(params = { "pageSize", "pageNumber", "title", "ownerID" })
	public Page<Entreprise> getPageByTilteAndUser(
			@RequestParam("pageSize") int pageSize,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("title") String title,
			@RequestParam("ownerID") int id,
			@RequestParam("sortAsc") boolean sort ) {
		Pageable p = null;
		if(sort) {
			p = PageRequest.of(pageNumber, pageSize,Sort.by(Sort.Direction.ASC, "createdDate"));
		}else {
			p = PageRequest.of(pageNumber, pageSize,Sort.by(Sort.Direction.DESC, "createdDate"));
		}
		

		return EntrepriseService.findAllbyTitleAndOwnerid(title, id, p);

	}
	
	@GetMapping(params = { "pageSize", "pageNumber", "title" })
	public Page<Entreprise> getPageByTilteAndUser(
			@RequestParam("pageSize") int pageSize,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("title") String title,

			@RequestParam("sortAsc") boolean sort ) {
		Pageable p = null;
		if(sort) {
			p = PageRequest.of(pageNumber, pageSize,Sort.by(Sort.Direction.ASC, "createdDate"));
		}else {
			p = PageRequest.of(pageNumber, pageSize,Sort.by(Sort.Direction.DESC, "createdDate"));
		}
		

		return EntrepriseService.findAllbyTitle(title, p);

	}
}
