package org.github.swsz2.springproxytutorial.app.v2;

import lombok.extern.slf4j.Slf4j;
import org.github.swsz2.springproxytutorial.trace.TraceStatus;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;

@Slf4j
public class OrderRepositoryV2Proxy extends OrderRepositoryV2 {
  private final OrderRepositoryV2 target;
  private final LogTrace trace;

  public OrderRepositoryV2Proxy(final OrderRepositoryV2 target, final LogTrace trace) {
    this.target = target;
    this.trace = trace;
  }

  @Override
  public void save(final String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("OrderRepositoryV2.save()");
      target.save(itemId);
      trace.end(status);
    } catch (final Exception exception) {
      trace.exception(status, exception);
      throw exception;
    }
  }
}
