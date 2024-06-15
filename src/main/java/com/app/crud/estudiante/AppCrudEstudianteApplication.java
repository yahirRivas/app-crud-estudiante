package com.app.crud.estudiante;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import javax.servlet.ServletContext;
import java.util.Collections;

@SpringBootApplication
public class AppCrudEstudianteApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppCrudEstudianteApplication.class, args);
	}
	
	@Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

    @Bean
    public OpenAPI openAPI(ServletContext servletContext) {
        Server server = new Server();
        server.setUrl(servletContext.getContextPath());

        return new OpenAPI().info(new Info().title("App CRUD - Creación de Estudiante API")
                        .version("1.0")
                        .description("OpenAPI 3.")
                        .termsOfService("http://swagger.io/terms/")
                        .license(new License().name("Apache 2.0")
                                .url("http://springdoc.org")))
                .servers(Collections.singletonList(server));
    }

}
