package org.github.swsz2.springproxytutorial.app.v1;

import lombok.extern.slf4j.Slf4j;
import org.github.swsz2.springproxytutorial.trace.TraceStatus;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;
import org.springframework.util.PatternMatchUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Slf4j
public class LogTraceHandler implements InvocationHandler {

  private final Object target;
  private final LogTrace trace;
  private final String[] patterns;

  public LogTraceHandler(final Object target, final LogTrace trace) {
    this.target = target;
    this.trace = trace;
    this.patterns = new String[0];
  }

  public LogTraceHandler(final Object target, final LogTrace trace, final String[] patterns) {
    this.target = target;
    this.trace = trace;
    this.patterns = patterns;
  }

  @Override
  public Object invoke(final Object proxy, final Method method, final Object[] args)
      throws Throwable {

    final String methodName = method.getName();

    if (!PatternMatchUtils.simpleMatch(patterns, methodName)) {
      return method.invoke(target, args);
    }

    TraceStatus status = null;
    try {
      status =
          trace.begin(method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()");
      final Object result = method.invoke(target, args);
      trace.end(status);
      return result;
    } catch (final Exception exception) {
      trace.exception(status, exception);
      throw exception;
    }
  }
}
