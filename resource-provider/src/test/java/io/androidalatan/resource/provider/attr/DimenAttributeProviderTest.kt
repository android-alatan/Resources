package io.androidalatan.resource.provider.attr

import android.content.Context
import android.content.res.Resources
import android.util.TypedValue
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import org.powermock.api.mockito.PowerMockito
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@PrepareForTest(TypedValue::class)
@RunWith(PowerMockRunner::class)
class DimenAttributeProviderTest {

    @Test
    fun getValue() {
        PowerMockito.mockStatic(TypedValue::class.java)
        val value = 10f
        PowerMockito.`when`(TypedValue.complexToDimension(any(), any()))
            .thenReturn(value)

        val typedValue = mock<TypedValue>()
        val context = mock<Context>()
        val resources = mock<Resources>()
        whenever(resources.displayMetrics).thenReturn(mock())
        whenever(context.resources).thenReturn(resources)
        Assertions.assertEquals(value, DimenAttributeProvider(typedValue, context).getValue())
    }
}