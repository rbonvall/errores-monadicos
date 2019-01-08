package cl.mez

import org.scalatest._

class Ejemplo05 extends FunSuite with Matchers {

  def num(mc: Option[Int], md: Option[Int], mu: Option[Int]): Option[Int] =
    mc.flatMap { c =>
      md.flatMap { d =>
        mu.map { u =>
          100 * c + 10 * d + u
        }
      }
    }

  test("num, flattening the options") {
    num(Some(6), Some(1), Some(9)) shouldBe Some(619)
    num(Some(6), Some(1), None   ) shouldBe None
    num(Some(6), None,    Some(9)) shouldBe None
    num(Some(6), None,    None   ) shouldBe None
    num(None,    Some(1), Some(9)) shouldBe None
    num(None,    Some(1), None   ) shouldBe None
    num(None,    None,    Some(9)) shouldBe None
    num(None,    None,    None   ) shouldBe None
  }

}

