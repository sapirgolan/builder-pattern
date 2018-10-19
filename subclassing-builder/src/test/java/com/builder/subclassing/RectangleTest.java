package com.builder.subclassing;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.data.Offset;
import org.junit.Test;

public class RectangleTest {

  @Test
  public void name() {

    Rectangle built = Rectangle.builder()
        .height(22)
        .width(33)
        .name("test")
        .opacity(11)
        .build();

    Rectangle copied = built.fromInstance()
        .name("copied")
        .opacity(55)
        .build();

    assertThat(copied.getHeight()).isCloseTo(22, Offset.offset(0.0001));
    assertThat(copied.getWidth()).isCloseTo(33, Offset.offset(0.00001));
    assertThat(copied.getName()).isEqualTo("copied");
    assertThat(copied.opacity).isCloseTo(55, Offset.offset(0.00001));


    assertThat(copied).isEqualToIgnoringGivenFields(built, "name", "opacity");
  }
}