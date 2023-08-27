package com.spring.learn.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;




@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api()
    {
        return GroupedOpenApi.builder()
        .group("publicOBS")
              .pathsToMatch("/**/**")
              .build();
    }

    @Bean
  public OpenAPI springShopOpenAPI() {
      return new OpenAPI()
              .info(new Info());  }
}
