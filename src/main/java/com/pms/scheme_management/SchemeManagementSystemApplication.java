package com.pms.scheme_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pms.scheme_management")
public class SchemeManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchemeManagementSystemApplication.class, args);
	}

}
