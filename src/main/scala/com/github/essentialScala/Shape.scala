package com.github.essentialScala

sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
  def color: Color
}

sealed trait Rectangular extends Shape {
  def width: Double
  def height: Double
  val sides = 4
  override val perimeter = 2 * width + 2 * height
  override val area = width * height
}

case class Circle(radius: Double, color: Color) extends Shape {
  val sides = 1
  val perimeter = 2 * math.Pi * radius
  val area = math.Pi * radius * radius
}

case class Rectangle(width: Double, height: Double, color: Color)
    extends Rectangular

case class Square(size: Double, color: Color) extends Rectangular {
  val width = size
  val height = size
}

object Draw {

  def apply(shape: Shape): String = shape match {
    case Rectangle(width, height, color) =>
      s"A ${Draw(color)} Rectangle of width ${width}cm and height ${height}cm"
    case Square(size, color) =>
      s"A ${Draw(color)} Square of size ${size}cm"
    case Circle(radius, color) =>
      s"A ${Draw(color)} Circle of radius ${radius}cm"
  }

  def apply(color: Color): String = color match {
    case Red   => "red"
    case Green => "green"
    case Blue  => "blue"
    case color => if (color.isLight) "light" else "dark"
  }

  def main(args: Array[String]): Unit = {
    println(Draw(Circle(10, Green)))
    println(Draw(Rectangle(10, 5, Red)))
    println(Draw(Square(10, CustomColor(0.4, 0.4, 0.6))))
  }

}
