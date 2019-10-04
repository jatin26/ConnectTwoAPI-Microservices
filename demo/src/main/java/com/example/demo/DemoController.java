package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("demo")
public class DemoController {

	@Autowired
	private DemoService demoService;

	@PostMapping("/save")
	public DemoData saveData(@RequestBody DemoData demoData) {
		return demoService.save(demoData);
	}

	@GetMapping("/getData")
	public List<DemoData> getData() {

		return demoService.getList();

	}

	@GetMapping("/combineAPI")
	public List combineData() {
		RestTemplate restTemplate = new RestTemplate();
		String url = "http://localhost:8080/employee/all";
		// Data data=restTemplate.getForObject(url, Data.class);
		ResponseEntity<List<Data>> claim = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Data>>() {
				});
		List<Data> list = claim.getBody();
		List<DemoData> list2 = getData();
		List combineList = new ArrayList();
		combineList.addAll(list);
		combineList.addAll(list2);
		return combineList;
	}

}
