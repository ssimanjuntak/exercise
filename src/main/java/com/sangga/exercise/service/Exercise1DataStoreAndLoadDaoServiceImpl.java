package com.sangga.exercise.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangga.exercise.entity.Exercise1DataStoreAndLoadEntity;
import com.sangga.exercise.exception.DataNotFound;
import com.sangga.exercise.repo.Exercise1DataStoreAndLoadRepository;
import com.sangga.exercise.util.ConverterUtil;


@Service
public class Exercise1DataStoreAndLoadDaoServiceImpl implements Exercise1DataStoreAndLoadDaoService {
	
	@Autowired
	Exercise1DataStoreAndLoadRepository repo;
	
	@Override
	public List<HashMap<String, String>> get(long id) throws Exception {
		
		Exercise1DataStoreAndLoadEntity entity = repo.findOne(id);
		if(entity == null) throw new DataNotFound();
		
		//Load As Array of Map
		return ConverterUtil.convertStringToArrayMap(entity.getText());
	}

	@Override
	public Exercise1DataStoreAndLoadEntity save(List<HashMap<String, String>> list) {
		Exercise1DataStoreAndLoadEntity entity = new Exercise1DataStoreAndLoadEntity();
		
		//Save As String variable
		entity.setText(ConverterUtil.convertArrayMapToString(list));
		
		return repo.save(entity);
	}

}
