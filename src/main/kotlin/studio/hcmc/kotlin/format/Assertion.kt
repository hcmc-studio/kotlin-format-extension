package studio.hcmc.kotlin.format

inline fun <T : Any?> T.assert(condition: T.() -> Boolean, throws: T.() -> Throwable = { AssertionError("condition returns false.") }): T {
    if (!this.condition()) {
        throw this.throws()
    }

    return this
}