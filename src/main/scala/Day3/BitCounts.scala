package Day3

case class BitCounts(zeros: List[Int], ones: List[Int]) {
  // most popular bits
  def gamma(): List[Bit] = zeros.zip(ones).map((zeroCount: Int, oneCount: Int) => {
    if (zeroCount == oneCount) Bit.`1`
    else if (zeroCount > oneCount) Bit.`0`
    else Bit.`1`
  })
  // least popular bits
  def epsilon(): List[Bit] = zeros.zip(ones).map((zeroCount: Int, oneCount: Int) => {
    if (zeroCount == oneCount) Bit.`0`
    else if (zeroCount == 0) Bit.`1`
    else if (oneCount == 0) Bit.`0`
    else if (zeroCount < oneCount) Bit.`0`
    else Bit.`1`
  })
}

object BitCounts {
  def apply(diagnostics: List[List[Bit]]): BitCounts = {
    val length = if (diagnostics.isEmpty) 0 else diagnostics.head.length
    val noCountsList = List.fill[Int](length)(0)
    BitCounts(noCountsList, noCountsList)
  }
}
