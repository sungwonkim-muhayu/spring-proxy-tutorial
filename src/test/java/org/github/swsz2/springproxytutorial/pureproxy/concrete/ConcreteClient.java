package org.github.swsz2.springproxytutorial.pureproxy.concrete;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcreteClient {

  private final ConcreteLogic concreteLogic;

  public ConcreteClient(final ConcreteLogic concreteLogic) {
    this.concreteLogic = concreteLogic;
  }

  public void execute() {
    concreteLogic.operation();
  }
}
