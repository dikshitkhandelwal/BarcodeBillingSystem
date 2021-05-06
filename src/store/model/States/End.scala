package store.model.States

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item

class End (Main : SelfCheckout) extends State (Main){

  var message = "thank you"

  override def addItem(barcode: String, item: Item): Unit = {
  }

  override def numberPressed(number: Int): Unit = {
    Main.mainstate = new Scanning(Main)
    Main.receipt = List()
    Main.numberPressed(number)
  }

  override def clearPressed(): Unit = {
  }

  override def enterPressed(): Unit = {
  }

  override def displayString(): String = {
    message
  }

  override def receiptLines(): List[ReceiptLine] = {
    List()
  }

  override def checkoutPressed(): Unit = {
  }

  override def cashPressed(): Unit = {
  }

  override def creditPressed(): Unit = {
  }

  override def loyaltyCardPressed(): Unit = {

  }

  override def prepareStore(): Unit = {
  }



}
