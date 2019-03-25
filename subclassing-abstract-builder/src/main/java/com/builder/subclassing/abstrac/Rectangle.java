package com.builder.subclassing.abstrac;

import java.util.Objects;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Rectangle extends Shape {

  private double height;
  private double width;
  private String name;

  /*Constructor for jackson serializer*/
  public Rectangle() {
  }

  public Rectangle(Builder builder) {
    super(builder);
    this.height = builder.height;
    this.width = builder.width;
    this.name = builder.name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Rectangle)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Rectangle rectangle = (Rectangle) o;
    return Double.compare(rectangle.height, height) == 0 &&
        Double.compare(rectangle.width, width) == 0 &&
        Objects.equals(rectangle.name, name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), height, width, name);
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.JSON_STYLE)
        .appendSuper(super.toString())
        .append("height", height)
        .append("width", width)
        .append("name", name)
        .toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

  public String getName() {
    return name;
  }

  public static class Builder extends Shape.Builder<Builder> {

    private double height;
    private double width;
    private String name;

    public Builder height(double height) {
      this.height = height;
      return this;
    }

    public Builder width(double width) {
      this.width = width;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder toBuilder(Rectangle instance) {
      super.toBuilder(instance);
      this.height = instance.height;
      this.name = instance.name;
      this.width = instance.width;
      return this;
    }

    @Override
    protected Builder getThis() {
      return this;
    }

    public Rectangle build() {
      return new Rectangle(this);
    }
  }
}
