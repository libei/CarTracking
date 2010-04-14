package edu.ou.ece.cartracking.domain

import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import collection.immutable.Stack

class HibernateUtilsSpec extends FlatSpec with ShouldMatchers {
  "A Stack" should "pop values in last-in-first-out order" in {
    val stack = new Stack[Int]
    stack.push(1)
    stack.push(2)
    stack.pop() should equal(2)
    stack.pop() should equal(1)
  }

  it should "throw NoSuchElementException if an empty stack is popped" in {
    val emptyStack = new Stack[String]
    evaluating {emptyStack.pop()} should produce[NoSuchElementException]
  }

}