package com.cg.rest.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.rest.dto.TrainerDTO;
import com.cg.rest.entity.Trainer;
import com.cg.rest.services.TrainerServices;

@RestController
public class TrainerController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private TrainerServices tService;

	@PostMapping("/trainer")
	public ResponseEntity<TrainerDTO> createTrainer(@Valid @RequestBody TrainerDTO trainerDto) {

		// convert TrainerDTO to Trainer entity
		Trainer tobj = modelMapper.map(trainerDto, Trainer.class);
		Trainer tobj_db = tService.addTrainer(tobj);

		// convert entity to DTO
		TrainerDTO trainerResponse = modelMapper.map(tobj_db, TrainerDTO.class);

		return new ResponseEntity<TrainerDTO>(trainerResponse, HttpStatus.CREATED);
	}
}
