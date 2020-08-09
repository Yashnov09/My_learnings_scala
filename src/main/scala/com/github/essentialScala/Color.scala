package com.github.essentialScala

sealed trait Color {

  def red: Double
  def green: Double
  def blue: Double
  // We decided to define a "light" colour as one with // an average RGB of more than 0.5:
  def isLight = (red + green + blue) / 3.0 > 0.5
  def isDark = !isLight
}
case object Red extends Color {
  val red = 1.0
  val green = 0.0
  val blue = 0.0
}
case object Green extends Color {
  val red = 1.0
  val green = 1.0
  val blue = 0.0
}
case object Blue extends Color {
  val red = 1.0
  val green = 0.0
  val blue = 1.0
}

final case class CustomColor(red: Double, green: Double, blue: Double)
    extends Color
