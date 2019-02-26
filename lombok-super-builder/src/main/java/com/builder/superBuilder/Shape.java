package com.builder.superBuilder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

// https://github.com/mplushnikov/lombok-intellij-plugin/issues/513
@EqualsAndHashCode
@SuperBuilder(toBuilder = true)
@Getter
public class Shape {

  protected double opacity;

}
