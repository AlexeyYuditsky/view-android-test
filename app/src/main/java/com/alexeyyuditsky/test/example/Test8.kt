package com.alexeyyuditsky.test.example

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun encrypt(text: String, key: ByteArray): ByteArray {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val secretKey = SecretKeySpec(key, "AES")
    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    return cipher.doFinal(text.toByteArray())
}

fun decrypt(encryptedData: ByteArray, key: ByteArray): String {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val secretKey = SecretKeySpec(key, "AES")
    cipher.init(Cipher.DECRYPT_MODE, secretKey)
    val decryptedData = cipher.doFinal(encryptedData)
    return decryptedData.decodeToString()
}

fun main() {
    val originalText = "Hello"
    val key = "0123456789abcdef".toByteArray()

    // Encrypt
    val encryptedData = encrypt(originalText, key)
    println("Encrypted: ${encryptedData.decodeToString()}")

    // Decrypt
    val decryptedText = decrypt(encryptedData, key)
    println("Decrypted: $decryptedText")
}