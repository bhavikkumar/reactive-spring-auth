package io.bhavik.reactive.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public Mono<String> getWorld() {
    return Mono.justOrEmpty("Hello World");
  }
}
