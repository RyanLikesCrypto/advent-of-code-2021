package Day3

enum Bit(val bit: Int):
  def flip(): Bit = this match {
    case `0` => `1`
    case `1` => `0`
  }

  case `0` extends Bit(0)
  case `1` extends Bit(1)
end Bit
