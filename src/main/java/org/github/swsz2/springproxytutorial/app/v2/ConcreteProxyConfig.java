package org.github.swsz2.springproxytutorial.app.v2;

import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConcreteProxyConfig {

  @Bean
  public OrderControllerV2 orderControllerV2(final LogTrace logTrace) {
    return new OrderControllerV2Proxy(new OrderControllerV2(orderServiceV2(logTrace)), logTrace);
  }

  @Bean
  public OrderServiceV2 orderServiceV2(final LogTrace logTrace) {
    return new OrderServiceV2Proxy(new OrderServiceV2(orderRepositoryV2(logTrace)), logTrace);
  }

  @Bean
  public OrderRepositoryV2 orderRepositoryV2(final LogTrace logTrace) {
    return new OrderRepositoryV2Proxy(new OrderRepositoryV2(), logTrace);
  }
}
