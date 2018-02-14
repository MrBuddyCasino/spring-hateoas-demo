package de.codecentric.hateoas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SuppressWarnings({"unused"})
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  private static final String DEFAULT_REST_PACKAGE = "com.adidas.b2bis";

  @Bean
  public Docket newsApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .groupName("hateoas-demo")
        .apiInfo(apiInfo())
        .useDefaultResponseMessages(false)
        .select()
        //following line will expose only internal/service APIs
        //if Actuator endpoints have to be exposed as well - comment it out
        .apis(RequestHandlerSelectors.basePackage(DEFAULT_REST_PACKAGE))
        .paths(PathSelectors.any())
        .build();
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title("Inventory Service")
        .description("https://what.ever")
        .version("1.0-SNAPSHOT")
        .build();
  }
}
