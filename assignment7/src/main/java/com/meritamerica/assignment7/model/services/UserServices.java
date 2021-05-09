package com.meritamerica.assignment7.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meritamerica.assignment7.model.AccountHolder;
import com.meritamerica.assignment7.model.MyUser;

import com.meritamerica.assignment7.model.repository.AccountHolderRepository;
import com.meritamerica.assignment7.model.repository.UserRepository;

import DTO.SignupRequest;

@Service
public class UserServices {
	@Autowired
	UserRepository ahDetailsRepo;
	@Autowired
	AccountHolderRepository ahRepo;
	
	public UserServices() {}
	
	public List<MyUser> getAllDetails(){
		return ahDetailsRepo.findAll();
	}
	
	public AccountHolder getAccountHolderById(Long accid) {
		AccountHolder ah = ahRepo.findById(accid).orElse(null);
		return ah;
	}
	public MyUser getAccountHoldersContactDetailsById(Long id) {
		return ahDetailsRepo.findById(id).orElse(null);
	}
	public MyUser addAccountHoldersContactDetails(SignupRequest ahDetailDTO) {
		MyUser newDetail = new MyUser(ahDetailDTO.getUsername(), ahDetailDTO.getPassword());
		return ahDetailsRepo.save(newDetail);
	}
}
