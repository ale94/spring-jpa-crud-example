package ar.com.ale94.spring_jpa_crud_example.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "JPA Crud Example API",
                version = "1.0",
                description = "Documentation for endpoints in JPA Crud"
        )
)
public class OpenApiConfig {

}
