package io.androidalatan.resource.provider.attr

import android.util.TypedValue
import io.androidalatan.resource.provider.api.attr.AttributeProvider

internal class StringAttributeProvider(
    private val typedValue: TypedValue,
) : AttributeProvider<String> {
    override fun getValue(): String = typedValue.string?.toString() ?: ""
}