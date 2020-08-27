package com.dxctraining.compliantmgt.compliant.dao;
import java.util.List;

import com.dxctraining.compliantmgt.compliant.entities.Compliant;



public interface ICompliantDao {
	
	Compliant findCompliantById(int id);

    Compliant add(Compliant compliant);
    
    Compliant update(Compliant compliant);
    
    List<Compliant> allCompliantsByConsumer(int consumerId);
    List<Compliant> allCompliants();
 
}
