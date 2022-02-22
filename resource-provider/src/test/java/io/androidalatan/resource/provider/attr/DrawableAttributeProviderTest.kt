package io.androidalatan.resource.provider.attr

import android.graphics.drawable.Drawable
import android.util.TypedValue
import androidx.core.content.ContextCompat
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@PrepareForTest(ContextCompat::class)
@RunWith(PowerMockRunner::class)
class DrawableAttributeProviderTest {

    @Test
    fun getValue() {

        PowerMockito.mockStatic(ContextCompat::class.java)

        val typedValue = mock<TypedValue>()
        val drawable = mock<Drawable>()
        PowerMockito.`when`(ContextCompat.getDrawable(any(), any()))
            .thenReturn(drawable)
        Assertions.assertEquals(drawable, DrawableAttributeProvider(typedValue, mock()).getValue())
    }
}