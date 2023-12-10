package algorithms

import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers

class AlgorithmsSpec extends AnyWordSpec with Matchers {
  "extraLongFactorials should correct calculate factorial" in {
    extraLongFactorials(25) shouldBe BigInt("15511210043330985984000000")
  }
}
