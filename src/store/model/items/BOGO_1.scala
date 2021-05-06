package store.model.items

class BOGO_1 (BOGO : BuyOneGetOne) extends Modifier {

  def updatePrice (price: Double): Double = {
    BOGO.ModifierState = new BOGO_2(BOGO)
    price
  }

  def computeTax (price: Double): Double = {
    0.0
  }

  def loyalty(price: Double) : Double ={
    BOGO.ModifierState = new BOGO_2(BOGO)
    price
  }

  override def resetBogo() : Unit ={

  }

}
