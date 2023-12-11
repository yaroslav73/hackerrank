package fp

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class SolutionsSpec extends AnyWordSpec with Matchers {
  "evaluatingEpowX should evaluate for first 10 terms" in {
    val input  = List(20.0000, 5.0000, 0.5000, -0.5000)
    val output = List(2423600.1887, 143.6895, 1.6487, 0.6065)

    input.map(n => evaluatingEpowX(n, 8)) shouldBe output
  }

  "summation should return correct value" in {
//    summation(area, 4, 1, List(1, 2, 3, 4, 5), List(6, 7, 8, 9, 10)) shouldBe 26172951168940.8
    summation(area, 20, 2, List(1, 2), List(0, 1)) shouldBe 36024.10264247688
  }
}
