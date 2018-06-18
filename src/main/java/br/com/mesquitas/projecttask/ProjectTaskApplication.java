package br.com.mesquitas.projecttask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ProjectTaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectTaskApplication.class, args);
	}
}
