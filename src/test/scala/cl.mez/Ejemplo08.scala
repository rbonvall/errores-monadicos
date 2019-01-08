package cl.mez

import org.scalatest._

class Ejemplo08 extends FunSuite with Matchers {

  def num(lc: List[Int], ld: List[Int], lu: List[Int]): List[Int] =
    for {
      c <- lc
      d <- ld
      u <- lu
    }
    yield 100 * c + 10 * d + u

  test("num, for-comprehension with List") {
    num(List(1, 2, 3), List(4), List(5, 6)) shouldBe List(
      145, 146, 245, 246, 345, 346
    )
  }

}

