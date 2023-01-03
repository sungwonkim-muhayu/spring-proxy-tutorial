package org.github.swsz2.springproxytutorial.app.v1;

import org.github.swsz2.springproxytutorial.app.OrderController;
import org.github.swsz2.springproxytutorial.app.OrderRepository;
import org.github.swsz2.springproxytutorial.app.OrderService;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Proxy;

public class DynamicProxyConfig {

  @Bean
  public OrderController orderController(final LogTrace logTrace) {
    final OrderController orderController = new OrderControllerV1(orderService(logTrace));
    return (OrderController)
        Proxy.newProxyInstance(
            OrderController.class.getClassLoader(),
            new Class[] {OrderController.class},
            new LogTraceHandler(orderController, logTrace));
  }

  @Bean
  public OrderService orderService(final LogTrace logTrace) {
    final OrderService orderService = new OrderServiceV1(orderRepository(logTrace));
    return (OrderService)
        Proxy.newProxyInstance(
            OrderService.class.getClassLoader(),
            new Class[] {OrderService.class},
            new LogTraceHandler(orderService, logTrace));
  }

  @Bean
  public OrderRepository orderRepository(final LogTrace logTrace) {
    final OrderRepository orderRepository = new OrderRepositoryV1();
    return (OrderRepository)
        Proxy.newProxyInstance(
            OrderRepository.class.getClassLoader(),
            new Class[] {OrderRepository.class},
            new LogTraceHandler(orderRepository, logTrace));
  }
}
