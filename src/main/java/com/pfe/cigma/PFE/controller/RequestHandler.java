package com.pfe.cigma.PFE.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")
public class RequestHandler {

	@RequestMapping("*")
	public void test(HttpServletRequest request) {
		System.out.println("Cannot find reprsentation for this URL");
		System.out.println("Request URL : "+ request.getServerName()+":" +request.getServerPort() + request.getRequestURI());

	}
}
