package org.github.swsz2.springproxytutorial.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RealComponent implements Component {

  @Override
  public String operation() {
    log.info("called real component");
    return "data";
  }
}
