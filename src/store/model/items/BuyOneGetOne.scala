package store.model.items

import store.model.items.Modifier

class BuyOneGetOne () extends Modifier {

  var ModifierState : Modifier = new BOGO_1(this)

  override def updatePrice(price: Double): Double = {
    this.ModifierState.updatePrice(price)
  }

  override def computeTax(price: Double): Double = {
    this.ModifierState.computeTax(price)
  }

  override def loyalty(price: Double): Double = {
    this.ModifierState.loyalty(price)
  }

  override def resetBogo() : Unit ={
    ModifierState = new BOGO_1(this)
  }


}
