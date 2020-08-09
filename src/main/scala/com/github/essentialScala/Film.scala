package com.github.essentialScala

case class Film(name: String,
                yearOfRelease: Int,
                imdbRating: Double,
                director: Director) {

  def directorsAge: Int = yearOfRelease - director.yearOfBirth

  def isDirectedBy(dir: Director): Boolean =
    if (dir == director) true else false

}

object Film {
  def newer(film1: Film, film2: Film): Film =
    if (film1.yearOfRelease < film2.yearOfRelease) film1 else film2

  def highestRating(film1: Film, film2: Film): Film = {
    if (film1.imdbRating > film2.imdbRating) film1
    else film2
  }

  def oldestDirectorAtTheTime(film1: Film, film2: Film): Director = {
    if (film1.directorsAge > film2.directorsAge) film1.director
    else film2.director
  }

  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)
  val someBody = new Director("Just", "Some Body", 1990)

  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)
  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales =
    new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)
  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober =
    new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair =
    new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

  def main(args: Array[String]): Unit = {
    println(eastwood.yearOfBirth)
    println(dieHard.director.name)
    println(invictus.isDirectedBy(nolan))
    inception.copy()
  }
}
