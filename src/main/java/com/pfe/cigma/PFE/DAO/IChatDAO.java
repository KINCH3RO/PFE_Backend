package com.pfe.cigma.PFE.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.pfe.cigma.PFE.model.Chat;
import com.pfe.cigma.PFE.model.User;

public interface IChatDAO extends CrudRepository<Chat,String>  {
	
	List<Chat> findAllByParticipants(User u);
	Chat findByParticipantsIn(List<User> particpants);

}
