package com.dxctraining.consumermgt.consumer.service;

import java.util.List;

import com.dxctraining.consumermgt.consumer.entities.Consumer;

public interface IConsumerService {
	Consumer findConsumerById(int id);

    Consumer add(Consumer consumer);
    
    Consumer update(Consumer consumer);

}
