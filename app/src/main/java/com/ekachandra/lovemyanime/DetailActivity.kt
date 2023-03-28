package com.ekachandra.lovemyanime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val data = intent.getParcelableExtra<Anime>("EXTRA_ANIME")

        val tvDetailTitle: TextView = findViewById(R.id.detail_title)
        val imgDetailPhoto: ImageView = findViewById(R.id.detail_photo)
        val tvDetailScore: TextView = findViewById(R.id.detail_score)
        val tvDetailGenres: TextView = findViewById(R.id.detail_genres)
        val tvDetailSynopsis: TextView = findViewById(R.id.detail_synopsis)
        val ibDetailShare: ImageButton = findViewById(R.id.action_share)


        if (data != null) {
            tvDetailTitle.text = data.title
            imgDetailPhoto.setImageResource(data.photo)
            tvDetailScore.text = data.score
            tvDetailGenres.text = data.genres
            tvDetailSynopsis.text = data.synopsis

            ibDetailShare.setOnClickListener {
                showActionSend(
                    """
                    You must watch this Anime!
                    
                    Anime: ${data.title}
                    Rating Score: ${data.score}
                    Genres: ${data.genres}
                    
                    Synopsis: 
                    ${data.synopsis}
                """.trimIndent()
                )
            }

        }

    }

    private fun showActionSend(text: String) {
        val intentSend = Intent()
        intentSend.action = Intent.ACTION_SEND
        intentSend.type = "text/plain"
        intentSend.putExtra(Intent.EXTRA_TEXT, text)
        startActivity(Intent.createChooser(intentSend, "Share with:"))
    }
}