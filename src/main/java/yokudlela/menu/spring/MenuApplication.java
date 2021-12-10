package yokudlela.menu.spring;

import org.springframework.cache.annotation.EnableCaching;
import yokudlela.menu.utils.request.RequestBean;
import yokudlela.menu.utils.request.UserNameInjectInterceptor;
import yokudlela.menu.utils.validation.ValidationRestDataExceptionHandler;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.OAuthFlow;
import io.swagger.v3.oas.annotations.security.OAuthFlows;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SecurityScheme(
        bearerFormat = "JWT",
        type = SecuritySchemeType.OAUTH2,
        name = "oauth2",
        paramName = "Authorization",
        description = "KeyCloak Alteo",
        in = SecuritySchemeIn.HEADER,
        flows = @OAuthFlows(
                implicit = @OAuthFlow(authorizationUrl = "http://172.17.0.1:6080/auth/realms/yokudlela/protocol/openid-connect/auth?client_id=account&redirect_uri=http://localhost:8080/menu/swagger-ui/oauth2-redirect.html&response_type=code&scope=openid")
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
                @Server(url = "http://172.17.0.1:8080/menu", description = "local dev")},
        info = @Info(
                title = "Yokudlela Menu API",
                version = "v1",
                description = "Yokudlela Menu API for Graphical User Interface.",
                license = @License(
                        name = "LICENSENAME",
                        url = "https://www.DUMMY.URL"),
                contact = @Contact(
                        url = "https://www.DUMMY.URL",
                        name = "MY NAME", email = "MY@E.MAIL")))

@Configuration
@EnableWebMvc
@EnableAutoConfiguration
@ComponentScan(basePackages = {
        "yokudlela.menu.service",
        "yokudlela.menu.rest",
        "yokudlela.menu.utils.request",
        "yokudlela.menu.utils.logging"
})
@EnableJpaRepositories("yokudlela.menu.store")
@EntityScan("yokudlela.menu.datamodel")
@SpringBootApplication
@EnableCaching
@Import(ValidationRestDataExceptionHandler.class)
public class MenuApplication {
    public static void main(String[] args) {
        SpringApplication.run(MenuApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Autowired
            UserNameInjectInterceptor customInterceptor;

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(customInterceptor);
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**");
            }
        };
    }

    @Bean("requestScopedBean")
    @Scope(scopeName = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public RequestBean requestBean() {
        MDC.put("application", "2");
        MDC.put("host", "3");
        return new RequestBean();
    }

    @Bean("applicationContextProvider")
    public ApplicationContextProvider createApplicationContextProvider() {

        return new ApplicationContextProvider();
    }
}
