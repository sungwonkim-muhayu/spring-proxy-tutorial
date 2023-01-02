package org.github.swsz2.springproxytutorial.trace.logtrace;

import org.github.swsz2.springproxytutorial.trace.TraceStatus;

public interface LogTrace {

  TraceStatus begin(String message);

  void end(TraceStatus status);

  void exception(TraceStatus status, Exception e);
}
