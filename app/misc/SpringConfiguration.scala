package misc

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Bean

@Configuration
class SpringConfiguration {

	@Bean
	def application: controllers.Application = new controllers.Application

}