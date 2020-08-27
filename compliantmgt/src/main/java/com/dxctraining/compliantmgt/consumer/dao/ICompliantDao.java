package com.dxctraining.compliantmgt.consumer.dao;
import java.util.List;

import com.dxctraining.compliantmgt.consumer.entities.Compliant;


public interface ICompliantDao {
	
	Compliant findCompliantById(int id);

    Compliant add(Compliant compliant);
    
    Compliant update(Compliant compliant);
 
}
