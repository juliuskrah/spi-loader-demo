package com.juliuskrah

import com.juliuskrah.sdk.LoadingUtilities
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Configuration class that loads SPI implementation and logs them
 *
 * @author Julius Krah
 */
@Configuration(proxyBeanMethods = false)
class Initializer {
    private val log: Logger = LoggerFactory.getLogger(Initializer::class.java)

    @Bean
    fun load(): ApplicationRunner {
        return ApplicationRunner {
            log.info("All implementations ${LoadingUtilities.allBeanDefinitions().contentToString()}")
            log.info("Microsoft Azure ${LoadingUtilities.retrieveCloudProvider("azure")?.forType()}")
            log.info("All providers ${LoadingUtilities.allImplementations()}")
            log.info("All provides as map ${LoadingUtilities.allImplementationsAsMap()}")
        }
    }
}