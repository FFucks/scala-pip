import scala.annotation.tailrec

/*
P01 (*) Find the last element of a list.
Example:

    scala> last(List(1, 1, 2, 3, 5, 8))
res0: Int = 8
*/


object P01 {
    def main(args: Array[String]): Unit = {
        val l1 = List(1, 1, 2, 3, 5, 8)
        println(s"last of $l1 = ${lastElement(l1)}")

        val l2 = List("a", "b", "c")
        println(s"last of $l2 = ${lastElement(l2)}")

        val empty = List.empty[Int]
        try {
            println(s"last of $empty = ${lastElement(empty)}")
        } catch {
            case e: NoSuchElementException => println(s"Caught exception: ${e.getMessage}")
        }
    }

    //Ask to the compiler to ensure that the method is tail-recursive
    //If the function is tail recursive, compile normally
    //If not, it raises a compile-time error
    //It is not change teh runtime behavior of the function, it simply ensures at compile time that the optimization will be applied.
    @tailrec
    def lastElement[A](ls: List[A]): A = {
        ls match {
            case Nil => throw new NoSuchElementException("List is empty")
            case h :: Nil => h
            case _ :: tail => lastElement(tail)
        }
    }
}
