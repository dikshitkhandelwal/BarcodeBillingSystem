package store.model.States

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item
import store.model.States.State


class Developer_ReScanning (Main : SelfCheckout) extends State (Main) {

  override def addItem(barcode: String, item: Item): Unit = {

  }

  override def numberPressed(number: Int): Unit = {
    Main.mainstate = new DeveloperState(Main)
    Main.numberPressed(number)
  }

  override def clearPressed(): Unit = {
    Main.receipt = Main.receipt :+ new ReceiptLine("error", 0.0)
    Main.mainstate = new DeveloperState(Main)
  }

  override def enterPressed(): Unit = {
    val reverse_receipt = new ReceiptLine(Main.receipt.reverse(0).description, 0.0)
    val reverse_item_ls = new Item (Main.items_purchased.reverse(0).description(), 0.0)
    Main.receipt = Main.receipt :+ reverse_receipt
    Main.items_purchased = Main.items_purchased :+reverse_item_ls

  }

  override def displayString(): String = {
    ""
  }

  override def receiptLines(): List[ReceiptLine] = {
    Main.receipt
  }

  override def checkoutPressed(): Unit = {
    val rsubtotal = new ReceiptLine("subtotal",0.0)
    val rtax = new ReceiptLine("tax", 0.0 )
    val rtotal = new ReceiptLine("total", 0.0)
    Main.receipt = Main.receipt :+ rsubtotal
    Main.receipt = Main.receipt :+ rtax
    Main.receipt = Main.receipt :+ rtotal
    Main.mainstate = new Checkout(Main)
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