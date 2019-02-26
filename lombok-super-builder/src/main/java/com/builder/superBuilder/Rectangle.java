package com.builder.superBuilder;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

// https://github.com/mplushnikov/lombok-intellij-plugin/issues/513
@EqualsAndHashCode(callSuper = true)
@SuperBuilder(toBuilder = true)
@Getter
public class Rectangle extends Shape {

  private double height;
  private double width;
  private String name;
}
