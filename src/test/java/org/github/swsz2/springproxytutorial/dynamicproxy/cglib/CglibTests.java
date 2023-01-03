package org.github.swsz2.springproxytutorial.dynamicproxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.cglib.proxy.Enhancer;

@Slf4j
public class CglibTests {

  @Test
  void cglibTest() {
    final ConcreteRepository target = new ConcreteRepository();
    final Enhancer enhancer = new Enhancer();
    enhancer.setSuperclass(Repository.class);
    enhancer.setCallback(new TimeMethodInterceptor(target));
    final Repository proxy = (Repository) enhancer.create();
    log.info("target.getClass() : " + target.getClass());
    log.info("proxy.getClass() : " + proxy.getClass());
  }
}
