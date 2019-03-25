package com.builder.subclassing.abstrac;

import java.util.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class Shape {

  private double opacity;

  /*Constructor for jackson serializer*/
  public Shape() {}

  public Shape(Builder<?> builder) {
    this.opacity = builder.opacity;
  }

  public double getOpacity() {
    return opacity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Shape)) {
      return false;
    }
    Shape shape = (Shape) o;
    return Double.compare(shape.opacity, opacity) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(opacity);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
        .append("opacity", opacity)
        .toString();
  }

  public abstract static class Builder<T extends Builder<T>> {

    private double opacity;

    protected abstract T getThis();

    public T opacity(double opacity) {
      this.opacity = opacity;
      return getThis();
    }

    public <U extends Shape> T toBuilder(U instance) {
      this.opacity = instance.getOpacity();
      return getThis();
    }
  }
}
