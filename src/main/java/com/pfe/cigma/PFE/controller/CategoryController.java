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
import com.pfe.cigma.PFE.model.IRL_Category;
import com.pfe.cigma.PFE.service.ICategoryService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	ICategoryService DScategoryService;

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
		if(DScategory==null) {
			return new ResponseEntity<>("Category title  already exist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(DScategory, HttpStatus.OK);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateDScategory(@RequestBody DScategory u) {

		DScategory DScategory = DScategoryService.updateDScategory(u);
		if(DScategory==null) {
			return new ResponseEntity<>("Category title  already exist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(DScategory, HttpStatus.OK);
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

	// sub-cat/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@GetMapping(path = "subcat/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DSsub_category> getDSsubcats() {

		return DScategoryService.getDSsubcategories();
	}

	@GetMapping(path = "subcat/all/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<DSsub_category> getsubcatsByCategory(@PathVariable int id) {

		return DScategoryService.findAllByCat(id);
	}

	@GetMapping(path = "subcat/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public DSsub_category getDSsubcat(@PathVariable("id") int id) {

		return DScategoryService.getDSsubcat(id);
	}

	@PostMapping(path = "subcat/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> addSubcat(@RequestBody DSsub_category u) {

		System.out.println("add received");

		DSsub_category subcat = DScategoryService.addDSsubcat(u);
		if(subcat==null) {
			return new ResponseEntity<>("Category title  already exist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(subcat, HttpStatus.OK);
	}

	@PutMapping(path = "subcat/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateDSsubcat(@RequestBody DSsub_category u) {


		DSsub_category subcat = DScategoryService.updateDSsubcat(u);
		if(subcat==null) {
			return new ResponseEntity<>("Category title  already exist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(subcat, HttpStatus.OK);
	}

	@DeleteMapping(path = "subcat/delete/{id}")
	public String deleteSubcat(@PathVariable("id") int id) {
		DScategoryService.deleteDSsubcat(id);
		return "DScategory has been deleted Succesfully";
	}

	@GetMapping(path = "subcat/")
	public Page<DSsub_category> getPageOfSubcats(@RequestParam("pageSize") int pageSize,
			@RequestParam("pageNumber") int pageNumber, @RequestParam("title") String title,
			@RequestParam("catid") int id) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		return DScategoryService.getPageBytitleAndCategory(title, id, p);
	}
	
	
	// IRL-cat/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		@GetMapping(path = "irlCat/all", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<IRL_Category> getIRLcats() {

			return DScategoryService.getIRL_Categories();
		}

		

		@GetMapping(path = "irlCat/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public IRL_Category getIRLcat(@PathVariable("id") int id) {

			return DScategoryService.getIRL_Category(id);
		}

		@PostMapping(path = "irlCat/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> addIRLcat(@RequestBody IRL_Category u) {

			System.out.println("add received");

			IRL_Category irlCat = DScategoryService.addIRL_category(u);
			if(irlCat==null) {
				return new ResponseEntity<>("Category title  already exist",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(irlCat, HttpStatus.OK);
		}

		@PutMapping(path = "irlCat/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<?> updateIRLcat(@RequestBody IRL_Category u) {

			IRL_Category irlCat = DScategoryService.updateIRL_category(u);
			if(irlCat==null) {
				return new ResponseEntity<>("Category title  already exist",HttpStatus.INTERNAL_SERVER_ERROR);
			}
			return new ResponseEntity<>(irlCat, HttpStatus.OK);
		}

		
		@DeleteMapping(path = "irlCat/delete/{id}")
		public String deleteIRLcat(@PathVariable("id") int id) {
			DScategoryService.deleteIRL_Category(id);
			return "DScategory has been deleted Succesfully";
		}
		

		@GetMapping(path = "irlCat/")
		public Page<IRL_Category> getIRLpagebytitle(@RequestParam("pageSize") int pageSize,
				@RequestParam("pageNumber") int pageNumber, @RequestParam("title") String title) {
			Pageable p = PageRequest.of(pageNumber, pageSize);
			return DScategoryService.getIRL_page_Bytitle(title, p);
		}

}
