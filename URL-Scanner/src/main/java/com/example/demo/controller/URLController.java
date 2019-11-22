package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLController {

	@PostMapping("/scan")
	public ResponseEntity<?> scanUrl(@RequestBody List<String> urls) {
		
		return null;
	}
}
