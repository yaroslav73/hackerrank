package fp

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class SolutionsSpec extends AnyWordSpec with Matchers {
  "evaluatingEpowX should evaluate for first 10 terms" in {
    val input  = List(20.0000, 5.0000, 0.5000, -0.5000)
    val output = List(2423600.1887, 143.6895, 1.6487, 0.6065)

    input.map(n => evaluatingEpowX(n, 8)) shouldBe output
  }
}
