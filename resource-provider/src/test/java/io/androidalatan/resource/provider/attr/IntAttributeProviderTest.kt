package io.androidalatan.resource.provider.attr

import android.util.TypedValue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.kotlin.mock

class IntAttributeProviderTest {

    @Test
    fun getValue() {
        val typedValue = mock<TypedValue>()
        val intValue = 10
        typedValue.data = intValue
        Assertions.assertEquals(intValue, IntAttributeProvider(typedValue).getValue())
    }
}