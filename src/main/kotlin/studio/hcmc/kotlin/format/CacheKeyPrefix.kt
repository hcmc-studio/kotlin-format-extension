package studio.hcmc.kotlin.format

import kotlin.reflect.KClass

object CacheKeyPrefix {
    fun <T : Any> convert(kClass: KClass<T>): String {
        return convert(kClass.simpleName ?: return "")
    }

    inline fun <reified T : Any> convert(): String {
        return convert(T::class)
    }

    fun convert(className: String): String {
        val builder = StringBuilder()
        for ((index, c) in className.removeSuffix("Id").withIndex()) {
            if (c.isUpperCase()) {
                if (index > 0) {
                    builder.append(':')
                }
                builder.append(c.lowercaseChar())
            } else {
                builder.append(c)
            }
        }

        builder.append(':').toString()

        return builder.toString()
    }
}