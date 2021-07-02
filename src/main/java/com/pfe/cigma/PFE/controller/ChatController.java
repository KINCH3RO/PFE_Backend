package com.pfe.cigma.PFE.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
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
import com.pfe.cigma.PFE.model.Chat;
import com.pfe.cigma.PFE.model.Message;
import com.pfe.cigma.PFE.service.IChatService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/chats")
public class ChatController {

	@Autowired
	IChatService chatService;

	@Autowired
	FileUploader up;

	private SimpMessagingTemplate template;

	@Autowired
	public ChatController(SimpMessagingTemplate template) {
		this.template = template;
	}

	@PostMapping("/add")
	public Chat addchat(@RequestBody Chat o) {

		return chatService.addChat(o);

	}

	@PutMapping("update")
	public Chat updatechat(@RequestBody Chat o) {

		return chatService.updateChat(o);

	}

	@DeleteMapping("delete/{id}")
	public boolean deletechat(@PathVariable("id") String id) {
		return chatService.deleteChat(id);

	}

	@GetMapping("/{id}")
	public Chat getOne(@PathVariable("id") String id) {
		return chatService.getOne(id);
	}

	@GetMapping("/all")
	public List<Chat> getAll() {
		return chatService.findAll();
	}

	@GetMapping("findAllByUser/{id}")
	public List<Chat> findAllByUser(@PathVariable("id") int id) {
		return chatService.findAllChatByUser(id);
	}

	@PostMapping(path = "/fileUpload", produces = MediaType.TEXT_PLAIN_VALUE)
	public String uploadFile(@RequestParam(value = "file") MultipartFile file) throws IOException {

		System.out.println("requesting file");
		File f = up.uploadFile("Messaging", file);
		return f.getName();
	}

	@Transactional
	@MessageMapping("/message/{room}")
	public void participate(@DestinationVariable String room, Message message) throws Exception {

		switch (message.getAction()) {
		case "Create":
			System.out.println("Creating");
			Chat chat = chatService.getOne(room);
			chat.getMessages().add(message);
			Chat updatedChat = chatService.updateChat(chat);
			this.template.convertAndSend("/socketBroker/room/" + room,
					updatedChat.getMessages().get(updatedChat.getMessages().size() - 1));
			break;
		case "Update":
			System.out.println("updating");
		Message updatedMessage=	chatService.updateMessage(message);
		this.template.convertAndSend("/socketBroker/room/" + room,updatedMessage);
			
			break;
			
		case "Delete":
			System.out.println("deleting");
			chatService.deleteMessage(message.getId());
			this.template.convertAndSend("/socketBroker/room/" + room,message);

			break;

		}

		
	}

}
