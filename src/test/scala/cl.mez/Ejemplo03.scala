package cl.mez

import org.scalatest._

class Ejemplo03 extends FunSuite with Matchers {

  def num(mc: Option[Int], md: Option[Int], u: Int): Option[Option[Int]] =
    mc.map { c =>
      md.map { d =>
        100 * c + 10 * d + u
      }
    }

  test("num, c and d may be missing") {
    num(Some(6), Some(1), 9) shouldBe Some(Some(619))
    num(Some(6), None,    9) shouldBe Some(None)
    num(None,    Some(1), 9) shouldBe None
    num(None,    None,    9) shouldBe None
  }

}

