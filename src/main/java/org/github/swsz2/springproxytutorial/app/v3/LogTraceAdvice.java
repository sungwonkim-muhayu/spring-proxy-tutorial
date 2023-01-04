package org.github.swsz2.springproxytutorial.app.v3;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.github.swsz2.springproxytutorial.trace.TraceStatus;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;

import java.util.Objects;

@Slf4j
public class LogTraceAdvice implements MethodInterceptor {

  private final LogTrace trace;

  public LogTraceAdvice(final LogTrace trace) {
    this.trace = trace;
  }

  @Override
  public Object invoke(final MethodInvocation invocation) throws Throwable {
    TraceStatus status = null;
    try {
      status =
          trace.begin(Objects.requireNonNull(invocation.getThis()).getClass() + "." + invocation.getMethod().getName());
      final Object result = invocation.proceed();
      trace.end(status);
      return result;
    } catch (final Exception exception) {
      trace.exception(status, exception);
      throw exception;
    }
  }
}
