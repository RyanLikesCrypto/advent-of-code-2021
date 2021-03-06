package Day03

case class PowerConsumption(gammaRate: List[Bit], epsilonRate: List[Bit]) {
  def compute() = BinaryDiagnostics.decode(gammaRate) * BinaryDiagnostics.decode(epsilonRate)
}
