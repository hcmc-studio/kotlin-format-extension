package studio.hcmc.kotlin.format

sealed interface NamingStrategy {
    fun convert(from: String): String

    object SnakeCase : NamingStrategy {
        override fun convert(from: String): String {
            return from.split("(?=[A-Z])|_".toRegex()).joinToString("_") { it.lowercase() }
        }
    }

    object PascalCase : NamingStrategy {
        override fun convert(from: String): String {
            return from.split("_", " ").joinToString("") { it.replaceFirstChar(Char::uppercase) }
        }
    }

    object CamelCase : NamingStrategy {
        override fun convert(from: String): String {
            return from.split("_", " ").mapIndexed { index, part ->
                if (index == 0) {
                    part.replaceFirstChar { it.lowercase() }
                } else {
                    part.replaceFirstChar { it.uppercase() }
                }
            }.joinToString("")
        }
    }
}