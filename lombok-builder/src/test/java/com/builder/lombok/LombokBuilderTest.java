package com.builder.lombok;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.Test;

public class LombokBuilderTest {

  @Test
  public void useBuilder() {
    LombokBuilder constructorInstance = new LombokBuilder(Collections.singletonList("one"), 44l, () -> "id");

    LombokBuilder lombokBuilder = LombokBuilder.builder()
        .record(() -> "id")
        .version(44l)
        .args(Collections.singletonList("one"))
        .build();

    assertThat(lombokBuilder).isEqualTo(constructorInstance);
  }

  @Test
  public void buildFromInstance() {
    LombokBuilder originalInstance = LombokBuilder.builder()
        .record(() -> "id")
        .version(44l)
        .args(Collections.singletonList("one"))
        .build();

    LombokBuilder builtFromInstance = originalInstance.toBuilder()
        .version(55l)
        .build();

    assertThat(originalInstance.version).isEqualTo(44l);
    assertThat(builtFromInstance.version).isEqualTo(55l);

    assertThat(builtFromInstance).isEqualToIgnoringGivenFields(originalInstance, "version");
  }
}