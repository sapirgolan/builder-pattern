package com.builder.subclassing.abstrac;

public abstract class Shape {

  protected final double opacity;

  public Shape(Builder<?> builder) {
    this.opacity = builder.opacity;
  }

  public abstract static class Builder<T extends Builder<T>> {

    private double opacity;

    protected abstract T getThis();

    public T opacity(double opacity) {
      this.opacity = opacity;
      return getThis();
    }

    public <U extends Shape> T toBuilder(U instance) {
      this.opacity = instance.opacity;
      return getThis();
    }
  }
}
