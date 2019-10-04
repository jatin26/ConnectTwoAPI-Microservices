package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoDAO demoDAO;
	
	@Override
	public DemoData save(DemoData demoData) {
		
		return demoDAO.save(demoData);
	}

	@Override
	public List<DemoData> getList() {
		
		return demoDAO.findAll();
	}

}
