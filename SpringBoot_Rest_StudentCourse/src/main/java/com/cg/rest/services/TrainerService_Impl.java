package com.cg.rest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.rest.dao.TrainerRepository;
import com.cg.rest.entity.Trainer;

@Service
public class TrainerService_Impl implements TrainerServices {

	@Autowired
	private TrainerRepository tRepo;

	@Override
	public Trainer addTrainer(Trainer trainer) {

		return tRepo.save(trainer);
	}

}
