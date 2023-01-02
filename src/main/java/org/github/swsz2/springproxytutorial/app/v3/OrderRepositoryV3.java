package org.github.swsz2.springproxytutorial.app.v3;

import org.github.swsz2.springproxytutorial.commons.Timer;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class OrderRepositoryV3 {
  public void save(final String itemId) {
    if ("ex".equals(itemId)) {
      throw new IllegalStateException("예외 발생");
    }
    Timer.sleepQuietly(1, TimeUnit.SECONDS);
  }
}
