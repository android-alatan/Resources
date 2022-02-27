package io.androidalatan.resource.provider.attr

import android.content.Context
import android.util.TypedValue
import io.androidalatan.resource.provider.api.attr.AttributeProvider

internal class DimenAttributeProvider(
    private val typedValue: TypedValue,
    private val context: Context
) : AttributeProvider<Float> {
    override fun getValue(): Float {
        return TypedValue.complexToDimension(typedValue.data, context.resources.displayMetrics)
    }
}