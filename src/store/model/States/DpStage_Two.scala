package store.model.States

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item
import store.model.States.State

class DpStage_Two (Main : SelfCheckout) extends State (Main){


  override def addItem(barcode: String, item: Item): Unit = {

  }

  override def numberPressed(number: Int): Unit = {
    Main.mainstate = new Scanning(Main)
    Main.numberPressed(number)
  }

  override def clearPressed(): Unit = {
    Main.mainstate = new Scanning(Main)
  }

  override def enterPressed(): Unit = {
    Main.mainstate = new DeveloperState(Main)
    Main.tax = 0.0
    Main.subtotal = 0.0
    for (receipt <- Main.receipt){
      receipt.amount = 0.0
    }
  }

  override def displayString(): String = {
    ""
  }

  override def receiptLines(): List[ReceiptLine] = {
    Main.receipt
  }

  override def checkoutPressed(): Unit = {
    Main.mainstate = new Scanning(Main)
  }

  override def cashPressed(): Unit = {
    Main.mainstate = new Scanning(Main)
  }

  override def creditPressed(): Unit = {
    Main.mainstate = new Scanning(Main)
  }

  override def loyaltyCardPressed(): Unit = {

  }

  override def prepareStore(): Unit = {
  }

}
