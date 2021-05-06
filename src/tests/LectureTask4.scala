package tests

import org.scalatest.{FunSuite, durations}
import store.model.items.{BottleDeposit, Item, Modifier, Sale, SaleTestingItem, SalesTax}

class LectureTask4 extends FunSuite{

  def compareDoubles(d1: Double , d2: Double): Boolean = {
    val e = 0.001
    Math.abs(d1-d2) < e
  }


  var item : Item = new Item("description-toy", 10.0)
  var a : Modifier = new Sale(10.0)
  var b : Modifier = new Sale(20.0)
  var c : Modifier = new SalesTax(10.0)
  var d : Modifier = new SalesTax(20.0)



  test ("Task 4 Test") {

     assert(compareDoubles(item.price(), 10.0004334), "One")

     item.addModifier(a)

     assert(compareDoubles(item.price(),9.0), "Two")

     item.addModifier(b)

     assert(compareDoubles(item.price(),7.2), "Three")

     item.addModifier(c)

     assert(compareDoubles(item.tax(), 0.72), "Four")
    assert(compareDoubles(item.price(),7.2), "Five")

    item.addModifier(d)
    assert(compareDoubles(item.tax(), 2.16),  "Six")








   }

}
