package algorithms

import scala.annotation.tailrec

def extraLongFactorials(n: Int): BigInt =
  @tailrec
  def loop(n: Int, acc: BigInt): BigInt =
    if (n == 1) acc
    else loop(n - 1, n * acc)

  loop(n, 1)
