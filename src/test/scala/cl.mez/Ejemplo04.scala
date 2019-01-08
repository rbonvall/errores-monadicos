package cl.mez

import org.scalatest._

class Ejemplo04 extends FunSuite with Matchers {

  def num(mc: Option[Int], md: Option[Int], mu: Option[Int]): Option[Option[Option[Int]]] =
    mc.map { c =>
      md.map { d =>
        mu.map { u =>
          100 * c + 10 * d + u
        }
      }
    }

  test("num, all values may be missing") {
    num(Some(6), Some(1), Some(9)) shouldBe Some(Some(Some(619)))
    num(Some(6), Some(1), None   ) shouldBe Some(Some(None))
    num(Some(6), None,    Some(9)) shouldBe Some(None)
    num(Some(6), None,    None   ) shouldBe Some(None)
    num(None,    Some(1), Some(9)) shouldBe None
    num(None,    Some(1), None   ) shouldBe None
    num(None,    None,    Some(9)) shouldBe None
    num(None,    None,    None   ) shouldBe None
  }

}

