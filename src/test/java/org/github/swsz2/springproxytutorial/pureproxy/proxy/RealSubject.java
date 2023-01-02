package org.github.swsz2.springproxytutorial.pureproxy.proxy;

import lombok.extern.slf4j.Slf4j;
import org.github.swsz2.springproxytutorial.commons.Timer;

import java.util.concurrent.TimeUnit;

@Slf4j
public class RealSubject implements Subject {
  @Override
  public String operation() {
    log.info("called real subject!");
    Timer.sleepQuietly(1, TimeUnit.SECONDS);
    return "data";
  }
}
