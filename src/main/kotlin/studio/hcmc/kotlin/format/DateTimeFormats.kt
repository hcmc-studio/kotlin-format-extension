package studio.hcmc.kotlin.format

import kotlinx.datetime.*

fun java.sql.Date.toKotlinInstant(): Instant {
    return LocalDateTime(toLocalDate().toKotlinLocalDate(), LocalTime.zero).toInstant(TimeZone.UTC)
}

fun java.util.Date.toKotlinInstant(): Instant {
    return toInstant().toKotlinInstant()
}

private val LocalTimeZero = LocalTime(0, 0, 0, 0)

val LocalTime.Companion.zero: LocalTime get() = LocalTimeZero

fun main() {
    val date = java.sql.Date.valueOf("1900-01-01")
    println(date.time)
    println(date.toLocalDate())
    println(date.toLocalDate().toKotlinLocalDate())
    println(LocalDateTime(date.toLocalDate().toKotlinLocalDate(), LocalTimeZero))
    println(LocalDateTime(date.toLocalDate().toKotlinLocalDate(), LocalTimeZero).toInstant(TimeZone.UTC))
}