package com.lifecosys.customerassistant

import org.springframework.boot.SpringApplication

object Application {
  def main(args: Array[String]) {
    val context = SpringApplication.run(classOf[com.lifecosys.customerassistant.SpringConfig], args: _*)

    val hello: String = context.getBean(classOf[HelloService]).sayHello
    println(hello)

  }
}

