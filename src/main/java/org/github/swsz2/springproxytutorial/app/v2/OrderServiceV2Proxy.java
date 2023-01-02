package org.github.swsz2.springproxytutorial.app.v2;

import org.github.swsz2.springproxytutorial.trace.TraceStatus;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;

public class OrderServiceV2Proxy extends OrderServiceV2 {

  private final OrderServiceV2 target;
  private final LogTrace trace;

  public OrderServiceV2Proxy(final OrderServiceV2 target, final LogTrace trace) {
    super(null);
    this.target = target;
    this.trace = trace;
  }

  @Override
  public void orderItem(final String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("OrderServiceV2.orderItem()");
      target.orderItem(itemId);
      trace.end(status);
    } catch (final Exception exception) {
      trace.exception(status, exception);
      throw exception;
    }
  }
}
