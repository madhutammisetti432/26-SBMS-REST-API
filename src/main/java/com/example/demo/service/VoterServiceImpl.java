package com.example.demo.service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VoterList;
import com.example.demo.repository.VoterRepository;

@Service
public class VoterServiceImpl implements VoterService {
	@Autowired
	private VoterRepository voterRepo;

	@Override
	public String createVoter(VoterList voterList) {
		Integer id = voterList.getId();
		voterRepo.save(voterList);

		return "Voter Details Registred Sucessfully";

	}

	@Override
	public VoterList getVoterData(Integer id) {
		Optional<VoterList> voterObj = voterRepo.findById(id);
		if (voterObj.isPresent());
			return voterObj.get();
		

	}

	@Override
	public List<VoterList> getAllvoteresData() {
		List<VoterList> voterData = voterRepo.findAll();
		return voterData;
	}

	@Override
	public String deleteVoterRecord(Integer id) {
		Optional<VoterList> findById = voterRepo.findById(id);
		if (findById.isPresent())
			voterRepo.deleteById(id);
		return "Deleted voter sucessfully";

	}

	@Override
	public String updateVoterList(VoterList voterList, Integer id) {
		Integer id1 = null;
		/*
		 * Integer id = voterList.getId(); System.out.println(id); //VoterList save =
		 * voterRepo.save(voterList); if (id != null) { voterRepo.save(voterList);
		 * return "Voter Details Updated Sucessfully"; } else { return "id Not Found"; }
		 */
		Optional<VoterList> findById = voterRepo.findById(id);
		if (findById.isPresent()) {
			id1 = voterList.getId();
			System.out.println(id1);
			voterRepo.save(voterList);
			return "Voter Details Updated Sucessfully";
		} else {
			return "id Not Found";
		}

	}

}
