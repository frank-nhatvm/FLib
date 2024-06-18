package com.fatherofapps.flib

import androidx.annotation.Keep
import org.apache.commons.codec.binary.Base64


@Keep
object FLib {

    fun encode(message: String) : String{
        return String(Base64.encodeBase64(message.toByteArray()))
    }

    fun decode(message: String): String{
        return String(Base64.decodeBase64(message))
    }
}