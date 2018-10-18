package com.builder.subclassing.abstrac;

public class Rectangle extends Shape {

  private final double height;
  private final double width;
  private final String name;

  public Rectangle (Builder builder) {
    super(builder);
    this.height = builder.height;
    this.width = builder.width;
    this.name = builder.name;
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
