package com.github.calculator
import scala.io.StdIn.readLine
import com.github.calculator.domain.Calculator
import com.github.calculator.console.LiveConsole

object CalculatorApp {

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

  def perform(op: Char, arg1: Double, arg2: Double, c: Calculator): Unit =
    op match {
      case '+' => c.evalAdd(arg1, arg2)
      case '-' => c.evalSub(arg1, arg2)
      case '*' => c.evalMultiple(arg1, arg2)
      case '/' => c.evalDivide(arg1, arg2)
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
    val console = new LiveConsole()
    val cal = new Calculator(console)

    while (isRunning) {
      println("Enter the operation")
      val line = readLine()
      val (op, arg1, arg2) = operand(line)
      perform(op, arg1, arg2, cal)
      println("Do you want to continue with Calculator: Y or N")
      val in = readLine()
      isRunning = isContinue(in)
    }
    println("Exiting the calculator App !!")

  }

}
