package io.androidalatan.resource.provider.attr

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.TypedValue
import androidx.core.content.ContextCompat
import io.androidalatan.resource.provider.api.attr.AttributeProvider

internal class DrawableAttributeProvider(
    private val typedValue: TypedValue,
    private val context: Context
) : AttributeProvider<Drawable?> {
    override fun getValue(): Drawable? {
        return ContextCompat.getDrawable(context, typedValue.resourceId)
    }
}