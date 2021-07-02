package com.pfe.cigma.PFE.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pfe.cigma.PFE.DAO.IChatDAO;
import com.pfe.cigma.PFE.DAO.IMessageDAO;
import com.pfe.cigma.PFE.DAO.IUserDAO;
import com.pfe.cigma.PFE.components.RandomStringGenerator;
import com.pfe.cigma.PFE.model.Chat;
import com.pfe.cigma.PFE.model.Message;
import com.pfe.cigma.PFE.model.User;

@Service
@Transactional
public class ChatServiceImpl implements IChatService  {
	
	@Autowired
	IChatDAO chatDAO;
	
	@Autowired
	IMessageDAO messageDAO;
	
	@Autowired 
	IUserDAO userDAO;
	
	@Override
	public Chat addChat(Chat c) {
		// TODO Auto-generated method stub
		Chat chat = chatDAO.findByParticipantsIn(c.getParticipants());
		if(chat!=null) {
			return chat;
		}
	
				
		
		String id= RandomStringGenerator.generateString();
		while(!chatDAO.findById(id).isEmpty()) {
			id= RandomStringGenerator.generateString();
		};
		c.setChannel_Id(id);
		
		return chatDAO.save(c);
	}

	@Override
	public boolean deleteChat(String id) {
		// TODO Auto-generated method stub
		 chatDAO.deleteById(id);
		 return true;
	}

	@Override
	public Chat updateChat(Chat c) {
		// TODO Auto-generated method stub
		return chatDAO.save(c);
	}

	@Override
	public Chat getOne(String id) {
		// TODO Auto-generated method stub
		return chatDAO.findById(id).get();
	}

	@Override
	public Message addMessage(Message m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message updateMessage(Message m) {
		// TODO Auto-generated method stub
		return messageDAO.save(m);
	}

	@Override
	public boolean deleteMessage(int id) {
		// TODO Auto-generated method stub
		messageDAO.deleteById(id);;
		return true;
	}

	@Override
	public List<Chat> findAllChatByUser(int userID) {
		// TODO Auto-generated method stub
		Optional<User> user = userDAO.findById(userID); 
		if(user.isEmpty()) {
			return null;
		}
		
		return chatDAO.findAllByParticipants(user.get());
	}

	@Override
	public List<Chat> findAll() {
		// TODO Auto-generated method stub
		return (List<Chat>) chatDAO.findAll();
	}

}
