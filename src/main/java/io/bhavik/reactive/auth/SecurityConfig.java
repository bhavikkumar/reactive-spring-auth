package io.bhavik.reactive.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.ServerAuthenticationConverter;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

  private final ServerAuthenticationConverter authenticationConverter;

  @Autowired
  public SecurityConfig(ServerAuthenticationConverter authenticationConverter) {
    this.authenticationConverter = authenticationConverter;
  }

  @Bean
  public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
    http
        .authorizeExchange()
        .anyExchange().authenticated()
        .and()
        .oauth2ResourceServer()
        .bearerTokenConverter(authenticationConverter)
        .jwt();
    return http.build();
  }

}
