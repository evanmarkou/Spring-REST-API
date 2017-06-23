package mdx.gsd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Created by universe (E.) on 22/06/17.
 */

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final String detailDescription = "The `GSD Cloud Service` is a RESTful API that provides all the GSD teams with out of the box functionality for storing projects and experiments in one centralized Database. \n \n"
            + "Below is a list of available REST API calls for cloud storage resources.";

    @Bean
    public Docket cloudStorageApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("v1-css")
                .apiInfo(metaData())
                .select()
                .apis(RequestHandlerSelectors.basePackage("mdx.gsd.controller"))
                .paths(regex("/project.*"))
                .build();
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("REST Service")
                .description(detailDescription)
                .termsOfServiceUrl("http://springfox.io")
                .contact(new Contact(
                        "Evan Markou",
                        "https://www.linkedin.com/in/evan-markou-46a809122/",
                        "evmarkou23@gmail.com"
                ))
                .license("Apache License Version 2.0 (check Github repo)")
                .licenseUrl("https://github.com/EvanMark/Spring-REST-API")
                .version("1.0")
                .build();
    }


}
