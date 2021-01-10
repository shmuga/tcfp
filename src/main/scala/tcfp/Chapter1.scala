package scala.tcfp

object Chapter1 extends App {
  // 1
  def id[A](x: A): A = x

  // 2
  def compose[A, B, C](f: (A) => B, g: (B) => C): (A) => C = a => g(f(a))

  //3
  def f(x: Int): Int = x + 3
  println((id[Int] _ compose f)(4) == f(4))
  println((f _ compose id[Int])(4) == f(4))

  /**
   * 4
   * Yes
   */

  /**
   * 5
   * No because if A is friend of B and B is friend of C, A is not friend of C. Morphisms are not composable
   */

  /**
   * 6
   * When it is complete graph meaning that all vertices are connected between each other
   */
}
