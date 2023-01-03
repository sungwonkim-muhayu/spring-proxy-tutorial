package org.github.swsz2.springproxytutorial.dynamicproxy.cglib;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteRepository {
  public void call() {
    log.info("called call!");
  }
}
