package ru.androidacademy.ateam.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.model.game.Player


class TeamsRecyclerViewAdapter(
    private val players: ArrayList<Player>,
    private val viewgroup: ViewGroup?
) : RecyclerView.Adapter<TeamsRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.player_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = players[position]

        with (viewHolder) {
            nameView.text = item.name

            if (item.image != null) {
                Glide
                    .with(itemView)
                    .load(item.image)
                    .into(imageView)
            }
        }
    }

    override fun getItemCount(): Int = players.size

    fun addItem(player: Player) {
        players.add(player)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.player_name)
        val imageView: ImageView = view.findViewById(R.id.player_image)
    }
}