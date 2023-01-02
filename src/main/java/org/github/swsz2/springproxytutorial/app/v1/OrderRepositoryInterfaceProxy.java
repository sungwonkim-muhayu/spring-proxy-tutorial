package org.github.swsz2.springproxytutorial.app.v1;

import lombok.RequiredArgsConstructor;
import org.github.swsz2.springproxytutorial.app.OrderRepository;
import org.github.swsz2.springproxytutorial.trace.TraceStatus;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;

@RequiredArgsConstructor
public class OrderRepositoryInterfaceProxy implements OrderRepository {

  private final OrderRepository target;
  private final LogTrace trace;

  @Override
  public void save(final String itemId) {
    TraceStatus status = null;
    try {
      status = trace.begin("orderRepository.save()");
      target.save(itemId);
      trace.end(status);
    } catch (final Exception exception) {
      trace.exception(status, exception);
      throw exception;
    }
  }
}
