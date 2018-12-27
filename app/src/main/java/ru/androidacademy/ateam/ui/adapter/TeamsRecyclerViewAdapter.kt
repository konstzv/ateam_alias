package ru.androidacademy.ateam.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.reactivex.subjects.PublishSubject
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.model.Player


class TeamsRecyclerViewAdapter(
    var players: ArrayList<Player>,
    private val viewgroup: ViewGroup?
) : RecyclerView.Adapter<TeamsRecyclerViewAdapter.ViewHolder>() {

    val onDeleteClickPublisher = PublishSubject.create<Player>()
    val onPhotoClickPublisher = PublishSubject.create<Player>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.player_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = players[position]

        with(viewHolder) {
            nameView.text = item.name

            if (item.image != null) {
                Glide
                    .with(itemView)
                    .load(item.image)
                    .into(imageView)
            }

            imageView.setOnClickListener {
                onPhotoClickPublisher.onNext(item)
            }

            deleteView.setOnClickListener {
                onDeleteClickPublisher.onNext(item)
            }
        }
    }

    override fun getItemCount(): Int = players.size

    fun update(items: ArrayList<Player>) {
        players = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val nameView: TextView = view.findViewById(R.id.player_name)
        val imageView: ImageView = view.findViewById(R.id.player_image)
        val deleteView: ImageView = view.findViewById(R.id.player_delete)
    }
}