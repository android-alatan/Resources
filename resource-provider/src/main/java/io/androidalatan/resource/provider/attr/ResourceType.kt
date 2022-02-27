package io.androidalatan.resource.provider.attr

internal sealed class ResourceType {
    object UNKNOWN : ResourceType()
    object LAYOUT : ResourceType()
    object DRAWABLE : ResourceType()
    object STRING : ResourceType()
    object ARRAY : ResourceType()
    object ANIM : ResourceType()
    object ANIMATOR : ResourceType()
    object INTEGER : ResourceType()
    object DIMEN : ResourceType()
    object COLOR : ResourceType()
    object PLURALS : ResourceType()
    object ATTR : ResourceType()
    object FONT : ResourceType()
    object MENU : ResourceType()
    object RAW : ResourceType()
    object STYLE : ResourceType()
    object MIPMAP : ResourceType()
    object XML : ResourceType()
    object STYLEABLE : ResourceType()
    object BOOL : ResourceType()
}