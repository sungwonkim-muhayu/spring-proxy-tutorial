package org.github.swsz2.springproxytutorial.app.v2;

import org.github.swsz2.springproxytutorial.trace.TraceStatus;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;

public class OrderControllerV2Proxy extends OrderControllerV2 {

  private final OrderControllerV2 target;
  private final LogTrace trace;

  public OrderControllerV2Proxy(final OrderControllerV2 target, final LogTrace trace) {
    super(null);
    this.target = target;
    this.trace = trace;
  }

  @Override
  public String request(final String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("OrderControllerV2.request()");
      final String result = target.request(itemId);
      trace.end(status);
      return result;
    } catch (final Exception exception) {
      trace.exception(status, exception);
      throw exception;
    }
  }

  @Override
  public String noLog() {
    return null;
  }
}
