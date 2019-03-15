package org.ssr.tech.premier.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping("/employees")
@RestController
public class EmployeeApi {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET, produces="application/JSON")
	public ResponseEntity<Map<String, Object>> searchEmployees(@PathVariable("id") Long id) {
		
		String result = restTemplate.getForObject("http://dummy.restapiexample.com/api/v1/employee/"+id, String.class);
		
		Map<String, Object> map = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();

		try {
		    //convert JSON string to Map
		   map = mapper.readValue(result, new TypeReference<HashMap<String, Object>>(){});
		} 
		catch (Exception ex) {
		     // Log exception
		}
		
		return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
	}
	
}
