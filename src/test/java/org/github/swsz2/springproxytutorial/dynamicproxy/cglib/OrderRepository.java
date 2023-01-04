package org.github.swsz2.springproxytutorial.dynamicproxy.cglib;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OrderRepository implements Repository {
  @Override
  public void save() {
    log.info("called save!");
  }

  @Override
  public void find() {
    log.info("called find!");
  }
}
