package com.group.enslibraryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class EnsLibraryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnsLibraryAppApplication.class, args);
	}

}
