package io.bhavik.reactive.auth;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloTest {

  @Autowired
  private WebTestClient webClient;


  @Test
  void testHelloWorldFailure() {
    this.webClient.get().uri("/hello?access_token=").accept(MediaType.TEXT_PLAIN).exchange().expectStatus().isUnauthorized();
  }
}
