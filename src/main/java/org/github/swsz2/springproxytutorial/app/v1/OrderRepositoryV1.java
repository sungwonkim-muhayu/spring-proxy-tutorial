package org.github.swsz2.springproxytutorial.app.v1;

import org.github.swsz2.springproxytutorial.app.OrderRepository;
import org.github.swsz2.springproxytutorial.commons.Timer;

import java.util.concurrent.TimeUnit;

public class OrderRepositoryV1 implements OrderRepository {
  @Override
  public void save(final String itemId) {
    if ("ex".equals(itemId)) {
      throw new IllegalStateException("예외 발생");
    }
    Timer.sleepQuietly(1, TimeUnit.SECONDS);
  }
}
