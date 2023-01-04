package org.github.swsz2.springproxytutorial.dynamicproxy.jdkproxy;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class TimeInvocationHandler implements InvocationHandler {

  private final Object target;

  public TimeInvocationHandler(final Object target) {
    this.target = target;
  }

  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args)
      throws Throwable {
    log.info("called time proxy");
    final long startTime = System.currentTimeMillis();
    final Object result = method.invoke(target, args);
    final long endTime = System.currentTimeMillis();
    final long resultTime = endTime - startTime;
    log.info("finished time proxy : {}ms", resultTime);
    return result;
  }
}
