package com.sony.ifbatch.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sony.ifbatch.sample.entity.SuperModelEntity;
import com.sony.ifbatch.sample.repository.SuperModelRepository;

@Service
public class DbToDbService {
	
	@Autowired
	SuperModelRepository superModelRepository;
	
	public List<SuperModelEntity> selectSuperModelAll() {
		return superModelRepository.selectSuperModelAll();
	}

}
