package org.github.swsz2.springproxytutorial.dynamicproxy.jdkproxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BImplementation implements BInterface {

  @Override
  public String call() {
    log.info("called b");
    return "b";
  }
}
