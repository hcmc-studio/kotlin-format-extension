package studio.hcmc.kotlin.format

import kotlinx.datetime.*
import kotlin.time.Duration

fun java.sql.Date.toKotlinInstant(): Instant {
    return toInstant().toKotlinInstant()
}

fun java.util.Date.toKotlinInstant(): Instant {
    return toInstant().toKotlinInstant()
}

private val _LocalTimeZero = LocalTime(0, 0, 0, 0)

val LocalTime.Companion.zero: LocalTime get() = _LocalTimeZero