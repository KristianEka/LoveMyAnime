package com.ekachandra.lovemyanime

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ListAnimeAdapter(private var listAnime: ArrayList<Anime>) :
    RecyclerView.Adapter<ListAnimeAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvScore: TextView = itemView.findViewById(R.id.tv_item_score)
        val tvGenres: TextView = itemView.findViewById(R.id.tv_item_genres)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_row_anime_list, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listAnime.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (title, photo, score, genres) = listAnime[position]
        holder.tvTitle.text = title
        holder.imgPhoto.setImageResource(photo)
        holder.tvScore.text = score
        holder.tvGenres.text = genres

        holder.itemView.setOnClickListener {
            val animeData = listAnime[position]
            val detailIntent = Intent(holder.itemView.context, DetailActivity::class.java)
            detailIntent.putExtra("EXTRA_ANIME", animeData)
            holder.itemView.context.startActivity(detailIntent)
        }
    }
}