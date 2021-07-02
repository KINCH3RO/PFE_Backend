package com.pfe.cigma.PFE.components;

import java.io.File;
import java.io.IOException;

import javax.activation.FileTypeMap;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Component
public class EmailSender {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String subject, String to, String text) {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(text);
		javaMailSender.send(msg);
		System.out.println("email sent to" + to);
	}

	public void sendEmailWithAttachment(String subject,String to,String text,String filename,File file) throws MessagingException, IOException {
		MimeMessage msg = javaMailSender.createMimeMessage();
		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo(to);
		helper.setSubject(subject);

		// default = text/plain
		// helper.setText("Check attachment for image!");
		// true = text/html
		helper.setText("<h1>"+text+"</h1>", true);
		helper.addAttachment(filename,file);
		
		javaMailSender.send(msg);

	}
}
