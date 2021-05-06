package tests

import org.scalatest.FunSuite
import store.model.items.SaleTestingItem
import store.model.items.Sale



class LectureTask2 extends FunSuite {

  def compareDoubles(d1: Double , d2: Double): Boolean = {
    val e = 0.001
    Math.abs(d1-d2) < e
  }

  var test1 : SaleTestingItem = new SaleTestingItem("First", 20.0)

  test ("Task 2 Test"){


    var sale1 : Sale = new Sale(10.0)

    test1.addSale(sale1)

    assert(compareDoubles(test1.price, 18.000848),"One")

    sale1.percentOff = 20.0

    assert(compareDoubles(test1.price, 16.000848),"One")

    val sale2: Sale = new Sale(20.0)
    val sale3: Sale = new Sale(30.0)
    val sale4: Sale = new Sale(30.0)

    test1.addSale(sale2)


    assert(compareDoubles(test1.price, 12.8004344540), "Two")

    test1.addSale(sale3)
    test1.addSale(sale4)

    assert(compareDoubles(test1.price, 6.272080003487548), "Three")

  }

}
