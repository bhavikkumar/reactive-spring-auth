package io.bhavik.reactive.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.server.resource.web.server.ServerBearerTokenAuthenticationConverter;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;

@Configuration
public class HelloConfiguration {

  @Bean
  ServerAuthenticationConverter authenticationConverter() {
    ServerBearerTokenAuthenticationConverter authenticationConverter = new ServerBearerTokenAuthenticationConverter();
    authenticationConverter.setAllowUriQueryParameter(true);
    return authenticationConverter;
  }
}
