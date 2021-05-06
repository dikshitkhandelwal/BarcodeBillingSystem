package store.model.items

import store.model.items.Sale

class SaleTestingItem (var des: String, var pricce: Double){

  var ls : List[Sale] = List()
  def addSale(ref: Sale): Unit ={
    ls = ls :+ ref
  }

  def price(): Double = {

    var nor = pricce
    for (num <- ls) {
      nor = num.updatePrice(nor)
    }
  nor
  }
}
