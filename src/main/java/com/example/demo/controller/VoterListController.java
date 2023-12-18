package com.example.demo.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.VoterList;
import com.example.demo.repository.VoterRepository;
import com.example.demo.service.VoterService;

import jakarta.websocket.server.PathParam;

@RestController
public class VoterListController {
	@Autowired
	private VoterService voterService;
	@Autowired
	private VoterRepository voterRepo;

	@PostMapping("/addvoter")
	public ResponseEntity<String> addNewVoter(@RequestBody VoterList voterList) {
		String status = voterService.createVoter(voterList);
		return new ResponseEntity<>(status, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<String> updateVoter(@RequestBody VoterList voterList) {
		Integer id = voterList.getId();
		String status = voterService.updateVoterList(voterList, id);
		return new ResponseEntity<>(status, HttpStatus.OK);
	}

	@GetMapping("/get/{id}")
	public ResponseEntity<VoterList> getById(@PathVariable("id") Integer id) {
		if (voterRepo.existsById(id)) {
			VoterList voterData = voterService.getVoterData(id);
			return new ResponseEntity<VoterList>(voterData, HttpStatus.OK);
		} else {
			return new ResponseEntity<VoterList>(HttpStatus.UNAUTHORIZED);
		}

	}

	@GetMapping("/getall")
	public ResponseEntity<List<VoterList>> getTotalVoterData() {
		List<VoterList> allvoteresData = voterService.getAllvoteresData();
		return new ResponseEntity<>(allvoteresData, HttpStatus.OK);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteVoterData(@PathVariable("id") Integer id) {
		String status = null;
		if (voterRepo.existsById(id)) {
			 status = voterService.deleteVoterRecord(id);
			return new ResponseEntity<>(status,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Id is not available",HttpStatus.ACCEPTED);
		}
		
		
			
	}
}
