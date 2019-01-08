package cl.mez

import org.scalatest._

class Ejemplo01 extends FunSuite with Matchers {

  /** Crea un número de tres cifras a partir de sus tres dígitos. */
  def num(c: Int, d: Int, u: Int): Int =
    100 * c + 10 * d + u

  test("num") {
    num(6, 1, 9) shouldBe 619
  }

}
