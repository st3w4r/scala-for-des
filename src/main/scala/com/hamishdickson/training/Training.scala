package com.hamishdickson.training

import java.util.LinkedList

trait Maybe[+T] // + include substyes
case class MySome[A](value: A) extends Maybe[A]
object MyNone extends Maybe[Nothing]

// Top type: Any
// Bottom type: Nothing


// Either, left for the error, right for the value
trait MyEither[T]
case class Left[T](error: T) extends MyEither[T]
case class Right[T](value: T) extends MyEither[T]

// Companion object
object Maybe {
    // Option A -> (A -> B) -> Option B
    // Possibility of Partialy apply
    def map[A, B](option: Maybe[A])(f: A => B): Maybe[B] = option match {
        case MySome(bob) => MySome(f(bob))
        case MyNone => MyNone
    }
}

object Training {
    
    def foo(file: String): Maybe[Int] = {
        ???
    }

    // Value evaluated when the socpe surround it evaluate it
    // val a = ???

    import Maybe._
    val a: MySome[Int] = MySome(12)


    lazy val b: MySome[String] = MySome("Hey there")

    println(b)

    def bar(a: String) = a + "2"

    val l: Int => String = a => a.toString + "Nice !"

    l(12)

    // Lambda: Nothing outside
    // Closure: Can bring things from outside    

    val xs: MyLinkedList[Int] = Cons(1,MyNil)

    lazy val ys:List[Int] = 37::Nil
    val asd: List[Int] = 12 :: ys

}

trait MyLinkedList[+T]
object MyNil extends MyLinkedList[Nothing]
case class Cons[T](head: T, tail: MyLinkedList[T]) extends MyLinkedList[T]



// Never use return, return the last thing in the call stack
object MyLinkedList {
    def map[A, B](a: MyLinkedList[A])(f: A => B): MyLinkedList[B] = a match {
        case Cons(head, tail) => Cons(f(head), map(tail)(f))
        case MyNil => MyNil
    }
}
