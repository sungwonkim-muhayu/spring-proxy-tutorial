package org.github.swsz2.springproxytutorial.trace.callback;

import org.github.swsz2.springproxytutorial.trace.TraceStatus;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;

public class TraceTemplate {

  private final LogTrace trace;

  public TraceTemplate(final LogTrace trace) {
    this.trace = trace;
  }

  public <T> T execute(final String message, final TraceCallback<T> callback) {
    TraceStatus status = null;
    try {
      status = trace.begin(message);

      // 로직 호출
      final T result = callback.call();

      trace.end(status);
      return result;
    } catch (Exception e) {
      trace.exception(status, e);
      throw e;
    }
  }
}
