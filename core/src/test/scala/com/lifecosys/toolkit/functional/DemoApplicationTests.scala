package demo

import com.lifecosys.customerassistant.SpringConfig
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.test.context.web.WebAppConfiguration

@RunWith(classOf[SpringJUnit4ClassRunner])
@SpringApplicationConfiguration(classes = Array(classOf[SpringConfig]))
@WebAppConfiguration class DemoApplicationTests {

  @Test def contextLoads {
  }
}
