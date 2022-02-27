package io.androidalatan.resource.provider.api

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import androidx.annotation.ArrayRes
import androidx.annotation.AttrRes
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import java.util.Locale

interface ResourceProvider {
    fun getString(@StringRes id: Int): String
    fun getString(@StringRes id: Int, vararg args: Any): String
    fun getStringArray(@ArrayRes id: Int): Array<String>
    fun getQuantityString(@PluralsRes id: Int, quantity: Int, vararg args: Any): String
    fun getInt(@IntegerRes id: Int): Int
    fun getIntArray(@ArrayRes id: Int): IntArray
    fun getColor(@ColorRes id: Int): Int
    fun getColorStateList(@ColorRes id: Int): ColorStateList?
    fun getDimension(@DimenRes id: Int): Float
    fun getDimensionPixelOffset(@DimenRes id: Int): Int
    fun getDimensionPixelSize(@DimenRes id: Int): Int
    fun getDrawable(@DrawableRes id: Int): Drawable?
    fun convertDpToPx(dp: Float): Int
    fun convertPxToDp(px: Int): Float
    fun getActionBarHeight(): Int
    fun getScreenSize(): Pair<Int, Int>
    fun getDensityDpi(): Int

    fun getLocale(): Locale

    fun <ValueType> getAttributeValue(@AttrRes attrId: Int, defaultValue: ValueType): ValueType
}