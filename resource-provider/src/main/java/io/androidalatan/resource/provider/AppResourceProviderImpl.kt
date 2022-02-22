package io.androidalatan.resource.provider

import io.androidalatan.resource.provider.api.AppResourceProvider
import io.androidalatan.resource.provider.api.ResourceProvider

class AppResourceProviderImpl(
    private val resourceProvider: ResourceProvider
) : AppResourceProvider,
    ResourceProvider by resourceProvider