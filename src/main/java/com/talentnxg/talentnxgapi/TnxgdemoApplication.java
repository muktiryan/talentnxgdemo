package com.talentnxg.talentnxgapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.talentnxg"})
public class TnxgdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TnxgdemoApplication.class, args);
	}

}
