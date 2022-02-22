package io.androidalatan.resource.provider.assertion

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import androidx.annotation.VisibleForTesting
import io.androidalatan.resource.provider.api.AppResourceProvider
import io.androidalatan.resource.provider.api.ResourceProvider
import org.mockito.Mockito
import java.util.Locale

class MockResourceProvider : ResourceProvider {

    @VisibleForTesting
    val drawableMap = hashMapOf<Int, Drawable>()

    override fun getString(id: Int): String {
        return "$id"
    }

    override fun getString(id: Int, vararg args: Any): String {
        return "$id"
    }

    override fun getStringArray(id: Int): Array<String> {
        return (0..100).map { "${id + it}" }
            .toTypedArray()
    }

    override fun getQuantityString(id: Int, quantity: Int, vararg args: Any): String {
        return "$id"
    }

    override fun getInt(id: Int): Int {
        return id
    }

    override fun getIntArray(id: Int): IntArray {
        return (0..100).map { id + it }
            .toIntArray()
    }

    override fun getColor(id: Int): Int {
        return id
    }

    override fun getColorStateList(id: Int): ColorStateList? {
        TODO()
    }

    override fun getDimension(id: Int): Float {
        return id.toFloat()
    }

    override fun getDimensionPixelOffset(id: Int): Int {
        return id
    }

    override fun getDimensionPixelSize(id: Int): Int {
        return id
    }

    override fun getDrawable(id: Int): Drawable? {
        return drawableMap.getOrPut(id) { Mockito.mock(Drawable::class.java) }
    }

    override fun convertDpToPx(dp: Float): Int {
        return dp.toInt()
    }

    override fun convertPxToDp(px: Int): Float {
        return px.toFloat()
    }

    override fun getActionBarHeight(): Int {
        return ACTION_BAR_HEIGHT
    }

    override fun getScreenSize(): Pair<Int, Int> {
        return SCREEN_SIZE
    }

    override fun getDensityDpi(): Int {
        return DENSITY
    }

    override fun getLocale(): Locale {
        return Locale.getDefault()
    }

    @SuppressLint("ResourceType")
    @Suppress("UNCHECKED_CAST", "IMPLICIT_CAST_TO_ANY")
    override fun <ValueType> getAttributeValue(attrId: Int, defaultValue: ValueType): ValueType {
        return when (defaultValue) {
            is String -> "$attrId"
            is Int -> attrId
            is Float -> attrId.toFloat()
            is Drawable -> getDrawable(attrId)
            is Array<*> -> getStringArray(attrId)
            is ColorStateList -> TODO()
            else -> null
        } as ValueType
    }

    companion object {
        // these are generated randomly
        const val ACTION_BAR_HEIGHT = 123
        val SCREEN_SIZE = 200 to 300
        const val DENSITY = 321

    }
}

class MockAppResourceProvider : AppResourceProvider, ResourceProvider by MockResourceProvider()