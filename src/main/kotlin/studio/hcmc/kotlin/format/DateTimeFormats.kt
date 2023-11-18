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

fun LocalDate.toInstant(
    time: LocalTime = LocalTime.zero,
    timeZone: TimeZone = TimeZone.currentSystemDefault(),
): Instant {
    return LocalDateTime(this, time).toInstant(timeZone)
}

fun Instant.toLocalDate(timeZone: TimeZone) = toLocalDateTime(timeZone).date

fun Instant.toLocalTime(timeZone: TimeZone) = toLocalDateTime(timeZone).time
