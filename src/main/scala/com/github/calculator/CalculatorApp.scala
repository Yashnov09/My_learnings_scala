package com.github.calculator
import scala.io.StdIn.readLine

object CalculatorApp {

  /* Methods to perform various operations */

  def evalAdd(a: Double, b: Double): Double = {
    val c = a + b
    println(s"Result is $c")
    c
  }

  def evalSub(a: Double, b: Double): Double = {
    val c = a - b
    println(s"Result is $c")
    c
  }

  def evalMultiple(a: Double, b: Double): Double = {
    val c = a * b
    println(s"Result is $c")
    c
  }

  def evalDivide(a: Double, b: Double): Double = {
    require(b != 0, "Denominator cannot be 0")
    val c = a / b
    println("Result is " + c)
    c
  }

  /*Method to remove Digits/char*/
  def removeDigit(s: String): Char = {
    if (s.contains('.')) {
      s.filter(c => (!c.isDigit && c != '.')).head
    } else s.filter(c => !c.isDigit).head
  }

  def getChoice: Unit = {

    val help = """Please enter the operation to perform
                 |For Eg: 3+6""".stripMargin
    val line = readLine().toLowerCase()

    checkLine(line) match {
      case Left(error) =>
        println(error)
        getChoice
      case Right(_) => println(help)
    }

  }

  def checkLine(line: String): Either[String, Unit] = {
    line match {
      case "help" => Right(())
      case _      => Left("Invalid input, please type help !!")
    }

  }

  def operand(line: String): (Char, Double, Double) = {
    val nextStep = line.replaceAll(" +", "")
    val sym = removeDigit(nextStep)
    val delimit = "([\\+\\/\\-\\*]+)"
    val Args = nextStep.split(delimit).map(_.toDouble).toList
    (sym, Args.head, Args(1))
  }

  def perform(op: Char, arg1: Double, arg2: Double): Unit = op match {
    case '+' => evalAdd(arg1, arg2)
    case '-' => evalSub(arg1, arg2)
    case '*' => evalMultiple(arg1, arg2)
    case '/' => evalDivide(arg1, arg2)
    case _   => System.exit(0)
  }

  def isContinue(in: String): Boolean = {
    in.toUpperCase() match {
      case "Y" => true
      case "N" => false
    }

  }

  def main(args: Array[String]): Unit = {
    println("************* Welcome to calculator! Type help *************")
    getChoice
    var isRunning = true
    while (isRunning) {
      println("Enter the operation")
      val line = readLine()
      val (op, arg1, arg2) = operand(line)
      perform(op, arg1, arg2)
      println("Do you want to continue with Calculator: Y or N")
      val in = readLine()
      isRunning = isContinue(in)
    }
    println("Exiting the calculator App !!")

  }

}
