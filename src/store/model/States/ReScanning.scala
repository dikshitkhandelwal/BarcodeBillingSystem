package store.model.States

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item

class ReScanning (Main : SelfCheckout) extends State(Main){


  var bar = Main.barcode

  def addingSubTotal(): Unit ={
    for (items <- Main.items_purchased){
      Main.subtotal = Main.subtotal + items.price()
    }
  }

  def addingTax(): Unit ={
    for (items <- Main.items_purchased){
      Main.tax = Main.tax + items.tax()
    }
  }

  override def addItem(barcode: String, item: Item): Unit = {
  }

  override def numberPressed(number: Int): Unit = {
    Main.mainstate = new Scanning(Main)
    Main.numberPressed(number)
    Main.barcode = ""
  }

  override def clearPressed(): Unit = {
    Main.receipt = Main.receipt :+ new ReceiptLine("error", 0.0)
    Main.mainstate = new Scanning(Main)
  }

  override def enterPressed(): Unit = {

    //val barcode = Main.items_purchased.reverse(0).description()
    val repeat_item = Main.Items_Seller.getOrElse(bar, new Item("Dikshit", 0.0))
    Main.items_purchased = Main.items_purchased :+ repeat_item
    Main.receipt = Main.receipt :+ new ReceiptLine(repeat_item.description(), repeat_item.price())


  }

  override def displayString(): String = {
    ""
  }

  override def receiptLines(): List[ReceiptLine] = {
    Main.receipt
  }

  override def checkoutPressed(): Unit = {
    addingTax()
    addingSubTotal()
    val rsubtotal = new ReceiptLine("subtotal", Main.subtotal )
    val rtax = new ReceiptLine("tax", Main.tax )
    val rtotal = new ReceiptLine("total", Main.subtotal + Main.tax)
    Main.receipt = Main.receipt :+ rsubtotal
    Main.receipt = Main.receipt :+ rtax
    Main.receipt = Main.receipt :+ rtotal
    Main.mainstate = new Checkout(Main)
  }

  override def cashPressed(): Unit = {
    Main.mainstate = new DpStage_One(Main)
  }

  override def creditPressed(): Unit = {

  }

  override def loyaltyCardPressed(): Unit = {
    Main.mainstate = new LoyaltySale_Scanning(Main)
    Main.receipt = List()
    for (items  <- Main.items_purchased){
      Main.receipt = Main.receipt :+ new ReceiptLine(items.description(), items.loyaltyprice())
    }
  }

  override def prepareStore(): Unit = {

  }


}
