package cl.mez

import org.scalatest._

class Ejemplo02 extends FunSuite with Matchers {

  def num(mc: Option[Int], d: Int, u: Int): Option[Int] =
    mc.map { c =>
      100 * c + 10 * d + u
    }

  test("num, c may be missing") {
    num(Some(6), 1, 9) shouldBe Some(619)
    num(None,    1, 9) shouldBe None
  }

}

