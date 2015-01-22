package com.lifecosys.customerassistant

import org.springframework.boot.SpringApplication

object DemoApplication {
  def main(args: Array[String]) {
    SpringApplication.run(classOf[com.lifecosys.customerassistant.SpringConfig], args: _*)
  }
}

