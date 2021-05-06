package tests

import org.scalatest.FunSuite
import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item

class ApplicationObjective3 extends FunSuite {

  val a  = new SelfCheckout()
  test("hello"){

    var ls1: List[ReceiptLine] = a.receiptLines()

    val item1: Item = new Item("toy", 20.0)
    val item2: Item = new Item("barbie", 30.0)
    val item3: Item = new Item("car", 40.0)

    val one: String = "1234"
    val two:String = "12345"
    val three = "0015"
    assert(a.displayString().contains("welcome"))
    a.addItem(one, item1)
    a.addItem(two, item2)
    a.addItem(three, item3)

    a.cashPressed()

    a.numberPressed(1)
    a.numberPressed(2)
    assert(a.displayString() == "12", "one")
    a.clearPressed()
    assert(a.displayString() == "", "two")

    a.cashPressed()
    a.creditPressed()



    a.numberPressed(1)
    a.numberPressed(2)
    a.numberPressed(3)
    a.numberPressed(4)
    assert(a.displayString() == "1234", "three")
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(0).description == "toy", "four" )
    assert(ls1(0).amount == 20.0, "five")

    a.cashPressed()
    a.creditPressed()
    a.enterPressed()

    a.numberPressed(1)
    a.numberPressed(2)
    a.numberPressed(3)
    a.numberPressed(4)
    assert(a.displayString() == "1234", "six")
    a.enterPressed()
    a.enterPressed()
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(1).description == "toy", "seven" )
    assert(ls1(1).amount == 0.0, "eight")

    assert(ls1(2).description == "toy", "seven" )
    assert(ls1(2).amount == 0.0, "eight")

    assert(ls1(3).description == "toy", "seven" )
    assert(ls1(3).amount == 0.0, "eight")

    a.checkoutPressed()
    assert(a.displayString() == "cash or credit", "eight")

    ls1 = a.receiptLines()

    assert(ls1(4).description == "subtotal", "nine" )
    assert(ls1(4).amount == 0.0, "ten")

    assert(ls1(5).description == "tax", "eleven" )
    assert(ls1(5).amount == 0.0, "twelve")

    assert(ls1(6).description == "total", "thirteen" )
    assert(ls1(6).amount == 0.0, "fourteen")

    a.numberPressed(1)
    a.numberPressed(2)
    a.numberPressed(3)
    a.numberPressed(4)
    a.enterPressed()

    assert(a.displayString() == "cash or credit", "15")


    a.cashPressed()
    assert(a.displayString().contains("thank you"))

  }
}
