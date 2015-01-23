package com.lifecosys.customerassistant

import org.scalatest.FunSuite

/**
 *
 *
 * @author Young Gu
 * @version 1.0 1/23/15 2:23 PM
 */
class HelloServiceTest extends FunSuite {
  test("Say Hello") {
    assert("Hello" === new HelloService().sayHello)
  }
}
