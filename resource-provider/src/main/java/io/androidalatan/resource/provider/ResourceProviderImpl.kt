package io.androidalatan.resource.provider

import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.core.content.ContextCompat
import androidx.core.os.ConfigurationCompat
import io.androidalatan.resource.provider.api.ResourceProvider
import io.androidalatan.resource.provider.attr.ColorAttributeProvider
import io.androidalatan.resource.provider.attr.ColorStateListAttributeProvider
import io.androidalatan.resource.provider.attr.DimenAttributeProvider
import io.androidalatan.resource.provider.attr.DrawableAttributeProvider
import io.androidalatan.resource.provider.attr.IntAttributeProvider
import io.androidalatan.resource.provider.attr.ResourceType
import io.androidalatan.resource.provider.attr.ResourceTypeUtil
import io.androidalatan.resource.provider.attr.StringArrayAttributeProvider
import io.androidalatan.resource.provider.attr.StringAttributeProvider
import java.util.Locale

class ResourceProviderImpl(private val context: Context) : ResourceProvider {

    private val resources by lazy { context.resources }

    override fun getString(id: Int) = resources.getString(id)
    override fun getString(id: Int, vararg args: Any) = resources.getString(id, *args)
    override fun getStringArray(id: Int): Array<String> = resources.getStringArray(id)
    override fun getQuantityString(id: Int, quantity: Int, vararg args: Any) = resources.getQuantityString(id, quantity, *args)

    override fun getInt(id: Int) = resources.getInteger(id)
    override fun getIntArray(id: Int) = resources.getIntArray(id)

    @Suppress("DEPRECATION")
    override fun getColor(id: Int): Int {
        return if (Build.VERSION.SDK_INT >= 23) {
            context.getColor(id)
        } else {
            resources.getColor(id)
        }
    }

    override fun getColorStateList(id: Int): ColorStateList? = ContextCompat.getColorStateList(context, id)

    override fun getDimension(id: Int) = resources.getDimension(id)

    override fun getDimensionPixelOffset(id: Int) = resources.getDimensionPixelOffset(id)

    override fun getDimensionPixelSize(id: Int) = resources.getDimensionPixelSize(id)

    override fun getDrawable(id: Int) = ContextCompat.getDrawable(context, id)

    override fun convertDpToPx(dp: Float) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
        .toInt()

    // FIX this is wrong logic
    override fun convertPxToDp(px: Int) = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px.toFloat(), resources.displayMetrics)

    override fun getActionBarHeight(): Int {
        return getAttributeValue(android.R.attr.actionBarSize, 0)
    }

    override fun getScreenSize(): Pair<Int, Int> {
        return resources.displayMetrics.let { it.widthPixels to it.heightPixels }
    }

    override fun getDensityDpi(): Int {
        return resources.displayMetrics.densityDpi
    }

    override fun getLocale(): Locale {
        return ConfigurationCompat.getLocales(resources.configuration)
            .takeIf { !it.isEmpty }
            ?.get(0) ?: Locale.getDefault()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <ValueType> getAttributeValue(@AttrRes attrId: Int, defaultValue: ValueType): ValueType {
        val typedValue = TypedValue()
        context.theme.resolveAttribute(attrId, typedValue, true)
        val type = typedValue.type

        return when (type) {
            in TypedValue.TYPE_FIRST_COLOR_INT..TypedValue.TYPE_LAST_COLOR_INT -> ColorAttributeProvider(typedValue)
            in TypedValue.TYPE_FIRST_INT..TypedValue.TYPE_LAST_INT -> IntAttributeProvider(typedValue)
            TypedValue.TYPE_DIMENSION -> DimenAttributeProvider(typedValue, context)
            TypedValue.TYPE_NULL, TypedValue.TYPE_ATTRIBUTE -> null
            else -> {
                if (typedValue.resourceId != 0) {
                    when (ResourceTypeUtil.toType(resources.getResourceTypeName(typedValue.resourceId))) {
                        ResourceType.DRAWABLE -> DrawableAttributeProvider(typedValue, context)
                        ResourceType.STRING -> StringAttributeProvider(typedValue)
                        ResourceType.ARRAY -> StringArrayAttributeProvider(typedValue, resources)
                        ResourceType.COLOR -> ColorStateListAttributeProvider(typedValue, context)
                        else -> null
                    }
                } else {
                    null
                }
            }
        }?.let {
            it.getValue() as ValueType
        } ?: defaultValue

    }
}