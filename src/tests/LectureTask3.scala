package tests

import store.model.items.{Sale, SaleTestingItem}
import org.scalatest.FunSuite
import store.model.items.SalesTax
import store.model.items.Sale
import store.model.items.Modifier
import store.model.items.BottleDeposit


class LectureTask3 extends FunSuite {

  var sale: Modifier = new Sale(20.0)
  var tax: Modifier = new SalesTax(5.0)
  var bottle : Modifier = new BottleDeposit(10.0)


  test ("Task 2 Test") {

    assert(sale.computeTax(100.0) == 0.0, "One")
    assert(sale.updatePrice(100.0) == 80.0, "Two")
    assert(tax.computeTax(100.0) == 5.0, "Three")
    assert(tax.updatePrice(100.0) == 100.0, "Four")
    assert(bottle.computeTax(100.0) == 10.0, "Five")
    assert(bottle.updatePrice(100.0) == 100.0, "Six")


  }

}
