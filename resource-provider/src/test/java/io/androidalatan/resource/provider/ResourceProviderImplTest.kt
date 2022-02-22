package io.androidalatan.resource.provider

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.util.DisplayMetrics
import android.util.TypedValue
import androidx.core.content.ContextCompat
import androidx.core.os.ConfigurationCompat
import androidx.core.os.LocaleListCompat
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import java.util.Locale

@RunWith(PowerMockRunner::class)
@PrepareForTest(ContextCompat::class, ConfigurationCompat::class, TypedValue::class)
@Suppress("DEPRECATION")
class ResourceProviderImplTest {
    private lateinit var resourceProvider: ResourceProviderImpl

    @Mock
    lateinit var context: Context

    @Mock
    lateinit var resources: Resources

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        resourceProvider = ResourceProviderImpl(context)
        whenever(context.resources).thenReturn(resources)
    }

    @Test
    fun `getString id`() {
        val returnValue = "Hello"
        val id = 1
        whenever(resources.getString(id)).thenReturn(returnValue)

        Assertions.assertEquals(returnValue, resourceProvider.getString(id))
        Mockito.verify(resources)
            .getString(id)
    }

    @Test
    fun `getString with arg`() {
        val argString = "arg1"
        val returnString = "returnString"
        val id = 1
        whenever(resources.getString(id, argString)).thenReturn(returnString)

        Assertions.assertEquals(returnString, resourceProvider.getString(id, argString))
        Mockito.verify(resources)
            .getString(id, argString)
    }

    @Test
    fun getStringArray() {
        val id = 1
        val returnStrings = arrayOf("hello", "world")
        whenever(resources.getStringArray(id)).thenReturn(returnStrings)

        Assertions.assertEquals(returnStrings, resourceProvider.getStringArray(id))
        Mockito.verify(resources)
            .getStringArray(id)
    }

    @Test
    fun getQuantityString() {
        val id = 1
        val quantity = 2
        val argString = "arg1"
        val returnString = "returnString"
        whenever(resources.getQuantityString(id, quantity, argString)).thenReturn(returnString)

        Assertions.assertEquals(returnString, resourceProvider.getQuantityString(id, quantity, argString))
        Mockito.verify(resources)
            .getQuantityString(id, quantity, argString)

    }

    @Test
    fun getInt() {
        val id = 1
        val returnValue = 2
        whenever(resources.getInteger(id)).thenReturn(returnValue)

        Assertions.assertEquals(returnValue, resourceProvider.getInt(id))
        Mockito.verify(resources)
            .getInteger(id)
    }

    @Test
    fun getIntArray() {
        val id = 1
        val returnValue = intArrayOf(2, 3, 4)
        whenever(resources.getIntArray(id)).thenReturn(returnValue)

        Assertions.assertEquals(returnValue, resourceProvider.getIntArray(id))
        Mockito.verify(resources)
            .getIntArray(id)
    }

    @Test
    fun getColor() {
        val id = 1
        val returnValue = 2
        whenever(resources.getColor(id)).thenReturn(returnValue)

        Assertions.assertEquals(returnValue, resourceProvider.getColor(id))
        Mockito.verify(resources)
            .getColor(id)
    }

    @Test
    fun getColorStateList() {
        val id = 1
        val colorStateList = Mockito.mock(ColorStateList::class.java)
        whenever(resources.getColorStateList(id)).thenReturn(colorStateList)

        Assertions.assertEquals(colorStateList, resourceProvider.getColorStateList(id))
        Mockito.verify(resources)
            .getColorStateList(id)
    }

    @Test
    fun getDimension() {
        val id = 1
        val returnValue = 2f
        whenever(resources.getDimension(id)).thenReturn(returnValue)

        Assertions.assertEquals(returnValue, resourceProvider.getDimension(id))
        Mockito.verify(resources)
            .getDimension(id)
    }

    @Test
    fun getDimensionPixelOffset() {
        val id = 1
        val returnValue = 2
        whenever(resources.getDimensionPixelOffset(id)).thenReturn(returnValue)

        Assertions.assertEquals(returnValue, resourceProvider.getDimensionPixelOffset(id))
        Mockito.verify(resources)
            .getDimensionPixelOffset(id)
    }

    @Test
    fun getDimensionPixelSize() {
        val id = 1
        val returnValue = 2
        whenever(resources.getDimensionPixelSize(id)).thenReturn(returnValue)

        Assertions.assertEquals(returnValue, resourceProvider.getDimensionPixelSize(id))
        Mockito.verify(resources)
            .getDimensionPixelSize(id)

    }

    @Test
    fun getDrawable() {
        PowerMockito.mockStatic(ContextCompat::class.java)
        val id = 1
        val returnValue = Mockito.mock(Drawable::class.java)
        whenever(ContextCompat.getDrawable(context, id)).thenReturn(returnValue)

        Assertions.assertEquals(returnValue, resourceProvider.getDrawable(id))
        PowerMockito.verifyStatic(ContextCompat::class.java)
        ContextCompat.getDrawable(context, id)

    }

    @Test
    fun convertDpToPx() {
        val displayMetrics = mock<DisplayMetrics>()
        whenever(resources.displayMetrics).thenReturn(displayMetrics)

        PowerMockito.mockStatic(TypedValue::class.java)
        val dp = 10f
        val px = 13f
        whenever(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)).thenReturn(px)
        Assertions.assertEquals(px.toInt(), resourceProvider.convertDpToPx(dp))
    }

    @Test
    fun convertPxToDp() {
        val displayMetrics = mock<DisplayMetrics>()
        whenever(resources.displayMetrics).thenReturn(displayMetrics)

        PowerMockito.mockStatic(TypedValue::class.java)
        val dp = 10f
        val px = 13
        whenever(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, px.toFloat(), displayMetrics)).thenReturn(dp)
        Assertions.assertEquals(dp, resourceProvider.convertPxToDp(px))
    }

    @Test
    fun getScreenSize() {
        val displayMetrics = DisplayMetrics()
        val x = 10
        val y = 20
        displayMetrics.widthPixels = x
        displayMetrics.heightPixels = y
        whenever(resources.displayMetrics).thenReturn(displayMetrics)
        Assertions.assertEquals(x to y, resourceProvider.getScreenSize())
        Mockito.verify(resources).displayMetrics
    }

    @Test
    fun getDensityDpi() {
        val displayMetrics = DisplayMetrics()
        val density = 10
        displayMetrics.densityDpi = density
        whenever(resources.displayMetrics).thenReturn(displayMetrics)
        Assertions.assertEquals(density, resourceProvider.getDensityDpi())
        Mockito.verify(resources).displayMetrics
    }

    @Test
    fun getLocale() {
        val configuration = mock<Configuration>()
        whenever(resources.configuration).thenReturn(configuration)
        PowerMockito.mockStatic(ConfigurationCompat::class.java)
        whenever(ConfigurationCompat.getLocales(configuration)).thenReturn(LocaleListCompat.create(Locale.ENGLISH))

        Assertions.assertEquals(Locale.ENGLISH, resourceProvider.getLocale())
    }

    @Test
    fun `getLocale null`() {
        val configuration = mock<Configuration>()
        whenever(resources.configuration).thenReturn(configuration)
        PowerMockito.mockStatic(ConfigurationCompat::class.java)
        whenever(ConfigurationCompat.getLocales(configuration)).thenReturn(LocaleListCompat.create())

        Assertions.assertEquals(Locale.getDefault(), resourceProvider.getLocale())
    }
}