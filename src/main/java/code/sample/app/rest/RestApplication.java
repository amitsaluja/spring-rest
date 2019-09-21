package code.sample.app.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc

public class RestApplication {
	static Logger logger = LoggerFactory.getLogger(RestApplication.class);
	 
	public static void main(String[] args) {
		logger.info("Starting RestApplication....");
		SpringApplication.run(RestApplication.class, args);
		
	}

}
