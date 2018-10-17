package com.builder.classic;

import java.util.Collections;
import java.util.List;

public class ClassicBuilder {

  private List<String> args = Collections.emptyList();
  private long version;
  private Record record;

  public ClassicBuilder args(List<String> args) {
    this.args = args;
    return this;
  }

  public ClassicBuilder version(long version) {
    this.version = version;
    return this;
  }

  public ClassicBuilder record(Record record) {
    this.record = record;
    return this;
  }

  public NoBuilder build() {
    return new NoBuilder(args, version, record);
  }
}