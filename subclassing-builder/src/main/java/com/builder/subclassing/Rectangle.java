package com.builder.subclassing;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class Rectangle extends Shape {

  private final double height;
  private final double width;
  private final String name;

  public double getHeight() {
    return height;
  }

  public double getWidth() {
    return width;
  }

  public String getName() {
    return name;
  }

  protected Rectangle(DefaultRectangleBuilder defaultRectangleBuilder) {
    super(defaultRectangleBuilder);
    this.height = defaultRectangleBuilder.height;
    this.width = defaultRectangleBuilder.width;
    this.name = defaultRectangleBuilder.name;
  }

  @Override
  public RectangleBuilder<?, ?> fromInstance() {
    return new DefaultRectangleBuilder()
        .fromInstance(this)
        .getThis();
  }

  public static RectangleBuilder<?, ?> builder() {
    return new DefaultRectangleBuilder();
  }

  protected abstract static class RectangleBuilder<R extends Rectangle, B extends RectangleBuilder<R, B>> extends ShapeBuilder<R, B> {

    protected double height;
    protected double width;
    protected String name;

    public RectangleBuilder<R, B> height(double height) {
      this.height = height;
      return getThis();
    }

    public RectangleBuilder<R, B> width(double width) {
      this.width = width;
      return getThis();
    }

    public RectangleBuilder<R, B> name(String name) {
      this.name = name;
      return getThis();
    }

    @Override
    public B fromInstance(R instance) {
      return super.fromInstance(instance)
          .height(instance.getHeight())
          .width(instance.getWidth())
          .name(instance.getName())
          .getThis();
    }
  }

  private static class DefaultRectangleBuilder extends RectangleBuilder<Rectangle, DefaultRectangleBuilder> {

    @Override
    protected DefaultRectangleBuilder getThis() {
      return this;
    }

    @Override
    public Rectangle build() {
      return new Rectangle(this);
    }
  }
}
