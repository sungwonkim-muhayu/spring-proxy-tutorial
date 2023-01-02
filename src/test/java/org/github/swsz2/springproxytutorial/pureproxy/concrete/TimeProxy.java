package org.github.swsz2.springproxytutorial.pureproxy.concrete;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeProxy extends ConcreteLogic {

  private final ConcreteLogic target;

  public TimeProxy(final ConcreteLogic target) {
    this.target = target;
  }

  @Override
  public String operation() {
    log.info("called TimeProxy!");
    final long startTime = System.currentTimeMillis();
    final String result = target.operation();
    final long endTime = System.currentTimeMillis();
    final long resultTime = endTime - startTime;
    log.info("finished TimeProxy : {}ms", resultTime);
    return result;
  }
}
