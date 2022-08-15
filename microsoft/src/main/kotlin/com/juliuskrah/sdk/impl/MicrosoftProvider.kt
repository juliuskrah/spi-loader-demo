package com.juliuskrah.sdk.impl

import com.juliuskrah.sdk.CloudProvider

/**
 * The Microsoft Azure implementation of the {@link CloudProvider} SPI
 * @author Julius Krah
 */
class MicrosoftProvider: CloudProvider {
    /**
     * {@inheritDoc}
     */
    override fun forType(): CloudProvider.Type = CloudProvider.Type.AZURE
}