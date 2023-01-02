package org.github.swsz2.springproxytutorial.pureproxy.concrete;

import org.junit.jupiter.api.Test;

public class ConcreteProxyTests {

  @Test
  void noProxy() {
    final ConcreteLogic logic = new ConcreteLogic();
    final ConcreteClient client = new ConcreteClient(logic);
    client.execute();
  }

  @Test
  void addProxy() {
    final ConcreteLogic logic = new ConcreteLogic();
    final TimeProxy proxy = new TimeProxy(logic);
    final ConcreteClient client = new ConcreteClient(proxy);
    client.execute();
  }
}
