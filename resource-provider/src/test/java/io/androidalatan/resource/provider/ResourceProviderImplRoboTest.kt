package io.androidalatan.resource.provider

import android.R
import android.content.Context
import android.content.res.ColorStateList
import android.os.Build
import androidx.test.core.app.ApplicationProvider
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O])
@RunWith(RobolectricTestRunner::class)
class ResourceProviderImplRoboTest {
    private val context = ApplicationProvider.getApplicationContext<Context>()

    private val resourceProvider = ResourceProviderImpl(context)

    @Test
    fun getAttributeValue() {
        Assertions.assertTrue(resourceProvider.getAttributeValue(R.attr.colorPrimary, 0) != 0)
        Assertions.assertNotNull(resourceProvider.getAttributeValue<ColorStateList?>(R.attr.textColorPrimary, null))
    }

    @Test
    fun getActionBarHeight() {
        Assertions.assertTrue(resourceProvider.getAttributeValue(R.attr.actionBarSize, 0) != 0)
    }

}