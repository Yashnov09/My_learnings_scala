package com.github.essentialScala

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

case class Counter(count: Int = 0) extends Adder(count) {
  def dec: Counter = dec()
  def inc: Counter = inc()
  def dec(amount: Int = 1) = copy(count = count - 1)
  def inc(amount: Int = 1) = copy(count = count - 1)

  def adjust(adder: Adder): Counter = new Counter(adder.add(count))

}

object Counter {
  def main(args: Array[String]): Unit = {
    println(new Counter(10).inc.inc(10).count)

  }
}
