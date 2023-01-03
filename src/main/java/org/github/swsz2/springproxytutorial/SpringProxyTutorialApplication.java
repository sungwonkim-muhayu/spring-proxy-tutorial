package org.github.swsz2.springproxytutorial;

import org.github.swsz2.springproxytutorial.app.v1.DynamicProxyFilterConfig;
import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;
import org.github.swsz2.springproxytutorial.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

@Import(DynamicProxyFilterConfig.class)
@SpringBootApplication(scanBasePackages = "org.github.swsz2.springproxytutorial.app")
public class SpringProxyTutorialApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringProxyTutorialApplication.class, args);
  }

  @Bean
  public LogTrace logTrace() {
    return new ThreadLocalLogTrace();
  }
}
