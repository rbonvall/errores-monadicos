package cl.mez

import org.scalatest._

object Ejemplo10 {
  type Id[T] = T
  implicit class IdOps[T](val it: Id[T]) extends AnyVal {
    def flatMap[U](f: T => Id[U]): Id[U] = f(it)
    def map    [U](f: T => U    ): Id[U] = f(it)
  }
}

class Ejemplo10 extends FunSuite with Matchers {
  import Ejemplo10._

  def num(lc: Int, ld: Int, lu: Int): Int =
    for {
      c <- lc
      d <- ld
      u <- lu
    }
    yield 100 * c + 10 * d + u

  test("num, for-comprehension with Id") {
    num(6, 1, 9) shouldBe 619
  }

}

