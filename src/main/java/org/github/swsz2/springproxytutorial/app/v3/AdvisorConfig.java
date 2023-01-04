package org.github.swsz2.springproxytutorial.app.v3;

import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AdvisorConfig {

  @Bean
  public OrderControllerV3 orderController(final LogTrace trace) {
    final OrderControllerV3 orderController = new OrderControllerV3(orderService(trace));
    final ProxyFactory factory = new ProxyFactory(orderController);
    factory.addAdvisor(getAdvisor(trace));

    return (OrderControllerV3) factory.getProxy();
  }

  @Bean
  public OrderServiceV3 orderService(final LogTrace trace) {
    final OrderServiceV3 orderService = new OrderServiceV3(orderRepository(trace));
    final ProxyFactory factory = new ProxyFactory(orderService);
    factory.addAdvisor(getAdvisor(trace));

    return (OrderServiceV3) factory.getProxy();
  }

  @Bean
  public OrderRepositoryV3 orderRepository(final LogTrace trace) {
    final OrderRepositoryV3 orderRepository = new OrderRepositoryV3();
    final ProxyFactory factory = new ProxyFactory(orderRepository);
    factory.addAdvisor(getAdvisor(trace));

    return (OrderRepositoryV3) factory.getProxy();
  }

  private Advisor getAdvisor(final LogTrace trace) {
    // 포인트 컷 생성
    final NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
    pointcut.setMappedNames("request*", "order*", "save*");

    // 로그 어드바이스 생성
    final LogTraceAdvice advice = new LogTraceAdvice(trace);
    return new DefaultPointcutAdvisor(pointcut, advice);
  }
}
