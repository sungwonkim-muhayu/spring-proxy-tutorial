package org.github.swsz2.springproxytutorial.app.v1;

import org.github.swsz2.springproxytutorial.app.OrderController;
import org.github.swsz2.springproxytutorial.app.OrderRepository;
import org.github.swsz2.springproxytutorial.app.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigV1 {

  @Bean
  public OrderController orderControllerV1() {
    return new OrderControllerV1(orderServiceV1());
  }

  @Bean
  public OrderService orderServiceV1() {
    return new OrderServiceV1(orderRepositoryV1());
  }

  @Bean
  public OrderRepository orderRepositoryV1() {
    return new OrderRepositoryV1();
  }
}
