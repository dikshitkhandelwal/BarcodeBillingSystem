package store.model.States

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.{Item, LoyaltySale, Sale}

class Scanning (Main: SelfCheckout) extends State (Main){

  var num: String = ""



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
    num += number
  }

  override def clearPressed(): Unit = {
    num = ""
  }

  override def enterPressed(): Unit = {
    val code = Main.mainstate.displayString()
    Main.barcode = code
    Main.mainstate.clearPressed()
    val receiptitem = Main.Items_Seller.getOrElse(code , new Item ("error",0.0) )
    val item = receiptitem
    item.scanned()
    Main.items_purchased = Main.items_purchased :+ item
    Main.receipt = Main.receipt :+ new ReceiptLine(item.description(), item.price())
    Main.mainstate = new ReScanning(Main)
  }

  override def displayString(): String = {
    num
  }

  override def receiptLines(): List[ReceiptLine] = {
    Main.receipt
  }

  override def checkoutPressed(): Unit = {
    addingTax()
    addingSubTotal()
    val rsubtotal = new ReceiptLine("subtotal", Main.subtotal)
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
    // To Do
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