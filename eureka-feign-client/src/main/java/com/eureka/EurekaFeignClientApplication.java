package com.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableFeignClients
@RestController
public class EurekaFeignClientApplication {

	@Autowired
	private GreetingClient greetingClient;
	
	public static void main(String[] args) {
		SpringApplication.run(EurekaFeignClientApplication.class, args);
	}

	@GetMapping("/get-greeting")
    public String greeting(Model model) {
		String s = greetingClient.greeting();
        model.addAttribute("greeting", s);
        return "greeting-view";
    }
}
