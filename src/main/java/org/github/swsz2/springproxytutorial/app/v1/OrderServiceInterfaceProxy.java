package org.github.swsz2.springproxytutorial.app.v1;

import lombok.RequiredArgsConstructor;
import org.github.swsz2.springproxytutorial.app.OrderService;
import org.github.swsz2.springproxytutorial.trace.TraceStatus;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderServiceInterfaceProxy implements OrderService {

  private final OrderService target;
  private final LogTrace trace;

  @Override
  public void orderItem(final String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("OrderService.orderItem()");
      target.orderItem(itemId);
      trace.end(status);
    } catch (final Exception exception) {
      trace.exception(status, exception);
      throw exception;
    }
  }
}
