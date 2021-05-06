package tests


import org.scalatest.FunSuite
import store.model.checkout.SelfCheckout
import store.model.checkout.ReceiptLine
import store.model.items.Item


class LectureTask5 extends FunSuite {



  test("Test 1"){
    val a  = new SelfCheckout()

    var ls1: List[ReceiptLine] = a.receiptLines()


    val item1: Item = new Item("toy", 20.0)
    val item2: Item = new Item("barbie", 30.0)
    val item3: Item = new Item("car", 40.0)

    val one: String = "1234"
    val two:String = "12345"
    val three = "0015"

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

    a.numberPressed(0)
    a.numberPressed(0)
    a.numberPressed(6)
    a.numberPressed(5)
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(3).description == "error", "seven")
  }


}