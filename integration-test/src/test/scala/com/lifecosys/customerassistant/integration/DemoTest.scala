package com.lifecosys.customerassistant.integration

import com.lifecosys.customerassistant.{ HelloService, SpringConfig }
import org.scalatest.{ BeforeAndAfterAll, FeatureSpec }
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.support.AnnotationConfigContextLoader
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.context.{ ContextConfiguration, TestContextManager }

/**
 *
 *
 * @author Young Gu
 * @version 1.0 7/25/13 1:05 PM
 */
@SpringApplicationConfiguration(classes = Array(classOf[SpringConfig]))
@WebAppConfiguration
class DemoTest extends FeatureSpec with BeforeAndAfterAll {

  val testContextManager = new TestContextManager(this.getClass())

  @Autowired
  val helloService: HelloService = null

  override protected def beforeAll() {
    testContextManager.prepareTestInstance(this)
    testContextManager.beforeTestClass()
  }

  override protected def afterAll() {
    testContextManager.afterTestClass()
  }

  feature("Demo server") {
    scenario(" should say hello") {
      val data = "Hello"
      assert(data === helloService.sayHello)
    }
  }

}
