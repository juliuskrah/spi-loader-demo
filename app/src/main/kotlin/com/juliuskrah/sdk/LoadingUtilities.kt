package com.juliuskrah.sdk

import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.support.BeanDefinitionRegistry
import org.springframework.beans.factory.support.SimpleBeanDefinitionRegistry
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner
import org.springframework.core.type.filter.AssignableTypeFilter
import org.springframework.core.type.filter.TypeFilter
import java.util.*

/**
 * Loads all implementations of an interface
 * @see <a href="https://stackoverflow.com/a/8166959/6157880">This answer</a>
 *
 * @author Julius Krah
 */
class LoadingUtilities private constructor() {
    companion object {
        private val bdr: BeanDefinitionRegistry = SimpleBeanDefinitionRegistry()
        private val s: ClassPathBeanDefinitionScanner = ClassPathBeanDefinitionScanner(bdr)
        private val tf: TypeFilter = AssignableTypeFilter(CloudProvider::class.java)

        private val loader = ServiceLoader.load(CloudProvider::class.java)

        init {
            s.addIncludeFilter(tf)
            s.setIncludeAnnotationConfig(false)
            s.scan("com.juliuskrah.sdk.impl", "com.juliuskrah.sdk")
        }

        /**
         * Loads all bean definition names. Discovers implementations of the {@link CloudProvider} SPI
         * on the classpath
         */
        fun allBeanDefinitions(): Array<String> = bdr.beanDefinitionNames

        /**
         * Loads the implementations of the {@link CloudProvider} SPI on the classpath as Key/Value pairs
         */
        fun allImplementationsAsMap(): Map<String, CloudProvider> =
            loader.associateBy(
                { it.javaClass.simpleName }, { it }
            )

        /**
         * Detects and returns all implementations of the {@link CloudProvider} SPI available
         * on the classpath
         */
        fun allImplementations() = loader.toList()

        /**
         * Loads the BeanDefinition for the provided bean name
         * @param beanName the name of the bean to find
         * @return BeanDefinition the bean defintion or {@literal null}
         */
        fun retrieveBeanByName(beanName: String): BeanDefinition = bdr.getBeanDefinition(beanName)

        /**
         * Find a given cloud provider using the ENUM name
         *
         * @param providerName the provider to search by name
         * @throws NoSuchElementException when no implementation can be found with the given name
         * @return CloudProvider the cloud provider with the given provider name
         */
        fun retrieveCloudProvider(providerName: String): CloudProvider? =
//            loader.find { CloudProvider.Type.valueOf(providerName.uppercase()) == it.forType() }
            loader.stream()
                .filter { CloudProvider.Type.valueOf(providerName.uppercase()) == it.get().forType() }
                .map(ServiceLoader.Provider<CloudProvider>::get)
                .findFirst().orElseThrow()

    }

}