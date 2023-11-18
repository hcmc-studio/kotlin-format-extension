package studio.hcmc.kotlin.format.compression

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream

interface Compressor {
    fun deflate(bytes: ByteArray): ByteArray {
        return ByteArrayOutputStream().use { byteArrayOutputStream ->
            deflate(bytes, byteArrayOutputStream)
            byteArrayOutputStream.toByteArray()
        }
    }

    fun deflate(bytes: ByteArray, into: OutputStream): Long {
        return deflate(bytes.inputStream(), into)
    }

    fun deflate(from: InputStream, into: OutputStream): Long

    fun inflate(bytes: ByteArray): ByteArray {
        return ByteArrayOutputStream().use { byteArrayOutputStream ->
            inflate(bytes, byteArrayOutputStream)
            byteArrayOutputStream.toByteArray()
        }
    }

    fun inflate(bytes: ByteArray, into: OutputStream): Long {
        return inflate(bytes.inputStream(), into)
    }

    fun inflate(from: InputStream, into: OutputStream): Long
}