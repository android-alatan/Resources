package io.androidalatan.resource.provider.attr

import android.content.res.Resources
import android.util.TypedValue
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

class StringArrayAttributeProviderTest {

    @Test
    fun getValue() {
        val resources = mock<Resources>()
        val typedValue = mock<TypedValue>()

        val arrayValue = arrayOf("1", "2")
        whenever(resources.getStringArray(any())).thenReturn(arrayValue)

        Assertions.assertEquals(
            arrayValue, StringArrayAttributeProvider(typedValue, resources)
                .getValue()
        )
    }
}