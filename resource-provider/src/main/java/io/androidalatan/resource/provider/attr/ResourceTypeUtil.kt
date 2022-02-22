package io.androidalatan.resource.provider.attr

internal object ResourceTypeUtil {
    fun toType(typeName: String): ResourceType {
        return when (typeName) {
            "string" -> ResourceType.STRING
            "array" -> ResourceType.ARRAY
            "anim" -> ResourceType.ANIM
            "animator" -> ResourceType.ANIMATOR
            "integer" -> ResourceType.INTEGER
            "dimen" -> ResourceType.DIMEN
            "color" -> ResourceType.COLOR
            "plurals" -> ResourceType.PLURALS
            "attr" -> ResourceType.ATTR
            "font" -> ResourceType.FONT
            "menu" -> ResourceType.MENU
            "raw" -> ResourceType.RAW
            "style" -> ResourceType.STYLE
            "mipmap" -> ResourceType.MIPMAP
            "xml" -> ResourceType.XML
            "layout" -> ResourceType.LAYOUT
            "drawable" -> ResourceType.DRAWABLE
            "styleable" -> ResourceType.STYLEABLE
            "bool" -> ResourceType.BOOL
            else -> ResourceType.UNKNOWN
        }
    }
}