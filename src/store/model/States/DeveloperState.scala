package store.model.States

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item
import store.model.States.State


class DeveloperState (Main: SelfCheckout) extends State (Main) {


  var num: String = ""


  override def addItem(barcode: String, item: Item): Unit = {

  }

  override def numberPressed(number: Int): Unit = {
    num += number
  }

  override def clearPressed(): Unit = {
    num = ""
  }

  override def enterPressed(): Unit = {
    val code = Main.mainstate.displayString()
    Main.mainstate.clearPressed()
    val receiptitem = Main.Items_Seller.getOrElse(code , new Item ("error",0.0) )
    val item = receiptitem
    item.scanned()
    Main.items_purchased = Main.items_purchased :+ item
    Main.receipt = Main.receipt :+ new ReceiptLine(item.description(), 0.0)
    Main.mainstate = new Developer_ReScanning(Main)
  }

  override def displayString(): String = {
    num
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
