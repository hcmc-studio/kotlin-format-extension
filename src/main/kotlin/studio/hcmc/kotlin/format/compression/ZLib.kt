package studio.hcmc.kotlin.format.compression

import java.io.InputStream
import java.io.OutputStream
import java.util.zip.DeflaterInputStream
import java.util.zip.InflaterInputStream

object ZLib : Compressor {
    override fun deflate(from: InputStream, into: OutputStream): Long {
        return DeflaterInputStream(from).use {
            it.copyTo(into)
        }
    }

    override fun inflate(from: InputStream, into: OutputStream): Long {
        return InflaterInputStream(from).use {
            it.copyTo(into)
        }
    }
}