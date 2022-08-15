package com.juliuskrah.sdk.impl

import com.juliuskrah.sdk.CloudProvider

/**
 * The AWS implementation of the {@link CloudProvider} SPI
 * @author Julius Krah
 */
class AmazonProvider: CloudProvider {

    /**
     * {@inheritDoc}
     */
    override fun forType(): CloudProvider.Type = CloudProvider.Type.AWS
}