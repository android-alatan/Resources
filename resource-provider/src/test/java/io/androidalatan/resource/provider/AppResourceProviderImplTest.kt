package io.androidalatan.resource.provider

import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import io.androidalatan.resource.provider.api.ResourceProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.any
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import java.util.Locale

class AppResourceProviderImplTest {

    private val originResourceProvider = Mockito.mock(ResourceProvider::class.java)
    private val appResourceProvider = AppResourceProviderImpl(originResourceProvider)

    @Test
    fun convertDpToPx() {
        val dp = 1f
        val px = 2
        whenever(originResourceProvider.convertDpToPx(dp)).thenReturn(px)
        Assertions.assertEquals(px, appResourceProvider.convertDpToPx(dp))
        Mockito.verify(originResourceProvider)
            .convertDpToPx(dp)
    }

    @Test
    fun convertPxToDp() {
        val dp = 1f
        val px = 2
        whenever(originResourceProvider.convertPxToDp(px)).thenReturn(dp)
        Assertions.assertEquals(dp, appResourceProvider.convertPxToDp(px))
        Mockito.verify(originResourceProvider)
            .convertPxToDp(px)
    }

    @Test
    fun getActionBarHeight() {
        val height = 10
        whenever(originResourceProvider.getActionBarHeight()).thenReturn(height)
        Assertions.assertEquals(height, appResourceProvider.getActionBarHeight())
        Mockito.verify(originResourceProvider)
            .getActionBarHeight()
    }

    @Test
    fun getColor() {
        val color = 10
        val id = 1
        whenever(originResourceProvider.getColor(id)).thenReturn(color)
        Assertions.assertEquals(color, appResourceProvider.getColor(id))
        Mockito.verify(originResourceProvider)
            .getColor(id)
    }

    @Test
    fun getColorStateList() {
        val id = 1
        val colorStateList = Mockito.mock(ColorStateList::class.java)
        whenever(originResourceProvider.getColorStateList(id)).thenReturn(colorStateList)
        Assertions.assertEquals(colorStateList, appResourceProvider.getColorStateList(id))
        Mockito.verify(originResourceProvider)
            .getColorStateList(id)
    }

    @Test
    fun getDensityDpi() {
        val density = 10
        whenever(originResourceProvider.getDensityDpi()).thenReturn(density)
        Assertions.assertEquals(density, appResourceProvider.getDensityDpi())
        Mockito.verify(originResourceProvider)
            .getDensityDpi()
    }

    @Test
    fun getDimension() {
        val dimension = 10f
        val id = 1
        whenever(originResourceProvider.getDimension(id)).thenReturn(dimension)
        Assertions.assertEquals(dimension, appResourceProvider.getDimension(id))
        Mockito.verify(originResourceProvider)
            .getDimension(id)
    }

    @Test
    fun getDimensionPixelOffset() {
        val px = 10
        val id = 1
        whenever(originResourceProvider.getDimensionPixelOffset(id)).thenReturn(px)
        Assertions.assertEquals(px, appResourceProvider.getDimensionPixelOffset(id))
        Mockito.verify(originResourceProvider)
            .getDimensionPixelOffset(id)
    }

    @Test
    fun getDimensionPixelSize() {
        val px = 10
        val id = 1
        whenever(originResourceProvider.getDimensionPixelSize(id)).thenReturn(px)
        Assertions.assertEquals(px, appResourceProvider.getDimensionPixelSize(id))
        Mockito.verify(originResourceProvider)
            .getDimensionPixelSize(id)
    }

    @Test
    fun getDrawable() {
        val drawable = Mockito.mock(Drawable::class.java)
        val id = 1
        whenever(originResourceProvider.getDrawable(id)).thenReturn(drawable)
        Assertions.assertEquals(drawable, appResourceProvider.getDrawable(id))
        Mockito.verify(originResourceProvider)
            .getDrawable(id)
    }

    @Test
    fun getInt() {
        val intValue = 10
        val id = 1
        whenever(originResourceProvider.getInt(id)).thenReturn(intValue)
        Assertions.assertEquals(intValue, appResourceProvider.getInt(id))
        Mockito.verify(originResourceProvider)
            .getInt(id)
    }

    @Test
    fun getIntArray() {
        val intArray = intArrayOf(1)
        whenever(originResourceProvider.getIntArray(1)).thenReturn(intArray)
        Assertions.assertEquals(intArray, appResourceProvider.getIntArray(1))
        Mockito.verify(originResourceProvider)
            .getIntArray(1)
    }

    @Test
    fun getLocale() {
        val locale = Locale.ENGLISH
        whenever(originResourceProvider.getLocale()).thenReturn(locale)
        Assertions.assertEquals(locale, appResourceProvider.getLocale())
        Mockito.verify(originResourceProvider)
            .getLocale()
    }

    @Test
    fun getQuantityString() {
        val stringValue = "10"
        val id = 1
        val quantity = 2
        val args = 3
        whenever(originResourceProvider.getQuantityString(id, quantity, args)).thenReturn(stringValue)
        Assertions.assertEquals(stringValue, appResourceProvider.getQuantityString(id, quantity, args))
        Mockito.verify(originResourceProvider)
            .getQuantityString(id, quantity, args)
    }

    @Test
    fun getScreenSize() {
        val screenSize = 10 to 20
        whenever(originResourceProvider.getScreenSize()).thenReturn(screenSize)
        Assertions.assertEquals(screenSize, appResourceProvider.getScreenSize())
        Mockito.verify(originResourceProvider)
            .getScreenSize()
    }

    @Test
    fun getString() {
        val stringValue = "10"
        val id = 1
        whenever(originResourceProvider.getString(id)).thenReturn(stringValue)
        Assertions.assertEquals(stringValue, appResourceProvider.getString(id))
        Mockito.verify(originResourceProvider)
            .getString(id)
    }

    @Test
    fun `getString with arg`() {
        val stringValue = "10"
        val id = 1
        val args = 2
        whenever(originResourceProvider.getString(id, args)).thenReturn(stringValue)
        Assertions.assertEquals(stringValue, appResourceProvider.getString(id, args))
        Mockito.verify(originResourceProvider)
            .getString(id, args)
    }

    @Test
    fun getStringArray() {
        val stringValue = arrayOf("10")
        val id = 1
        whenever(originResourceProvider.getStringArray(id)).thenReturn(stringValue)
        Assertions.assertEquals(stringValue, appResourceProvider.getStringArray(id))
        Mockito.verify(originResourceProvider)
            .getStringArray(id)
    }

    @Test
    fun getAttributeValue() {
        val attrValue = 10
        whenever(originResourceProvider.getAttributeValue<Any>(any(), any())).thenReturn(attrValue)
        Assertions.assertEquals(attrValue, appResourceProvider.getAttributeValue(1, 2))
        verify(originResourceProvider).getAttributeValue(1, 2)
    }
}