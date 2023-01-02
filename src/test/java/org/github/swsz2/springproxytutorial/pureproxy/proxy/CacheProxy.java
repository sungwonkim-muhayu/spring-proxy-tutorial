package org.github.swsz2.springproxytutorial.pureproxy.proxy;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CacheProxy implements Subject {

  private Subject subject;
  private String cachedValue;

  public CacheProxy(final Subject subject) {
    this.subject = subject;
  }

  @Override
  public String operation() {
    log.info("called cache proxy!");
    if (cachedValue == null) {
      // 캐싱
      this.cachedValue = subject.operation();
    }
    return this.cachedValue;
  }
}
