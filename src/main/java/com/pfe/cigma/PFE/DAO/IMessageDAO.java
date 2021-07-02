package com.pfe.cigma.PFE.DAO;

import org.springframework.data.repository.CrudRepository;

import com.pfe.cigma.PFE.model.Message;

public interface IMessageDAO extends CrudRepository<Message, Integer>  {

}
