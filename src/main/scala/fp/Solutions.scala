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

// This function will be used while invoking "Summation" to compute
// The area under the curve.
def f(coefficients: List[Int], powers: List[Int], x: Double): Double =
  // Fill Up this function body
  // To compute the value of the function
  // For the given coefficients, powers and value of x
  coefficients.zip(powers).foldLeft(0.0) { case (acc, (c, p)) =>
    acc + c * math.pow(x, p)
  }

// This function will be used while invoking "Summation" to compute
// The Volume of revolution of the curve around the X-Axis
// The 'Area' referred to here is the area of the circle obtained
// By rotating the point on the curve (x,f(x)) around the X-Axis
def area(coefficients: List[Int], powers: List[Int], x: Double): Double =
  // Fill Up this function body
  // To compute the area of the circle on revolving the point
  // (x,f(x)) around the X-Axis
  // For the given coefficients, powers and value of x
  // Area of circle Pi * r^2
  math.Pi * math.pow(f(coefficients, powers, x), 2)

// This is the part where the series is summed up
// This function is invoked once with func = f to compute the area
// under the curve
// Then it is invoked again with func = area to compute the volume
// of revolution of the curve
def summation(
  func: (List[Int], List[Int], Double) => Double,
  upperLimit: Int,
  lowerLimit: Int,
  coefficients: List[Int],
  powers: List[Int],
): Double =
  // Fill up this function
  val subinterval = 0.001
  val points      = (upperLimit - lowerLimit) / subinterval
  (1 to points.toInt).toList.foldLeft(0.0) { (acc, p) =>
    acc + subinterval * func(coefficients, powers, lowerLimit + p * subinterval)
  }
