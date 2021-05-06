package store.model.items

abstract class Modifier {
  def updatePrice (price: Double): Double

  def computeTax (price: Double): Double

  def loyalty(price: Double) : Double

  def resetBogo() : Unit

}
