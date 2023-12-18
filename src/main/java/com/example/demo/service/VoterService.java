package com.example.demo.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.VoterList;
@Service
public interface VoterService {
       
	public String createVoter(VoterList voterList);
	public VoterList getVoterData(Integer id);
	public  List<VoterList>   getAllvoteresData();
	public  String updateVoterList( VoterList voterList, Integer id);
	public String deleteVoterRecord(Integer id);
	
}
