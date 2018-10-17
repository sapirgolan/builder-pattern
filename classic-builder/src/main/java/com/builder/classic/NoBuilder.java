package com.builder.classic;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class NoBuilder {

  private List<String> args;
  private long version;
  private Record record;

  public NoBuilder(List<String> args, long version, Record record) {
    this.args = args;
    this.version = version;
    this.record = record;
  }

  public NoBuilder(List<String> args, Record record) {
    this.args = args;
    this.record = record;
    this.version = Instant.now().toEpochMilli();
  }

  public NoBuilder(Record record) {
    this(Collections.emptyList(), record);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }

    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    NoBuilder noBuilder = (NoBuilder) o;

    return new EqualsBuilder()
        .append(version, noBuilder.version)
        .append(args, noBuilder.args)
        .append(record.getId(), noBuilder.record.getId())
        .isEquals();
  }

  @Override
  public int hashCode() {
    return new HashCodeBuilder(17, 37)
        .append(args)
        .append(version)
        .append(record.getId())
        .toHashCode();
  }
}
