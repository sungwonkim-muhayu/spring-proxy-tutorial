package org.github.swsz2.springproxytutorial.pureproxy.concrete;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteLogic {

  public String operation() {
    log.info("called ConcreteLogic!");
    return "data";
  }
}
