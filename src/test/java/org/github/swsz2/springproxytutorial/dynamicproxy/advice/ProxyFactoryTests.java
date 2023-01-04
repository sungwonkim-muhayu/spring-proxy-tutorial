package org.github.swsz2.springproxytutorial.dynamicproxy.advice;

import lombok.extern.slf4j.Slf4j;
import org.github.swsz2.springproxytutorial.dynamicproxy.cglib.ConcreteRepository;
import org.github.swsz2.springproxytutorial.dynamicproxy.cglib.OrderRepository;
import org.github.swsz2.springproxytutorial.dynamicproxy.cglib.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;

@Slf4j
public class ProxyFactoryTests {

  @Test
  void proxyFactoryForInterfaceTest() {
    final Repository repository = new OrderRepository();
    final ProxyFactory proxyFactory = new ProxyFactory(repository);
    proxyFactory.addAdvice(new TimeAdvice());
    final Repository proxy = (Repository) proxyFactory.getProxy();

    log.info("repository.getClass() : " + repository.getClass());
    log.info("proxy.getClass() : " + proxy.getClass());

    proxy.save();
  }

  @Test
  void proxyFactoryForImplementationTest() {
    final ConcreteRepository repository = new ConcreteRepository();
    final ProxyFactory proxyFactory = new ProxyFactory(repository);
    proxyFactory.addAdvice(new TimeAdvice());
    final ConcreteRepository proxy = (ConcreteRepository) proxyFactory.getProxy();

    log.info("repository.getClass() : " + repository.getClass());
    log.info("proxy.getClass() : " + proxy.getClass());

    repository.call();
  }
}
