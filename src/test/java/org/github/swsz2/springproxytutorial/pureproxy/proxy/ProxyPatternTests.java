package org.github.swsz2.springproxytutorial.pureproxy.proxy;

import org.junit.jupiter.api.Test;

public class ProxyPatternTests {

  /** 프록시를 사용하지 않고 직접 호출 */
  @Test
  void noProxyTest() {
    final Subject subject = new RealSubject();
    final ProxyPatternClient client = new ProxyPatternClient(subject);

    // 캐싱 기능 구현 후 비교를 위해 3회 호출
    client.execute();
    client.execute();
    client.execute();
  }

  /** 프록시를 사용해 간접 호출 */
  @Test
  void cacheProxyTest() {
    final Subject subject = new RealSubject();
    final CacheProxy proxy = new CacheProxy(subject);
    final ProxyPatternClient client = new ProxyPatternClient(proxy);

    client.execute(); // 캐시된 데이터가 없기 때문에 1초 소요
    client.execute(); // 캐시된 데이터를 참조하기 때문에 즉시 반환
    client.execute(); // 캐시된 데이터를 참조하기 때문에 즉시 반환
  }
}
