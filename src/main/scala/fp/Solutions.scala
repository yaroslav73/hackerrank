package fp

import scala.annotation.tailrec
import scala.math.BigDecimal.RoundingMode

// 1 + x + x^2/2! + x^3/3! + x^4/4! + ...
// Evaluate for first 10 terms
def evaluatingEpowX(x: Double, repeat: Int): Double =
  @tailrec
  def factorial(n: Int, acc: Int): Int =
    if n == 1 then acc
    else factorial(n - 1, n * acc)

  @tailrec
  def loop(acc: Double, pow: Int, repeat: Int): Double =
    if repeat != 0 then loop(acc + math.pow(x, pow) / factorial(pow, 1), pow + 1, repeat - 1)
    else acc

  BigDecimal(1 + x + loop(acc = 0, pow = 2, repeat)).setScale(4, RoundingMode.HALF_UP).toDouble
