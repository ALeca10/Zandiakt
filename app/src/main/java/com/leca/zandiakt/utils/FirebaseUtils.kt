package com.leca.zandiakt.utils

import com.google.firebase.auth.FirebaseAuth

object FirebaseUtils {
    val auth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
}
