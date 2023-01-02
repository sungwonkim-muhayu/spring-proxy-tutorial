package org.github.swsz2.springproxytutorial.config;

import org.github.swsz2.springproxytutorial.trace.logtrace.LogTrace;
import org.github.swsz2.springproxytutorial.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TraceConfig {

  @Bean
  public LogTrace trace() {
    return new ThreadLocalLogTrace();
  }
}
