package store.model.items

import store.model.items.Modifier

class LoyaltySale (var percentage_of_sale:Double) extends Modifier {

  override def updatePrice(price: Double): Double = {
    price
  }

  override def computeTax(price: Double): Double = {
    0.0
  }

  override def loyalty(price: Double): Double = {
    val discount = (percentage_of_sale/100)* price
    val output = price - discount
    output
  }

  override def resetBogo() : Unit ={

  }

}
