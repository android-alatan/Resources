package io.androidalatan.resource.provider.attr

import android.util.TypedValue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class ColorAttributeProviderTest {

    @Test
    fun getValue() {
        val typedValue = mock<TypedValue>()
        val value = 10
        typedValue.data = value
        Assertions.assertEquals(
            value, ColorAttributeProvider(typedValue)
                .getValue()
        )
    }
}