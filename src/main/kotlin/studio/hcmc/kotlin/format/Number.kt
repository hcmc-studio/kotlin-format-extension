package studio.hcmc.kotlin.format

/**
 * 4바이트 배열로 변환
 */
fun Int.toByteArray(): ByteArray {
    val bytes = ByteArray(Int.SIZE_BYTES)
    for (i in 0..<Int.SIZE_BYTES) {
        bytes[i] = and(0xFF.shl(i * 8)).shr(i * 8).toByte()
    }

    return bytes
}

/**
 * 앞 4바이트를 32비트 정수로 변환
 */
fun ByteArray.toInt(): Int {
    var int = 0
    for (i in 0..<Int.SIZE_BYTES) {
        int = int.or(getOrElse(i) { return int }.toInt().shl(i * 8).and(0xFF.shl(i * 8)))
    }

    return int
}

/**
 * 8바이트 배열로 변환
 */
fun Long.toByteArray(): ByteArray {
    val bytes = ByteArray(Long.SIZE_BYTES)
    for (i in 0..<Long.SIZE_BYTES) {
        bytes[i] = and(0xFFL.shl(i * 8)).shr(i * 8).toByte()
    }

    return bytes
}

/**
 * 앞 8바이트를 64비트 정수로 변환
 */
fun ByteArray.toLong(): Long {
    var long = 0L
    for (i in 0..<Long.SIZE_BYTES) {
        long = long.or(getOrElse(i) { return long }.toLong().shl(i * 8).and(0xFFL.shl(i * 8)))
    }

    return long
}