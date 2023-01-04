package org.github.swsz2.springproxytutorial.dynamicproxy.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.github.swsz2.springproxytutorial.dynamicproxy.cglib.OrderRepository;
import org.github.swsz2.springproxytutorial.dynamicproxy.cglib.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

@Slf4j
public class MultiAdvisorTests {

  @Test
  void multiAdvisorTest1() {
    // proxy2 -> proxy1 -> target

    final Repository repository = new OrderRepository();
    final ProxyFactory proxyFactory1 = new ProxyFactory(repository);
    final Advisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
    proxyFactory1.addAdvisor(advisor1);
    final Repository proxy1 = (Repository) proxyFactory1.getProxy();

    final ProxyFactory proxyFactory2 = new ProxyFactory(proxy1);
    final Advisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());
    proxyFactory2.addAdvisor(advisor2);
    final Repository proxy2 = (Repository) proxyFactory2.getProxy();

    proxy2.save();
  }

  @Test
  void multiAdvisorTest2() {
    final Repository repository = new OrderRepository();
    final ProxyFactory proxyFactory = new ProxyFactory(repository);
    final Advisor advisor1 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());
    final Advisor advisor2 = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());
    proxyFactory.addAdvisors(advisor1, advisor2);
    final Repository proxy = (Repository) proxyFactory.getProxy();

    proxy.save();
  }

  static class Advice1 implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
      log.info("advice 1 호출");
      return invocation.proceed();
    }
  }

  static class Advice2 implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
      log.info("advice 2 호출");
      return invocation.proceed();
    }
  }
}
