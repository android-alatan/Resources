package io.androidalatan.resource.provider.attr

import android.util.TypedValue
import io.androidalatan.resource.provider.api.attr.AttributeProvider

internal class IntAttributeProvider(
    private val typedValue: TypedValue,
) : AttributeProvider<Int> {
    override fun getValue(): Int = typedValue.data
}