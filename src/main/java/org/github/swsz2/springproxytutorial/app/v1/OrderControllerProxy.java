package org.github.swsz2.springproxytutorial.app.v1;

import lombok.RequiredArgsConstructor;
import org.github.swsz2.springproxytutorial.app.OrderController;
import org.github.swsz2.springproxytutorial.trace.TraceStatus;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderControllerProxy implements OrderController {

  private final OrderController target;
  private final LogTrace trace;

  @Override
  public String request(final String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("orderService.request()");
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
