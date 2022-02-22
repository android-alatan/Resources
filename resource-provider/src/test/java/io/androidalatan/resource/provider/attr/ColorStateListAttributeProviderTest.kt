package io.androidalatan.resource.provider.attr

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.util.TypedValue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class ColorStateListAttributeProviderTest {

    @Test
    fun getValue() {
        val id = 1
        val colorStateList = Mockito.mock(ColorStateList::class.java)
        val context = mock<Context>()
        val resources = mock<Resources>()
        whenever(context.resources).thenReturn(resources)
        whenever(resources.getColorStateList(id)).thenReturn(colorStateList)
        whenever(context.getColorStateList(id)).thenReturn(colorStateList)

        val typedValue = mock<TypedValue>()
        typedValue.resourceId = id
        Assertions.assertEquals(colorStateList, ColorStateListAttributeProvider(typedValue, context).getValue())
    }
}