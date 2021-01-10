package tcfp

import scala.collection.mutable
import scala.util.Random

object Chapter2 extends App {
  // 1
  def memoize[A, B](f: Function[A, B]): Function[A, B] = {
    val results: mutable.HashMap[A, B] = mutable.HashMap()

    param =>
      results.getOrElseUpdate(param, f(param))
  }

  def negate(a: Int) = -a

  val negMem = memoize(negate)
  negMem(1)
  negMem(1)
  negMem(2)
  negMem(2)

  // 2
  val getRandom = (_: Int) => new Random().nextInt()

  val randMem = memoize(new Random().nextInt)
  randMem(2)
  randMem(1)
  randMem(1)
  randMem(1)

  // 3
  val fact = (n: Int) => (1 to n).product

  val factMem = memoize(fact)
  factMem(10)
  factMem(10)
  factMem(10)
  factMem(10)

  // 5
  //  True -> False
  //  False -> True
  //  True -> True
  //  False -> False

  def not(in: Boolean) = !in
  def id(in: Boolean) = in
  def always(in: Boolean) = true
  def never(in: Boolean) = false

  // 6

}
