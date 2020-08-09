package com.github.essentialScala

case class Director(firstName: String, lastName: String, yearOfBirth: Int) {

  def name(): String = firstName + " " + lastName

}

object Director {

  def older(dir1: Director, dir2: Director): Director = {
    if (dir1.yearOfBirth > dir2.yearOfBirth) dir1
    else dir2
  }

}
