package com.builder.bad;

public class Shape {

  protected final double opacity;

  public Shape(double opacity) {
    this.opacity = opacity;
  }

  public static class Builder {

    protected double opacity;

    public Builder opacity(double opacity) {
      this.opacity = opacity;
      return this;
    }

    public Shape build() {
      return new Shape(opacity);
    }
  }
}
