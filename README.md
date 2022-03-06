[![Main Commit](https://github.com/android-alatan/Resources/actions/workflows/lib-main-branch.yml/badge.svg?branch=main)](https://github.com/android-alatan/Resources/actions/workflows/lib-main-branch.yml)
[![Release](https://jitpack.io/v/android-alatan/resources.svg)](https://jitpack.io/#android-alatan/resources)
# Resources

This is Context wrapped resource provider. Additionally, This includes a package to be testable.

## Installation
```kotlin
implementation("com.github.android-alatan.resources:resource-provider:$version")
implementation("com.github.android-alatan.resources:resource-provider-api:$version")

testImplementation("com.github.android-alatan.resources:resource-provider-assertion:$version")
```

## Example
```kotlin
// in production code
class FooActivity {
  private val fooViewModel = FooViewModel(ResourceProviderImpl(this))
}
class FooViewModel(private val resourceProvider: ResourceProvider) {
  val appName = resourceProvider.getString(R.id.app_name)
}

// in test code
class FooViewModelTest {

  @Test
  fun myTest() {
    val viewModel = FooViewModel(MockResourceProvider())
    Assertions.assertEqual("${R.id.app_name}", viewModel.appName)
  }
}
```
Please note that most resource from ResourceProvider will be wrapped resource-id while testing.