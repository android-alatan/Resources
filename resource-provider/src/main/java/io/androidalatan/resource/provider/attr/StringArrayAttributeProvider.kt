package io.androidalatan.resource.provider.attr

import android.content.res.Resources
import android.util.TypedValue
import io.androidalatan.resource.provider.api.attr.AttributeProvider

internal class StringArrayAttributeProvider(
    private val typedValue: TypedValue,
    private val resources: Resources
) : AttributeProvider<Array<String>> {
    override fun getValue(): Array<String> {
        return resources.getStringArray(typedValue.resourceId)
    }
}