package com.speakingclock.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.speakingclock.Service.TimeConversionService;

@RestController
public class UserinputController {
	@Autowired
	private TimeConversionService timeConversionService;

	@GetMapping("/user-input")
	public ResponseEntity<String> UserInputTimeConversion(@RequestParam String time) {
		try {
			String response = timeConversionService.UserInputTimeConversion(time);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

}
