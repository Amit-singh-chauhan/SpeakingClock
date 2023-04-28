package com.speakingclock.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.speakingclock.Service.TimeConversionService;


@RestController
public class SystemController {
	@Autowired
	private TimeConversionService timeConversionService;
	
	@GetMapping("/current-time")
	public ResponseEntity<String> LocalSystemTimeConversion()
	{
		try {
			String response=timeConversionService.LocalSystemTimeConversion();
			return new ResponseEntity<>(response,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
				
	}

}
