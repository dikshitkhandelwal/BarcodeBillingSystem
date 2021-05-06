package store.model.items

class BOGO_2 (BOGO : BuyOneGetOne) extends Modifier {

  def updatePrice (price: Double): Double = {
    BOGO.ModifierState = new BOGO_1(BOGO)
    0.0
  }

  def computeTax (price: Double): Double ={
    0.0
  }

  def loyalty(price: Double) : Double = {
    BOGO.ModifierState = new BOGO_1(BOGO)
    0.0
  }

  override def resetBogo() : Unit ={
    BOGO.ModifierState = new BOGO_1(BOGO)
  }

}
