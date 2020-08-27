package com.dxctraining.compliantmgt.consumer.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.dxctraining.compliantmgt.consumer.dao.ICompliantDao;
import com.dxctraining.compliantmgt.consumer.entities.Compliant;
import com.dxctraining.compliantmgt.consumer.exceptions.InvalidArgumentException;



@Transactional
@Service
public class CompliantServiceImpl implements ICompliantService {
	@Autowired
    private ICompliantDao dao;
	@Override
    public Compliant findCompliantById(int id) {
       Compliant compliant= dao.findCompliantById(id);
        return compliant;
    }
	 @Override
	    public Compliant add(Compliant compliant) {
	        validate(compliant);
	        compliant=dao.add(compliant);
	        return compliant;
	    }
	 public void validate(Object arg){
	        if(arg==null){
	            throw new InvalidArgumentException("Argument is null change it");
	        }
	    }
	 @Override
	 public Compliant update(Compliant compliant) {
		 validate(compliant);
		 compliant=dao.update(compliant);
		 return compliant;
	 }
	 
	 @Override
	    public List<Compliant> allCompliantsByConsumer(int consumerId){
	        List<Compliant>list=dao.allCompliantsByConsumer(consumerId);
	        return list;
	    }
	 

}
