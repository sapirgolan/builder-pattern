package com.builder.superBuilder;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.data.Offset;
import org.junit.Test;

public class ShapeTest {

  @Test
  public void runBuilder() {
    Shape builtShape = Shape.builder()
        .opacity(44)
        .build();

    Shape copiedShape = builtShape.toBuilder().build();

    assertThat(builtShape).isEqualTo(copiedShape);

    Shape newShape = builtShape.toBuilder()
        .opacity(22)
        .build();

    assertThat(copiedShape.opacity).isCloseTo(44, Offset.offset(0.001));
    assertThat(newShape).isNotEqualTo(builtShape);
  }
}