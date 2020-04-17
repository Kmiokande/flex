package com.goblintechs.flex_gasolinaouetanol.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.goblintechs.flex_gasolinaouetanol.R


class SplashActivity : AppCompatActivity() {
    private val tempoSplash = 2000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        Handler().postDelayed(Runnable {
            mainScreen()
        }, tempoSplash.toLong())
    }

    fun mainScreen() {
        val i = Intent(this@SplashActivity, LoginActivity::class.java)
        startActivity(i)
        finish()
    }
}
