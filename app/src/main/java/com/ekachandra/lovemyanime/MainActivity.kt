package com.ekachandra.lovemyanime

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvAnime: RecyclerView
    private val list = ArrayList<Anime>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvAnime = findViewById(R.id.rv_anime)
        rvAnime.setHasFixedSize(true)

        list.addAll(getListAnime())
        showRecyclerList()
    }

    @SuppressLint("Recycle")
    private fun getListAnime(): ArrayList<Anime> {
        val dataTitle = resources.getStringArray(R.array.data_title)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val dataScore = resources.getStringArray(R.array.data_score)
        val dataGenres = resources.getStringArray(R.array.data_genres)
        val dataSynopsis = resources.getStringArray(R.array.data_synopsis)
        val listAnime = ArrayList<Anime>()

        for (i in dataTitle.indices) {
            val anime =
                Anime(
                    dataTitle[i],
                    dataPhoto.getResourceId(i, -1),
                    dataScore[i],
                    dataGenres[i],
                    dataSynopsis[i]
                )
            listAnime.add(anime)
        }
        return listAnime
    }

    private fun showRecyclerList() {
        rvAnime.layoutManager = LinearLayoutManager(this)
        val listAnimeAdapter = ListAnimeAdapter(list)
        rvAnime.adapter = listAnimeAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val aboutIntent = Intent(this, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}