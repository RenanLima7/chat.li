package com.chatly.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.chatly"))
          .paths(PathSelectors.any())
          .build()
          .apiInfo(metaInfo());        
    }
    
	@SuppressWarnings("rawtypes")
	private ApiInfo metaInfo() {
		ApiInfo apiInfo = new ApiInfo(
			"Chat.ly API REST",
			"API REST de chat.",
			"1.0",
			"Tesms of Service",
			new Contact("Renan Lima", "https://www.linkedin.com/in/renan-lima-developer/",
					"renanlima1510@gmail.com"),
			"MIT License",
			"https://www.mit/license.html", new ArrayList<VendorExtension>()
		);
		return apiInfo;
	}
}
