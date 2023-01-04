package org.github.swsz2.springproxytutorial.dynamicproxy.jdkproxy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Slf4j
public class TimeInvocationHandlerTests {

  @Test
  void timeInvocationHandlerATest() {
    final AInterface target = new AImplementation();
    final InvocationHandler invocationHandler = new TimeInvocationHandler(target);
    final AInterface proxy =
        (AInterface)
            Proxy.newProxyInstance( // 프록시 생성
                AInterface.class.getClassLoader(),
                new Class[] {AInterface.class},
                invocationHandler);
    proxy.call();

    log.info("target.getClass() = " + target.getClass());
    log.info("proxy.getClass() = " + proxy.getClass());
  }

  @Test
  void timeInvocationHandlerBTest() {
    final BInterface target = new BImplementation();
    final InvocationHandler invocationHandler = new TimeInvocationHandler(target);
    final BInterface proxy =
            (BInterface)
                    Proxy.newProxyInstance( // 프록시 생성
                            BInterface.class.getClassLoader(),
                            new Class[] {BInterface.class},
                            invocationHandler);
    proxy.call();

    log.info("target.getClass() = " + target.getClass());
    log.info("proxy.getClass() = " + proxy.getClass());
  }
}
