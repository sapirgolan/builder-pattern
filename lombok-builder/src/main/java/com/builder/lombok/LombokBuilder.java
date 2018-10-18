package com.builder.lombok;

import java.util.List;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder(toBuilder = true)
@EqualsAndHashCode
public class LombokBuilder{

  protected List<String> args;
  protected long version;
  @EqualsAndHashCode.Exclude
  protected Record record;

  public LombokBuilder(List<String> args, long version, Record record) {
    this.args = args;
    this.version = version;
    this.record = record;
  }
}
