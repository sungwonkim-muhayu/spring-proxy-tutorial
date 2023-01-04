package org.github.swsz2.springproxytutorial.dynamicproxy.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {
  @Override
  public Object invoke(final MethodInvocation invocation) throws Throwable {
    log.info("called TimeMethodInterceptor!");
    final long startTime = System.currentTimeMillis();
    // MethodInvocation 내부에 target, method 등의 기존 프록시에 사용하던 정보가 존재함
    final Object result = invocation.proceed();
    final long endTime = System.currentTimeMillis();
    final long resultTime = endTime - startTime;
    log.info("finished TimeMethodInterceptor : {}ms", resultTime);
    return result;
  }
}
