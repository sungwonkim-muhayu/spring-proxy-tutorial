package org.github.swsz2.springproxytutorial.dynamicproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AImplementation implements AInterface {

  @Override
  public String call() {
    log.info("called a");
    return "a";
  }
}
