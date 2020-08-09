package com.github.calculator.console
import scala.io.StdIn.readLine

trait Console {

  def printLine(line: String): Unit
  def read(): String

}

class LiveConsole extends Console {

  override def printLine(line: String): Unit = println(line)
  override def read(): String = readLine()
}
