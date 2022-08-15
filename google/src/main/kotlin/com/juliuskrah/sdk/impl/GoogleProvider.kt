package com.juliuskrah.sdk.impl

import com.juliuskrah.sdk.CloudProvider

/**
 * The Google Cloud implementation of the {@link CloudProvider} SPI
 * @author Julius Krah
 */
class GoogleProvider: CloudProvider {
    /**
     * {@inheritDoc}
     */
    override fun forType(): CloudProvider.Type = CloudProvider.Type.GOOGLE
}