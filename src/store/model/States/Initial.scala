package store.model.States

import store.model.checkout.{ReceiptLine, SelfCheckout}
import store.model.items.Item

class Initial (Main : SelfCheckout) extends State (Main) {

  var message : String = "welcome"

  override def addItem(barcode: String, item: Item): Unit = {

  }

  override def numberPressed(number: Int): Unit = {
    Main.mainstate = new Scanning(Main)
    Main.mainstate.numberPressed(number)
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
    Main.mainstate = new DpStage_One(Main)
  }

  override def creditPressed(): Unit = {

  }

  override def loyaltyCardPressed(): Unit = {
    Main.mainstate = new LoyaltySale_Scanning(Main)
    Main.receipt = List()
    for (items  <- Main.items_purchased){
      Main.receipt = Main.receipt :+ new ReceiptLine(items.description(), items.price())
    }
  }

  override def prepareStore(): Unit = {

    }



}
