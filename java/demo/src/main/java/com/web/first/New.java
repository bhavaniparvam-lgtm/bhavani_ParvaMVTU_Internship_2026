package com.web.first;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class New {
	public static void main(String[] args) {
		

		
	
			
			@GetMapping({"","/","/New"})
			public String New() {
				return "New";
			}
			

	}
}
