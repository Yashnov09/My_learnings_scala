package com.github.essentialScala

object person {
  val firstName = "Yash"
  val lastName = "Sait"
}

object alien {
  def greet(p: person.type) =
    println("Greetings, " + p.firstName + " " + p.lastName)

  def main(args: Array[String]): Unit = {
    alien.greet(person)
  }
}
