package com.leca.zandiakt.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.leca.zandiakt.activities.MainActivity
import com.leca.zandiakt.databinding.ActivitySplashBinding
import com.leca.zandiakt.fragments.OptionsFragment

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Simulando una carga de datos o un delay
        val splashTimeOut: Long = 3000 // 3 segundos
        binding.root.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, splashTimeOut)
    }
}

