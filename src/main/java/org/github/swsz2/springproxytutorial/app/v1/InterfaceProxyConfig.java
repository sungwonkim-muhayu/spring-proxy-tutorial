package org.github.swsz2.springproxytutorial.app.v1;

import org.github.swsz2.springproxytutorial.app.OrderController;
import org.github.swsz2.springproxytutorial.app.OrderRepository;
import org.github.swsz2.springproxytutorial.app.OrderService;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;

public class InterfaceProxyConfig {

  @Bean
  public OrderController orderController(final LogTrace logTrace) {
    return new OrderControllerProxy(new OrderControllerV1(orderService(logTrace)), logTrace);
  }

  @Bean
  public OrderService orderService(final LogTrace logTrace) {
    return new OrderServiceInterfaceProxy(new OrderServiceV1(orderRepository(logTrace)), logTrace);
  }

  @Bean
  public OrderRepository orderRepository(final LogTrace logTrace) {
    return new OrderRepositoryInterfaceProxy(new OrderRepositoryV1(), logTrace);
  }
}
