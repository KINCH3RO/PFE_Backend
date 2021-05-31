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

import com.pfe.cigma.PFE.model.DScategory;
import com.pfe.cigma.PFE.model.DSsub_category;
import com.pfe.cigma.PFE.service.IDScategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	IDScategoryService DScategoryService;

//category
	@GetMapping(path = "all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DScategory> getDScategorys() {

		return DScategoryService.getDScategorys();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DScategory getDScategory(@PathVariable("id") int id) {
   System.out.println("yes");
		return DScategoryService.getDScategoryById(id);
	}

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addDScategory(@RequestBody DScategory u) {

		System.out.println("add received");

		DScategory DScategory = DScategoryService.addDScategory(u);

		return new ResponseEntity<>(DScategory, HttpStatus.OK);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DScategory updateDScategory(@RequestBody DScategory u) {

		return DScategoryService.updateDScategory(u);
	}

	@DeleteMapping(path = "/delete/{id}")
	public String deleteDScategory(@PathVariable("id") int id) {
		DScategoryService.deleteDScategoryById(id);
		return "DScategory has been deleted Succesfully";
	}

	@GetMapping(params = { "pageSize", "pageNumber" })
	public Page<DScategory> getPages(@RequestParam("pageSize") int pageSize,
			@RequestParam("pageNumber") int pageNumber) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		return DScategoryService.getPage(p);
	}

	@GetMapping(params = { "pageSize", "pageNumber", "title" })
	public Page<DScategory> getPagesBytitle(@RequestParam("pageSize") int pageSize,
			@RequestParam("pageNumber") int pageNumber, @RequestParam("title") String title) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		return DScategoryService.getPageBytitle(title, p);
	}
	
	//sub-cat
	
	@GetMapping(path = "subcat/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DSsub_category> getDSsubcats() {

		return DScategoryService.getDSsubcategories();
	}

	@GetMapping(path = "subcat/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DSsub_category getDSsubcat(@PathVariable("id") int id) {

		return DScategoryService.getDSsubcat(id);
	}

	@PostMapping(path = "subcat/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addSubcat(@RequestBody DSsub_category u) {

		System.out.println("add received");

		DSsub_category subcat = DScategoryService.addDSsubcat(u);

		return new ResponseEntity<>(subcat, HttpStatus.OK);
	}

	@PutMapping(path = "subcat/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public DSsub_category updateDSsubcat(@RequestBody DSsub_category u) {

		return DScategoryService.updateDSsubcat(u);
	}

	@DeleteMapping(path = "subcat/delete/{id}")
	public String deleteSubcat(@PathVariable("id") int id) {
		DScategoryService.deleteDSsubcat(id);
		return "DScategory has been deleted Succesfully";
	}



	@GetMapping(path = "subcat/")
	public Page<DSsub_category> getPageOfSubcats(
			@RequestParam("pageSize") int pageSize,
			@RequestParam("pageNumber") int pageNumber,
			@RequestParam("title") String title,
			@RequestParam("catid") int id) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		return DScategoryService.getPageBytitleAndCategory(title, id, p);
	}


}
