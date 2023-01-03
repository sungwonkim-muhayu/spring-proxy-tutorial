package org.github.swsz2.springproxytutorial.dynamicproxy.cglib;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
public class TimeMethodInterceptor implements MethodInterceptor {

  private final Object target;

  public TimeMethodInterceptor(final Object target) {
    this.target = target;
  }

  @Override
  public Object intercept(
      final Object proxy, final Method method, final Object[] args, final MethodProxy methodProxy)
      throws Throwable {
    log.info("called TimeMethodInterceptor!");
    final long startTime = System.currentTimeMillis();
    final Object result = methodProxy.invoke(target, args);
    final long endTime = System.currentTimeMillis();
    final long resultTime = endTime - startTime;
    log.info("finished TimeMethodInterceptor : {}ms", resultTime);
    return result;
  }
}
