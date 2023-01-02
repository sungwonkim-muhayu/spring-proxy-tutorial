package org.github.swsz2.springproxytutorial.trace.callback;

public interface TraceCallback<T> {
  T call();
}
