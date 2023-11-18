package studio.hcmc.kotlin.format.compression

import java.io.InputStream
import java.io.OutputStream
import java.util.zip.GZIPInputStream
import java.util.zip.GZIPOutputStream

object GZip : Compressor {
    /**
     * 압축
     */
    override fun deflate(from: InputStream, into: OutputStream): Long {
        return GZIPOutputStream(into).use { gzipOutputStream ->
            from.copyTo(gzipOutputStream)
        }
    }

    /**
     * 압축 해제
     */
    override fun inflate(from: InputStream, into: OutputStream): Long {
        return GZIPInputStream(from).use { gzipInputStream ->
            gzipInputStream.copyTo(into)
        }
    }
}