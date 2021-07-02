package com.pfe.cigma.PFE.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.cigma.PFE.components.EmailSender;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/mail")
public class EmailController {

	@Autowired
	private EmailSender mailSender;
	
	@GetMapping("send")
	public String send(@RequestParam("subject") String subject,@RequestParam("to") String receiver,@RequestParam("text") String text) {
		mailSender.sendEmail(subject, receiver, text);
		return "Email sent succesfully";
		
	}

}
