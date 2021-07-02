package com.pfe.cigma.PFE.service;

import java.util.List;

import com.pfe.cigma.PFE.model.Chat;
import com.pfe.cigma.PFE.model.Message;

public interface IChatService {
	
	Chat addChat(Chat c);
	boolean deleteChat(String id);
	Chat updateChat(Chat c);
	Chat getOne(String id);
	Message addMessage(Message m);
	Message updateMessage(Message m);
	boolean deleteMessage(int id);
	List<Chat> findAllChatByUser(int userID);
	List<Chat> findAll();

	 
	
	

}
