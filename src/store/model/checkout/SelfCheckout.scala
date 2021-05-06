package store.model.checkout
import store.model.States.{Initial, Scanning, State}
import store.model.checkout.ReceiptLine
import store.model.items.{BuyOneGetOne, Item, LoyaltySale, Modifier, Sale, SalesTax}


class SelfCheckout {

  var mainstate: State = new Initial(this)

  var barcode : String = ""

  var Items_Seller: Map[String, Item] = Map()
  var items_purchased : List[Item] = List()
  var receipt : List[ReceiptLine] = List()
  var subtotal: Double = 0.0
  var tax: Double = 0.0


  def addItem(barcode: String, item: Item): Unit = {
    Items_Seller += (barcode -> item)
  }

  def numberPressed(number: Int): Unit = {
    this.mainstate.numberPressed(number)
  }

  def clearPressed(): Unit = {
    this.mainstate.clearPressed()
  }

  def enterPressed(): Unit = {
    this.mainstate.enterPressed()
  }

  def displayString(): String = {
    this.mainstate.displayString()
  }

  def receiptLines(): List[ReceiptLine] = {
    this.mainstate.receiptLines()
  }

  def checkoutPressed(): Unit = {
    this.mainstate.checkoutPressed()
  }

  def cashPressed(): Unit = {
    this.mainstate.cashPressed()
  }

  def creditPressed(): Unit = {
    this.mainstate.creditPressed()
  }

  def loyaltyCardPressed(): Unit = {
    this.mainstate.loyaltyCardPressed()
  }

  def prepareStore(): Unit = {

    val item_1: Item = new Item("toy", 20.0)
    val item_2: Item = new Item("barbie", 30.0)
    val item_3: Item = new Item("car", 40.0)
    val LS1: LoyaltySale = new LoyaltySale(10)
    val S1: Sale = new Sale(5)
    val saletax: SalesTax = new SalesTax(5)
    val bogo : BuyOneGetOne = new BuyOneGetOne()
    val bogo2 : BuyOneGetOne = new BuyOneGetOne()

    val one: String = "1234"
    val two: String = "12345"
    val three = "0015"


    addItem(one, item_1)
    item_1.addModifier(S1)
    item_1.addModifier(LS1)
    item_1.addModifier(saletax)

    addItem(two, item_2)
    item_2.addModifier(saletax)
    item_2.addModifier(bogo)

    addItem(three, item_3)
    item_3.addModifier(saletax)
    item_3.addModifier(LS1)
    item_3.addModifier(bogo2)
//    val item1 = new Item("toy", 10.0)
//    val item2 = new Item("barbie", 100.0)
//    val item3 = new Item("car", 1000.0)
//    val item4 = new Item("mouse", 10000.0)
//
//    val sale_tax_one : SalesTax = new SalesTax(5)
//
//    val sale_one : Sale = new Sale(10)
//
//    val loyalty_sale_one: LoyaltySale = new LoyaltySale(10)
//
//    val one: String = "1"
//    val two:String = "12"
//    val three = "123"
//    val four : String = "1234"
//
//    item1.addModifier(sale_one)
//    item1.addModifier(sale_tax_one)
//    item1.addModifier(loyalty_sale_one)
//
//    item2.addModifier(sale_one)
//    item2.addModifier(sale_tax_one)
//    item2.addModifier(loyalty_sale_one)
//
//    item3.addModifier(sale_one)
//    item3.addModifier(loyalty_sale_one)
//
//    item4.addModifier(sale_one)
//
//
//    addItem(one, item1)
//    addItem(two, item2)
//    addItem(three, item3)
//    addItem(four, item4)

  }

}
