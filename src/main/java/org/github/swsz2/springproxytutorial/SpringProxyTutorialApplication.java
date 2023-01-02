package org.github.swsz2.springproxytutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "org.github.swsz2.springproxytutorial.app")
public class SpringProxyTutorialApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringProxyTutorialApplication.class, args);
  }
}
