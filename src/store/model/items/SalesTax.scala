package store.model.items
import store.model.items.Modifier


class SalesTax (var tax_percentage: Double) extends Modifier {

  override def updatePrice(price: Double): Double = {
    price
  }

  override def computeTax(price: Double): Double = {
    price*tax_percentage/100

  }

  override def loyalty(price: Double): Double = {
    price
  }

  override def resetBogo() : Unit ={

  }

}
