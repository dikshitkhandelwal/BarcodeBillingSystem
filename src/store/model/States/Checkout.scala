package store.model.States

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item
import store.model.items.BuyOneGetOne

class Checkout (Main : SelfCheckout) extends State (Main) {

  var message = "cash or credit"

  def addingSubTotal(): Unit ={
    for (items <- Main.items_purchased){
      Main.subtotal = Main.subtotal + items.loyaltyprice()
    }
  }

  def addingTax(): Unit ={
    for (items <- Main.items_purchased){
      Main.tax = Main.tax + items.loyaltytax()
    }
  }


  override def addItem(barcode: String, item: Item): Unit = {

  }

  override def numberPressed(number: Int): Unit = {

  }

  override def clearPressed(): Unit = {
  }

  override def enterPressed(): Unit = {
  }

  override def displayString(): String = {
    message
  }

  override def receiptLines(): List[ReceiptLine] = {
    Main.receipt
  }

  override def checkoutPressed(): Unit = {

  }

  override def cashPressed(): Unit = {

    for (items <- Main.items_purchased){
      for (modifiers <- items.ls){
        modifiers.resetBogo()
      }
    }

    Main.mainstate = new End (Main)
    Main.receipt = List()
    Main.items_purchased = List()
    Main.subtotal = 0.0
    Main.tax = 0.0

  }

  override def creditPressed(): Unit = {
    for (items <- Main.items_purchased){
      for (modifiers <- items.ls){
        modifiers.resetBogo()
      }
    }
    Main.mainstate = new End (Main)
    Main.receipt = List()
    Main.items_purchased = List()
    Main.subtotal = 0.0
    Main.tax = 0.0

  }

  override def loyaltyCardPressed(): Unit = {
    Main.receipt = List()
    for (items  <- Main.items_purchased){
      Main.receipt = Main.receipt :+ new ReceiptLine(items.description(), items.loyaltyprice())
    }
    Main.subtotal = 0.0
    Main.tax = 0.0
    addingTax()
    addingSubTotal()
    val rsubtotal = new ReceiptLine("subtotal", Main.subtotal )
    val rtax = new ReceiptLine("tax", Main.tax )
    val rtotal = new ReceiptLine("total", Main.subtotal + Main.tax)
    Main.receipt = Main.receipt :+ rsubtotal
    Main.receipt = Main.receipt :+ rtax
    Main.receipt = Main.receipt :+ rtotal
  }

  override def prepareStore(): Unit = {

  }


}
