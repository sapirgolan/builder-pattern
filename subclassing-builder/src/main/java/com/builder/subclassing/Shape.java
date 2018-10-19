package com.builder.subclassing;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Shape {

  protected final double opacity;

  protected abstract static class ShapeBuilder<S extends Shape, B extends ShapeBuilder<S, B>> {
    private double opacity;

    public ShapeBuilder<S, B> opacity(double opacity) {
      this.opacity = opacity;
      return getThis();
    }

    protected abstract B getThis();
    public abstract S build();

    public B fromInstance(S instance) {
      getThis()
          .opacity(instance.opacity);
      return getThis();
    }
  }

  private static class DefaultShapeBuilder extends ShapeBuilder<Shape, DefaultShapeBuilder> {
    @Override
    protected DefaultShapeBuilder getThis() {
      return this;
    }

    @Override
    public Shape build() {
      return new Shape(this);
    }
  }

  public static ShapeBuilder<?, ?> builder() {
    return new DefaultShapeBuilder();
  }

  protected Shape(ShapeBuilder<?, ?> builder) {
    this.opacity = builder.opacity;
  }

  public ShapeBuilder<?, ?> fromInstance() {
    return new DefaultShapeBuilder()
        .fromInstance(this)
        .getThis();
  }

}
