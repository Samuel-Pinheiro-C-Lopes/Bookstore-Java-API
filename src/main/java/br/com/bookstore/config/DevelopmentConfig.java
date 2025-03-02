package br.com.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.bookstore.services.DBService;

@Configuration
@Profile("development")
public class DevelopmentConfig implements WebMvcConfigurer{
	
	@Autowired
	private DBService db;
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
		.allowedOrigins("http://localhost:4200/")
		.allowedMethods("GET", "POST", "PUT", "DELETE")
		.allowedHeaders("*");
	}
	
    @Bean
    void initialize() {
    	this.db.initializeDataBase();
	}
}
