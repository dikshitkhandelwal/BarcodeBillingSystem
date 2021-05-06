package tests

import org.scalatest.FunSuite
import store.model.items.Item

class LectureTask1 extends FunSuite {

  def compareDoubles(d1: Double , d2: Double): Boolean = {
    val e = 0.001
    Math.abs(d1-d2) < e
  }

  test("your test name") {

    var test1 : Item = new Item("First", 20.0)
    var test2 : Item = new Item("second", 30.0)


    assert(compareDoubles(test1.price(),20.000188) , "first")
    assert(compareDoubles(test2.price(),30.000018873), "second")
    assert(test1.description() == "First", "description")

    assert(test1.timesScanned() == 0, "Scan")
    assert(test2.timesScanned() == 0, "Scan")

    test1.scanned()
    test1.scanned()
    test1.scanned()
    test2.scanned()
    test2.scanned()
    test2.scanned()
    assert(test1.timesScanned() == 3, "Scan")
    assert(test1.timesScanned() == 3, "Scan")



  }

}
