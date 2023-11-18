package studio.hcmc.kotlin.format

import studio.hcmc.kotlin.format.compression.GZip
import studio.hcmc.kotlin.format.compression.ZLib
import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class GZipTest {
    private val originalString = "Hello World!".repeat(1000)
    private val originalBytes = originalString.toByteArray(Charsets.UTF_8)
    private val originalDeflated = byteArrayOf(31, -117, 8, 0, 0, 0, 0, 0, 0, -1, -19, -58, 49, 13, 0, 32, 16, 4, 48, 43, -32, -26, 29, 96, 0, -74, 75, 62, -63, -1, -128, 12, -106, 118, 106, -99, -92, -57, -22, -101, 61, -53, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -35, -3, -45, 31, 122, -66, -8, -73, -32, 46, 0, 0)

    @Test
    fun deflateTest() {
        val deflated = GZip.deflate(originalBytes)
        assertContentEquals(originalDeflated, deflated)
    }

    @Test
    fun inflateTest() {
        val inflated = GZip.inflate(originalDeflated)
        assertContentEquals(originalBytes, inflated)
        val string = String(inflated)
        assertEquals(originalString, string)
    }

    @Test
    fun minSizeTest() {
        var bytes = ByteArray(0)
        val others = listOf('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '`', '~', '₩', '[', '{', ']', '}', '\\', '|', ';', ':', '\'', '"', ',', '<', '.', '>', '/', '?').map { it.code.toByte() }.toByteArray()
        while (true) {
            val deflated = GZip.deflate(bytes)
            if (bytes.size < deflated.size) {
                bytes += when (val i = Random.nextInt(62 + others.size)) {
                    in 0..<10 -> ('0'.code + i).toByte()
                    in 10..<36 -> ('A'.code + i).toByte()
                    in 36..<62 -> ('a'.code + i).toByte()
                    else -> others[i - 62]
                }
            } else {
                println(bytes.size)
                println(deflated.size)
                break
            }
        }
    }

    @Test
    fun fileTest() {
        val bytes = this::class.java.classLoader.getResourceAsStream("test.json")?.readAllBytes() ?: throw AssertionError()
        val deflated = GZip.deflate(bytes)
        println(deflated.size)
    }

    @Test
    fun benchmark() {
        val bytes = this::class.java.classLoader.getResourceAsStream("test.json")?.readAllBytes() ?: throw AssertionError()
        var elapsed = 0L
        repeat(1000) {
            val timestamp = System.nanoTime()
            GZip.deflate(bytes)
            elapsed += System.nanoTime() - timestamp
        }

        println("${elapsed}ns")
    }
}