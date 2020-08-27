package com.dxctraining.consumermgt.compliant.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dxctraining.consumermgt.compliant.dao.IConsumerDao;
import com.dxctraining.consumermgt.compliant.entities.Consumer;
import com.dxctraining.consumermgt.compliant.exceptions.InvalidArgumentException;




@Transactional
@Service
public class ConsumerServiceImpl implements IConsumerService {
	@Autowired
    private IConsumerDao dao;
	@Override
    public Consumer findConsumerById(int id) {
       Consumer consumer= dao.findConsumerById(id);
        return consumer;
    }
	 @Override
	    public Consumer add(Consumer consumer) {
	        validate(consumer);
	       consumer=dao.add(consumer);
	        return consumer;
	    }
	   public void validate(Object arg){
	        if(arg==null){
	            throw new InvalidArgumentException("Argument is null change it");
	        }
	    }
	 @Override
	 public Consumer update(Consumer consumer) {
		 validate(consumer);
		 consumer=dao.update(consumer);
		 return consumer;
		 
	 }

}
