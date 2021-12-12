package Day06

import Day06.Lanternfish.spawnCountdownReset

case class Lanternfish(spawnCountdown: Int) {
  def age: List[Lanternfish] =
    if (spawnCountdown == 0) List(Lanternfish(spawnCountdownReset), Lanternfish.apply)
    else List(Lanternfish(spawnCountdown - 1))

  override def toString: String = spawnCountdown.toString
}

object Lanternfish {
  val startingCountdown = 8
  val spawnCountdownReset = 6
  def apply: Lanternfish = Lanternfish(startingCountdown)
}
