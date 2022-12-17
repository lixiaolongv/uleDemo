package com.apiboot.ule;

import org.minbox.framework.api.boot.autoconfigure.swagger.annotation.EnableApiBootSwagger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableApiBootSwagger
// 因为spring boot的@EnableAutoConfiguration注解引起的
//@EnableAutoConfiguration(exclude = { FreeMarkerAutoConfiguration.class })
public class UleApplication {

	public static void main(String[] args) {
		SpringApplication.run(UleApplication.class, args);
	}

	@GetMapping("/api/index")
	public String index() {
		return "this is security index";
	}
}
