package com.fatherofapps.durian

import org.apache.commons.codec.binary.Base64

class Durian {
    fun encode(message: String) : String{
        return String(Base64.encodeBase64(message.toByteArray()))
    }

    fun decode(message: String): String{
        return String(Base64.decodeBase64(message))
    }
}