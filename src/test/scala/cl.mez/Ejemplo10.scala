package cl.mez

import org.scalatest._

class Ejemplo10 extends FunSuite with Matchers {

  def isVowel(c: Char): Boolean = "aeiou".contains(c.toLower)

  val prices: Map[Char, Int] = Map('a' → 1000, 'c' → 2000, 'e' → 3000, 'z' → 4000)

  val input: Option[String] = Some("hello world")

  val result: Option[Int] =
    for {
      msg: String ← input
      vowel: Char ← msg.find(isVowel)
      price: Int  ← prices.get(vowel)
    } yield price

  val action: String = result match {
    case Some(p) ⇒ s"The price is $p."
    case None    ⇒ s"No price."
  }

  test("for comprehension with different types") {
    action shouldBe "The price is 3000."
  }

}

