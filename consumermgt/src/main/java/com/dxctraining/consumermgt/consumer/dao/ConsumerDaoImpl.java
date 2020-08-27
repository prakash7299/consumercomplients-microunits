package com.dxctraining.consumermgt.consumer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.consumermgt.consumer.entities.Consumer;
import com.dxctraining.consumermgt.consumer.exceptions.ConsumerNotFoundException;


@Repository
public class ConsumerDaoImpl implements IConsumerDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	 @Override
	    public Consumer findConsumerById(int id) {
	        Consumer consumer=entityManager.find(Consumer.class,id);
	        if(consumer==null){
	            throw new ConsumerNotFoundException("consumer not found for id="+id);
	        }
	        return consumer;
	    }
	 @Override
	    public Consumer add(Consumer consumer) {
	        entityManager.persist(consumer);
	        return consumer;
	    }
	 @Override
	 public Consumer update(Consumer consumer) {
		 entityManager.merge(consumer);
		 return consumer;
	 }
	
}
