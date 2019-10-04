package com.example.demo;

import java.util.List;

public interface DemoService {

	DemoData save(DemoData demoData);
	
	List<DemoData> getList();
}
