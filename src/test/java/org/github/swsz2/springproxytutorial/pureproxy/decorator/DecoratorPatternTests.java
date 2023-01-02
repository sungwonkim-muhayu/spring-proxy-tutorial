package org.github.swsz2.springproxytutorial.pureproxy.decorator;

import org.junit.jupiter.api.Test;

public class DecoratorPatternTests {

  @Test
  void noDecorator() {
    final Component component = new RealComponent();
    final DecoratorPatternClient client = new DecoratorPatternClient(component);
    client.execute();
  }

  @Test
  void messageDecoratorTest() {
    final Component component = new RealComponent();
    final MessageDecorator decorator = new MessageDecorator(component);
    final DecoratorPatternClient client = new DecoratorPatternClient(decorator);
    client.execute();
  }

  @Test
  void timerDecoratorAndMessageDecoratorTest() {
    final Component component = new RealComponent();
    final MessageDecorator messageDecorator = new MessageDecorator(component);
    final TimerDecorator timerDecorator = new TimerDecorator(messageDecorator);
    final DecoratorPatternClient client = new DecoratorPatternClient(timerDecorator);
    client.execute();
  }
}
