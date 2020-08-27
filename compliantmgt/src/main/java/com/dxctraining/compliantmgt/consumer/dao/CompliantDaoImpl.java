package com.dxctraining.compliantmgt.consumer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.compliantmgt.consumer.entities.Compliant;
import com.dxctraining.compliantmgt.consumer.exceptions.CompliantNotFoundException;


@Repository
public class CompliantDaoImpl implements ICompliantDao {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	 @Override
	    public Compliant findCompliantById(int id) {
	        Compliant compliant=entityManager.find(Compliant.class,id);
	        if(compliant==null){
	            throw new CompliantNotFoundException("compliant not found for id="+id);
	        }
	        return compliant;
	    }
	 @Override
	    public Compliant add(Compliant compliant) {
	        entityManager.persist(compliant);
	        return compliant;
	    }
	 @Override
	 public Compliant update(Compliant compliant) {
		 entityManager.merge(compliant);
		 return compliant;
	 }
	 
	 @Override
	    public List<Compliant> allCompliantsByConsumer(int consumerId) {
	        String jpaql="from Compliants where consumerId=:consumer";
	        TypedQuery<Compliant>query=entityManager.createQuery(jpaql,Compliant.class);
	        query.setParameter("consumer",consumerId);
	        List<Compliant>compliantList=query.getResultList();
	        return compliantList;
	    }
	 
}
