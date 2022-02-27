package io.androidalatan.resource.provider.attr

import android.content.Context
import android.content.res.ColorStateList
import android.util.TypedValue
import androidx.core.content.ContextCompat
import io.androidalatan.resource.provider.api.attr.AttributeProvider

internal class ColorStateListAttributeProvider(
    private val typedValue: TypedValue,
    private val context: Context
) : AttributeProvider<ColorStateList?> {
    override fun getValue(): ColorStateList? = ContextCompat.getColorStateList(context, typedValue.resourceId)

}