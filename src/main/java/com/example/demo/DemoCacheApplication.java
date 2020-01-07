package com.example.demo;

import com.example.demo.service.CalService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoCacheApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DemoCacheApplication.class, args);
		CalService calService = context.getBean(CalService.class);
		for (int i = 0; i < 10; i++) {
			calService.add(1, 2);
		}

		for (int i = 0; i < 10; i++) {
			calService.add2(1, 2);
		}

		for (int i = 0; i < 10; i++) {
			calService.add3(1, 2);
		}

		for (int i = 0; i < 10; i++) {
			calService.add4(1, i);
		}
	}

}
