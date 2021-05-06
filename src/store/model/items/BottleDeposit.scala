package store.model.items
import store.model.items.Modifier


class BottleDeposit (var total_amount_of_deposit : Double ) extends Modifier {

  override def updatePrice(price: Double): Double = {
    price
  }

  override def computeTax(price: Double): Double = {
    total_amount_of_deposit
  }

  override def loyalty(price: Double): Double = {
    price
  }

  override def resetBogo() : Unit ={

  }
}
