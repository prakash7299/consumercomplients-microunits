package com.dxctraining.compliantmgt.consumer.service;

import java.util.List;

import com.dxctraining.compliantmgt.consumer.entities.Compliant;


public interface ICompliantService {
	Compliant findCompliantById(int id);

    Compliant add(Compliant compliant);
    
    Compliant update(Compliant compliant);
    
    List<Compliant> allCompliantsByConsumer(int consumerId);

}
