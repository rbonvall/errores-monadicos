package cl.mez

import org.scalatest._

class Ejemplo07 extends FunSuite with Matchers {

  def num(ec: Either[Char, Int], ed: Either[Char, Int], eu: Either[Char, Int]): Either[Char, Int] =
    for {
      c <- ec
      d <- ed
      u <- eu
    }
    yield 100 * c + 10 * d + u

  test("num, for-comprehension with Either") {
    num(Right(6),  Right(1),  Right(9) ) shouldBe Right(619)
    num(Right(6),  Right(1),  Left('u')) shouldBe Left('u')
    num(Right(6),  Left('d'), Right(9) ) shouldBe Left('d')
    num(Right(6),  Left('d'), Left('u')) shouldBe Left('d')
    num(Left('c'), Right(1),  Right(9) ) shouldBe Left('c')
    num(Left('c'), Right(1),  Left('u')) shouldBe Left('c')
    num(Left('c'), Left('d'), Right(9) ) shouldBe Left('c')
    num(Left('c'), Left('d'), Left('u')) shouldBe Left('c')
  }

}

