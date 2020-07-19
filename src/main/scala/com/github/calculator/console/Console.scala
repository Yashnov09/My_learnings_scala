package com.github.calculator.console

trait Console {

  def printLine(line: String): Unit

  def readLine(): String

}

class LiveConsole extends Console {
  override def printLine(line: String): Unit = println(line)

  override def readLine(): String = scala.io.StdIn.readLine()
}
