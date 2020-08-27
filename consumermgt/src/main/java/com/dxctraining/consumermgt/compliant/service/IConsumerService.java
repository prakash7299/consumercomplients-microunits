package com.dxctraining.consumermgt.compliant.service;

import java.util.List;

import com.dxctraining.consumermgt.compliant.entities.Consumer;



public interface IConsumerService {
	Consumer findConsumerById(int id);

    Consumer add(Consumer consumer);
    Consumer update(Consumer consumer);

}
