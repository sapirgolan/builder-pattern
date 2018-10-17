package com.builder.classic;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.Test;

public class ClassicBuilderTest {

  @Test
  public void useBuilder() {
    NoBuilder builderInstance = new ClassicBuilder()
        .record(() -> "id")
        .args(Collections.singletonList("one"))
        .version(44l)
        .build();

    NoBuilder constructorInstance = new NoBuilder(Collections.singletonList("one"), 44l, () -> "id");

    assertThat(builderInstance).isEqualTo(constructorInstance);
  }
}