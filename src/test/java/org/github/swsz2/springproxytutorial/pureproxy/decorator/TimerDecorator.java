package org.github.swsz2.springproxytutorial.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimerDecorator implements Component {

  private final Component component;

  public TimerDecorator(final Component component) {
    this.component = component;
  }

  @Override
  public String operation() {
    log.info("called time decorator");
    final long startTime = System.currentTimeMillis();
    String result = component.operation();
    final long endTime = System.currentTimeMillis();
    final long resultTime = endTime - startTime;
    log.info("finished time decorator : {}ms", resultTime);
    return result;
  }
}
