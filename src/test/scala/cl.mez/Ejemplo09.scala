package cl.mez

import org.scalatest._
import scala.util.{Try, Success, Failure}

class Ejemplo09 extends FunSuite with Matchers {

  def num(tc: Try[Int], td: Try[Int], tu: Try[Int]): Try[Int] =
    for {
      c <- tc
      d <- td
      u <- tu
    }
    yield 100 * c + 10 * d + u

  test("num, for-comprehension with Try") {

    def six  = Try { 3 + 3 }
    def one  = Try { 1 }
    def nine = Try { 3 * 3 }
    def fail = Try { 1 / 0 }
    def boom = Try { null.asInstanceOf[String].toInt }

    num(six, one, nine) shouldBe Success(619)

    num(six, one, boom) shouldBe a [Failure[_]]
    num(six, one, boom)

  }

}

