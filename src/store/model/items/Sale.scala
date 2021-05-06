package store.model.items
import store.model.items.Modifier


class Sale (var percentOff: Double ) extends Modifier {

  override def updatePrice(price: Double): Double = {
    val discount = (percentOff/100)* price
    val output = price - discount
    output
  }

  override def computeTax(price: Double): Double = {
    0.0
  }

  override def loyalty(price: Double): Double = {
    val discount = (percentOff/100)* price
    val output = price - discount
    output
  }

  override def resetBogo() : Unit ={

  }

}


