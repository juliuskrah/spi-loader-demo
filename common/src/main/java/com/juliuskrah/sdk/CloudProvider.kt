package com.juliuskrah.sdk

/**
 * The Service Provider Interface of a Cloud Provider. A cloud provider in this sense is one of
 * <ol>
 *     <li>AWS</li>
 *     <li>Google Cloud</li>
 *     <li>Azure</li>
 * </ol>
 *
 * @author Julius Krah
 */
interface CloudProvider {

    /**
     * Identifies the type of cloud
     * @return Type the cloud provider type
     */
    fun forType(): Type

    enum class Type {
        GOOGLE, AZURE, AWS, ALIBABA, ORACLE
    }
}