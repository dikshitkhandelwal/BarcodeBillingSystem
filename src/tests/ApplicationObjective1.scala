package tests

import org.scalatest.FunSuite
import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.{Item, LoyaltySale, Sale, SalesTax}

class ApplicationObjective1 extends FunSuite {


  test("Testing of Application Objective One") {
    val a = new SelfCheckout()

    val item_1: Item = new Item("toy", 20.0)
    val item_3: Item = new Item("car", 40.0)
    val LS1: LoyaltySale = new LoyaltySale(10)
    val S1: Sale = new Sale(5)
    val saletax: SalesTax = new SalesTax(5)

    val one: String = "1234"
    val three = "0015"


    a.addItem(one, item_1)
    item_1.addModifier(S1)
    item_1.addModifier(LS1)
    item_1.addModifier(saletax)

    a.addItem(three, item_3)
    item_3.addModifier(saletax)
    item_3.addModifier(LS1)

    var ls1: List[ReceiptLine] = a.receiptLines()

    a.numberPressed(1)
    a.numberPressed(2)
    a.numberPressed(3)
    a.numberPressed(4)
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(0).description == "toy", "Two")
    assert(ls1(0).amount == 19.0, "Three")

    /****************** Calling Loyalty Sale **************************/
    a.loyaltyCardPressed()

    ls1 = a.receiptLines()

    assert(ls1(0).description == "toy", "Two-Repeat")
    assert(ls1(0).amount == 17.1, "Three-Repeat")

    a.numberPressed(1)
    a.numberPressed(2)
    a.numberPressed(3)
    a.numberPressed(4)
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(1).description == "toy", "Four")
    assert(ls1(1).amount == 17.1, "Five")

    a.numberPressed(0)
    a.numberPressed(0)
    a.numberPressed(1)
    a.numberPressed(5)
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(2).description == "car", "six")
    assert(ls1(2).amount == 36.0, "Seven")
    a.enterPressed()
    a.enterPressed()
    ls1 = a.receiptLines()

    assert(ls1(3).description == "car", "Eight")
    assert(ls1(3).amount == 36.0, "Nine")

    assert(ls1(4).description == "car", "Ten")
    assert(ls1(4).amount == 36.0, "Eleven")

    a.checkoutPressed()
    assert(a.displayString() == "cash or credit","Twelve")

    a.cashPressed()
    assert(a.displayString().contains("thank you"), "Thirteen")

    ls1 = a.receiptLines()
    assert(ls1 == List())


    /*********************************** New Customer*******************************/


    a.numberPressed(1)
    a.numberPressed(2)
    a.numberPressed(3)
    a.numberPressed(4)
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(0).description == "toy", "Fourteen")
    assert(ls1(0).amount == 19.0, "Fiveteen")

    a.numberPressed(0)
    a.numberPressed(0)
    a.numberPressed(1)
    a.numberPressed(5)
    a.enterPressed()
    ls1 = a.receiptLines()
    assert(ls1(1).description == "car", "Eighteen")
    assert(ls1(1).amount == 40.0, "Nineteen")
    a.enterPressed()

    ls1 = a.receiptLines()

    assert(ls1(2).description == "car", "Twenty")
    assert(ls1(2).amount == 40.0, "Twenty-One")


    /**************Calling Loyal Sale for Customer 2 after Checkout********/

    a.checkoutPressed()
    a.loyaltyCardPressed()
    ls1 = a.receiptLines()

    assert(ls1(0).description == "toy", "Twenty-Four")
    assert(ls1(0).amount == 17.1, "Twenty-Five")

    assert(ls1(1).description == "car", "Twenty-Eight")
    assert(ls1(1).amount == 36.0, "Twenty-")

    assert(ls1(2).description == "car", "Twenty-Nine")
    assert(ls1(2).amount == 36.0, "Thirty")

    a.cashPressed()
    assert(a.displayString().contains("thank you"), "Thirty-Two")

  }

}
