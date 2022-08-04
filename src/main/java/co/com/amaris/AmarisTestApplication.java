package co.com.amaris;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootApplication
public class AmarisTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmarisTestApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
			}
		};
	}
	

	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
	
	@Bean
	public ObjectWriter objectWriter() {
	return	new ObjectMapper().writer().withDefaultPrettyPrinter();
		
	}

}
