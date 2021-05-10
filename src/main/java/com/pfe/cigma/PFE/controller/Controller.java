package com.pfe.cigma.PFE.controller;

import java.io.Console;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {

	@GetMapping(produces = MediaType.TEXT_HTML_VALUE)
	public String test() {
		System.out.println("yes");
		return "<h1>hhhh</h1>";
	}
}
