package store.model.States

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item
import store.model.States.State


class DpStage_One (Main : SelfCheckout) extends State (Main) {



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
    Main.mainstate = new Scanning(Main)
  }

  override def displayString(): String = {
    ""
  }

  override def receiptLines(): List[ReceiptLine] = {
    Main.receipt
  }

  override def checkoutPressed(): Unit = {
  }

  override def cashPressed(): Unit = {
    Main.mainstate = new Scanning(Main)
  }

  override def creditPressed(): Unit = {
    Main.mainstate = new DpStage_Two(Main)
  }

  override def loyaltyCardPressed(): Unit = {

  }

  override def prepareStore(): Unit = {
  }


}
