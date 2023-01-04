package org.github.swsz2.springproxytutorial.dynamicproxy.advice;

import lombok.extern.slf4j.Slf4j;
import org.github.swsz2.springproxytutorial.dynamicproxy.cglib.OrderRepository;
import org.github.swsz2.springproxytutorial.dynamicproxy.cglib.Repository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;

import java.lang.reflect.Method;

@Slf4j
public class AdvisorTests {

  @Test
  void advisorTest1() {
    final Repository repository = new OrderRepository();
    final ProxyFactory proxyFactory = new ProxyFactory(repository);
    final Advisor advisor = new DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice());
    proxyFactory.addAdvisor(advisor);
    final Repository proxy = (Repository) proxyFactory.getProxy();

    proxy.save();
  }

  @Test
  @DisplayName("직접 포인트컷을 구성하는 방법")
  void advisorTest2() {
    final Repository repository = new OrderRepository();
    final ProxyFactory proxyFactory = new ProxyFactory(repository);
    final Advisor advisor = new DefaultPointcutAdvisor(new MyPointCut(), new TimeAdvice());
    proxyFactory.addAdvisor(advisor);
    final Repository proxy = (Repository) proxyFactory.getProxy();

    proxy.save();
  }

  @Test
  @DisplayName("스프링에서 제공하는 포인트컷을 사용하는 방법")
  void advisorTest3() {
    final Repository repository = new OrderRepository();
    final ProxyFactory proxyFactory = new ProxyFactory(repository);
    final NameMatchMethodPointcut nameMatchMethodPointcut = new NameMatchMethodPointcut();
    nameMatchMethodPointcut.setMappedName("save");
    final Advisor advisor = new DefaultPointcutAdvisor(nameMatchMethodPointcut, new TimeAdvice());
    proxyFactory.addAdvisor(advisor);
    final Repository proxy = (Repository) proxyFactory.getProxy();

    proxy.save();
  }

  static class MyPointCut implements Pointcut {
    @Override
    public ClassFilter getClassFilter() {
      return ClassFilter.TRUE;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
      return new MyMethodMatcher();
    }
  }

  static class MyMethodMatcher implements MethodMatcher {

    private final String matchName = "save";

    @Override
    public boolean matches(final Method method, final Class<?> targetClass) {
      log.info("포인트 컷 호출, method={}, targetClass={}", method.getName(), targetClass);
      return matchName.equals(method.getName());
    }

    @Override
    public boolean isRuntime() {
      // 해당 메소드에서 true가 반환되면 matches(Method method, Class<?> targetClass, Object... args)가 호출된다.
      return false;
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass, Object... args) {
      return false;
    }
  }
}
