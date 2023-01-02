package org.github.swsz2.springproxytutorial.commons;

import java.util.concurrent.TimeUnit;

public final class Timer {

  /**
   * 예외가 발생하지 않는 Sleep
   *
   * @param time time
   * @param timeUnit timeUnit
   */
  public static void sleepQuietly(final int time, final TimeUnit timeUnit) {
    try {
      timeUnit.sleep(time);
    } catch (final Exception ignored) {
    }
  }
}
