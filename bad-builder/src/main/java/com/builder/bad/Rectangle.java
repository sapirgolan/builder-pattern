package com.builder.bad;

public class Rectangle extends Shape {

  private final double height;
  private final double width;
  private final String name;

  public Rectangle(double opacity, double height, double width, String name) {
    super(opacity);
    this.height = height;
    this.width = width;
    this.name = name;
  }

  public Rectangle(double opacity, double height, double width) {
    this(opacity, height, width, "");
  }

  public static class Builder extends Shape.Builder {

    private double height;
    private double width;
    private String name;

    public Builder opacity(double opacity) {
      this.opacity = opacity;
      return this;
    }

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

    public Rectangle build() {
      return new Rectangle(opacity, height, width, name);
    }
  }
}
