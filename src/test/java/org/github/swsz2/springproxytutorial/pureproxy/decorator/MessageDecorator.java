package org.github.swsz2.springproxytutorial.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MessageDecorator implements Component {
  private final Component component;

  public MessageDecorator(final Component component) {
    this.component = component;
  }

  @Override
  public String operation() {
    log.info("called message decorator");
    String result = component.operation();
    String decoResult = "*****" + result + "*****";

    log.info("before = {}, after = {}", result, decoResult);

    return decoResult;
  }
}
