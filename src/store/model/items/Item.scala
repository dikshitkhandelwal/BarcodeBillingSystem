package store.model.items
import store.model.items.Modifier

class Item (var des: String, var amount: Double){

  var scan: Int = 0

  var ls: List[Modifier] = List()

  def price(): Double ={
    var sum = amount
    for (n <- ls){
      sum = n.updatePrice(sum)
    }
    sum
  }

  def description (): String={
    this.des
  }

  def scanned (): Unit={
    this.scan += 1
  }

  def timesScanned (): Int ={
    this.scan
  }

  def addModifier(input: Modifier): Unit ={
      ls = ls :+ input
  }

  def tax (): Double ={

    val summ = this.price()
    var tax = 0.0
    for (n <- ls){
      val a = n.computeTax(summ)
      tax = tax + a
    }
    tax
  }





  def loyaltyprice(): Double ={
    var sum = amount
    for (n <- ls){
      sum = n.loyalty(sum)
    }
    sum
  }

  def loyaltytax (): Double ={

    val summ = this.loyaltyprice()
    var tax = 0.0
    for (n <- ls){
      val a = n.computeTax(summ)
      tax = tax + a
    }
    tax
  }

}

