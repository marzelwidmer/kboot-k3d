package ch.keepcalm.kbootk8s

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class K8sRestController(private val k8sApplicationConfiguration: K8sApplicationConfiguration) {

  @GetMapping("/api/application/config")
  fun appConfig(): String = "Application Config: ${k8sApplicationConfiguration.config}"
}
