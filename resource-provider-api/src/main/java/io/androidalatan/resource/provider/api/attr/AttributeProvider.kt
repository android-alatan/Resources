package io.androidalatan.resource.provider.api.attr

interface AttributeProvider<Value> {
    fun getValue(): Value
}