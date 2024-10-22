package api.service.payment.configuration;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi apiPayment() {
        return GroupedOpenApi.builder()
                .group("api-payment")
                .pathsToMatch("/api/payment/**")
                .build();
    }
}
