package com.ekachandra.lovemyanime

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val imgBtnLinkedin: ImageButton = findViewById(R.id.img_btn_linkedin)

        imgBtnLinkedin.setOnClickListener {
            val intentLinkedin = Intent(Intent.ACTION_VIEW)
            intentLinkedin.data = Uri.parse("https://id.linkedin.com/in/kristian-ekachandra")
            startActivity(intentLinkedin)
        }

    }
}