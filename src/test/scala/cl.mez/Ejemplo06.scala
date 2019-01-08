package cl.mez

import org.scalatest._

class Ejemplo06 extends FunSuite with Matchers {

  def num(mc: Option[Int], md: Option[Int], mu: Option[Int]): Option[Int] =
    for {
      c <- mc
      d <- md
      u <- mu
    }
    yield 100 * c + 10 * d + u

  test("num, for-comprehension with Option") {
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

