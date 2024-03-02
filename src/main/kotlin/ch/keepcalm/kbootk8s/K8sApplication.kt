package ch.keepcalm.kbootk8s

import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.context.support.beans
import org.springframework.core.env.Environment

@SpringBootApplication
@EnableConfigurationProperties(K8sApplicationConfiguration::class)
class K8sApplication

fun main(args: Array<String>) {
  runApplication<K8sApplication>(*args) {
    addInitializers(
        beans {
          bean {
            val env = ref<Environment>()
            val configuration = ref<K8sApplicationConfiguration>()
            ApplicationRunner {
              println("-----------------> ApplicationRunner <-----------------")
              println("-----------------> ${configuration.config} <-----------------")
            }
          }
        })
  }
}
