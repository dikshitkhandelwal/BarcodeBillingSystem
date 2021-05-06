package tests

import org.scalatest.FunSuite
import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item

class LectureTask6 extends FunSuite {

  test("Testing LT 6"){

    val a  = new SelfCheckout()

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

    a.numberPressed(1)
    a.numberPressed(2)
    assert(a.displayString() == "12", "one")
    a.clearPressed()
    assert(a.displayString() == "", "two")

    a.numberPressed(1)
    a.numberPressed(2)
    a.numberPressed(3)
    a.numberPressed(4)
    assert(a.displayString() == "1234", "three")
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(0).description == "toy", "four")

    a.numberPressed(1)
    a.numberPressed(2)
    a.numberPressed(3)
    a.numberPressed(4)
    a.numberPressed(5)
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(1).description == "barbie", "five")


    a.numberPressed(0)
    a.numberPressed(0)
    a.numberPressed(1)
    a.numberPressed(5)
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(2).description == "car", "six")
    a.enterPressed()
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(3).description == "car", "six")
    assert(ls1(4).description == "car", "six")


    a.checkoutPressed()
    assert(a.displayString() == "cash or credit")

    a.numberPressed(1)
    a.numberPressed(2)
    a.numberPressed(3)
    a.numberPressed(4)
    a.enterPressed()

    assert(a.displayString() == "cash or credit")



    a.cashPressed()
    assert(a.displayString().contains("thank you"))
  }

}