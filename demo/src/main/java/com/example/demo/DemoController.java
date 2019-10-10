package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
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
@RefreshScope
public class DemoController {

	@Value("${service.url}")
	String url;
	
	@Autowired
	private DemoService demoService;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/save")
	public DemoData saveData(@RequestBody DemoData demoData) {
		return demoService.save(demoData);
	}

	@GetMapping("/getData")
	public List<DemoData> getData() {

		return demoService.getList();

	}

	@GetMapping("/combineAPI")
	public List<Object> combineData() {

		//**This is the hard coded so that why i create @Bean in DemoApplication.java class**
		//RestTemplate restTemplate=new RestTemplate();
		
		//**This is the hard coded URL so that's why is create the url in application.properties file**
		//String url="http://localhost:8080/employee/all";
		
		// Data data=restTemplate.getForObject(url, Data.class);
		ResponseEntity<List<Data>> claim = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Data>>() {
				});
		List<Data> list = claim.getBody();
		List<DemoData> list2 = getData();
		List<Object> combineList = new ArrayList<>();
		combineList.addAll(list);
		combineList.addAll(list2);
		return combineList;
	}

}
