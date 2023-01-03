package org.github.swsz2.springproxytutorial.dynamicproxy.reflection;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Slf4j
public class ReflectionTests {

  @Test
  void reflectionTest1() {
    final Hello target = new Hello();

    log.info("start");
    String resultA = target.callA();
    System.out.println("resultA = " + resultA);

    log.info("start");
    String resultB = target.callB();
    System.out.println("resultB = " + resultB);
  }

  @Test
  void reflectionTest2()
      throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException,
          IllegalAccessException {
    final Class helloClazz =
        Class.forName(
            "org.github.swsz2.springproxytutorial.dynamicproxy.reflection.ReflectionTests$Hello");
    final Hello hello = new Hello();
    final Method callA = helloClazz.getMethod("callA");
    dynamicCall(callA, hello);

    final Method callB = helloClazz.getMethod("callB");
    dynamicCall(callB, hello);
  }

  private void dynamicCall(final Method method, Object target)
      throws InvocationTargetException, IllegalAccessException {
    Object result = method.invoke(target);
    log.info("result = " + result);
  }

  @Slf4j
  public static class Hello {
    public String callA() {
      log.info("called a!");
      return "a";
    }

    public String callB() {
      log.info("called b!");
      return "b";
    }
  }
}
