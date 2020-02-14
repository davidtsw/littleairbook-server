package com.david.littleairbook;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)
          .select()
          .apis(RequestHandlerSelectors.basePackage("com.david.littleairbook.web"))
          .paths(PathSelectors.any())
          .build()
          .securitySchemes(Collections.singletonList(apiKey()))
          .securityContexts(Collections.singletonList(securityContext()));
    }
	
	private ApiKey apiKey() {
        return new ApiKey("JWT Token", "Authorization", "header");
    }
	
	private List<SecurityReference> defaultAuth() {
        AuthorizationScope[] authorizationScopes = { 
        		new AuthorizationScope("global", "accessEverything") };
        return Collections.singletonList(new SecurityReference("JWT Token", authorizationScopes));
    }
	
	private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.ant("/api/**"))
                .build();
    }
}
