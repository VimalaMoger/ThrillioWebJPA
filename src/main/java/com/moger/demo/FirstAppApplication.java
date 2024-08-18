
package com.moger.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moger.demo.DataSupplier.MessageBean;

@SpringBootApplication		//will combine springbootconfiguration(@configuration-java configuration),enableautoconfiguration,componentscan
public class FirstAppApplication {
	
	//@Autowired
	//private MessageBean messagebean;
	
	public static void main(String[] args) {
				SpringApplication.run(FirstAppApplication.class, args);//returns applicationcontext(ioc container)
	
				
	} 
	
	//ConfigurableApplicationContext context = SpringApplication.run(YourApplication.class, args);


	
	
	/*
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/deletebook/{id}").allowedOrigins("http://localhost:4200");
			}
		};
	}*/
}
 