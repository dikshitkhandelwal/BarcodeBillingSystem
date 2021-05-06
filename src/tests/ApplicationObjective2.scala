package tests

import org.scalatest.FunSuite
import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.{BottleDeposit, BuyOneGetOne, Item, LoyaltySale, Sale, SalesTax}

class ApplicationObjective2 extends FunSuite {

    def compareDoubles(d1 : Double, d2 : Double): Boolean = {

        Math.abs(d1 - d2) < 0.001
    }

    test("Testing of Application Objective One") {


        val a = new SelfCheckout()

        var ls1: List[ReceiptLine] = a.receiptLines()

        val item_1: Item = new Item("toy", 20.0)
        val item_2: Item = new Item("barbie", 30.0)
        val item_3: Item = new Item("car", 40.0)
        val S1: Sale = new Sale(5)
        val saletax: SalesTax = new SalesTax(5)
        val bogo: BuyOneGetOne = new BuyOneGetOne()
        val bogo2 : BuyOneGetOne = new BuyOneGetOne()
        val  bottledeposit : BottleDeposit = new BottleDeposit(10)
        val one: String = "1234"
        val two: String = "12345"
        val three: String = "0015"

        a.addItem(one, item_1)
        item_1.addModifier(S1)
        item_1.addModifier(saletax)
        item_1.addModifier(bogo2)


        a.addItem(two, item_2)
        item_2.addModifier(saletax)
        item_2.addModifier(bogo)
        item_2.addModifier(bottledeposit)

        a.addItem(three, item_3)
        item_3.addModifier(saletax)
        item_3.addModifier(S1)

        a.numberPressed(1)
        a.numberPressed(2)
        a.numberPressed(3)
        a.numberPressed(4)
        a.numberPressed(5)
        a.enterPressed()
        ls1 = a.receiptLines()
        assert(compareDoubles(ls1(0).amount, 30.0001), "one")

        a.numberPressed(1)
        a.numberPressed(2)
        a.numberPressed(3)
        a.numberPressed(4)
        a.numberPressed(5)
        a.enterPressed()
        ls1 = a.receiptLines()
        assert(compareDoubles(ls1(1).amount, 0.0), "two")

        a.numberPressed(1)
        a.numberPressed(2)
        a.numberPressed(3)
        a.numberPressed(4)
        a.numberPressed(5)
        a.enterPressed()
        ls1 = a.receiptLines()
        assert(compareDoubles(ls1(2).amount, 30.0), "two")

        a.numberPressed(1)
        a.numberPressed(2)
        a.numberPressed(3)
        a.numberPressed(4)
        a.enterPressed()
        ls1 = a.receiptLines()
        assert(compareDoubles(ls1(3).amount, 19.0001), "three")


        a.numberPressed(1)
        a.numberPressed(2)
        a.numberPressed(3)
        a.numberPressed(4)
        a.enterPressed()
        ls1 = a.receiptLines()
        assert(compareDoubles(ls1(4).amount, 0.0), "three")

        a.checkoutPressed()
        a.cashPressed()

        a.numberPressed(1)
        a.numberPressed(2)
        a.numberPressed(3)
        a.numberPressed(4)
        a.numberPressed(5)
        a.enterPressed()
        ls1 = a.receiptLines()
        assert(compareDoubles(ls1(0).amount, 30.0001), "one")

        a.checkoutPressed()
        assert(a.displayString() == "cash or credit", "eight")







    }
}