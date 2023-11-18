package studio.hcmc.kotlin.format

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class NumberTest {
    @Test
    fun testIntToByteArray() {
        val int0 = 123456789
        assertContentEquals(byteArrayOf(21, -51, 91, 7), int0.toByteArray())

        val int1 = 2112454933
        assertContentEquals(byteArrayOf(21, -127, -23, 125), int1.toByteArray())
    }

    @Test
    fun testByteArrayToInt() {
        val bytes0 = byteArrayOf(21, -51, 91, 7)
        assertEquals(123456789, bytes0.toInt())

        val bytes1 = byteArrayOf(21, -127, -23, 125, -12, 16, 34, 17)
        assertEquals(2112454933, bytes1.toInt())
    }

    @Test
    fun testLongToByteArray() {
        val long0 = 123456789L
        assertContentEquals(byteArrayOf(21, -51, 91, 7, 0, 0, 0, 0), long0.toByteArray())

        val long1 = 1234567890123456789L
        assertContentEquals(byteArrayOf(21, -127, -23, 125, -12, 16, 34, 17), long1.toByteArray())
    }

    @Test
    fun testByteArrayToLong() {
        val bytes0 = byteArrayOf(21, -51, 91, 7)
        assertEquals(123456789L, bytes0.toLong())

        val bytes1 = byteArrayOf(21, -127, -23, 125, -12, 16, 34, 17)
        assertEquals(1234567890123456789L, bytes1.toLong())
    }
}