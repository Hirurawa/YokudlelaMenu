package yokudlela.menu.spring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SecurityScheme(
        bearerFormat = "JWT",
        type = SecuritySchemeType.OAUTH2,
        name = "oauth2",
        paramName = "Authorization",
        description = "KeyCloak Alteo",
        in = SecuritySchemeIn.HEADER,
        flows = @OAuthFlows(
                implicit = @OAuthFlow(authorizationUrl = "http://172.17.0.1:6080/auth/realms/yokudlela/protocol/openid-connect/auth?client_id=account&redirect_uri=http://172.17.0.1:8080/menu/swagger-ui/oauth2-redirect.html&response_type=code&scope=openid")
        )
)

@SecurityScheme(
        bearerFormat = "JWT",
        type = SecuritySchemeType.APIKEY,
        name = "apikey",
        paramName = "Authorization",
        description = "KeyCloak Alteo",
        in = SecuritySchemeIn.HEADER,
        openIdConnectUrl = "http://172.17.0.1:6080/auth/realms/yokudlela/.well-known/openid-configuration"
)


@SecurityScheme(
        type = SecuritySchemeType.OPENIDCONNECT,
        name = "openid",
        description = "KeyCloak Alteo",
        openIdConnectUrl = "http://172.17.0.1:6080/auth/realms/yokudlela/.well-known/openid-configuration"
)

@OpenAPIDefinition(
        servers = {
                @Server(url = "http://172.17.0.1:8080/menu", description = "local dev"),
                @Server(url = "https://www.yokudlela.hu:1980//menu", description = "test") },
        security ={
                @SecurityRequirement(name = "apikey", scopes ={"menu"} ),
                @SecurityRequirement(name = "openid", scopes ={"menu"} )
        },

        info = @Info(
                title = "Yokudlela Menu API",
                version = "v1",
                description = "description = \"Yokudlela Menu API for Graphical User Interface .",
                license = @License(
                        name = "Custom 4D Soft",
                        url = "https://www.4dsoft.hu"),
                contact = @Contact(
                        url = "https://www.DUMMYURL",
                        name = "MY NAME", email = "MY@E.MAIL")))

@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(basePackages = "yokudlela.menu")
@SpringBootApplication
public class MenuApplication {
    public static void main(String[] args) {
        SpringApplication.run(MenuApplication.class, args);
    }
/*
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {


            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }*/
}
