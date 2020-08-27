package com.dxctraining.consumermgt.compliant.dao;
import java.util.List;

import com.dxctraining.consumermgt.compliant.entities.Consumer;



public interface IConsumerDao {
	
	Consumer findConsumerById(int id);

    Consumer add(Consumer consumer);
    
    Consumer update(Consumer consumer);
 
}
