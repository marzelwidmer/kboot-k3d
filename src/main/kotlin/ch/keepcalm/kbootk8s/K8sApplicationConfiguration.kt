package ch.keepcalm.kbootk8s

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "application")
data class K8sApplicationConfiguration(val config: String = "NO-CONFIG")
