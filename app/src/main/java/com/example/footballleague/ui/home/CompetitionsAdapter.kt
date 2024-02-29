package com.example.footballleague.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.footballleague.R
import com.example.footballleague.databinding.CompetitionItemBinding
import com.example.footballleague.domain.models.Competition

class CompetitionsAdapter : RecyclerView.Adapter<CompetitionsAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: CompetitionItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: Competition) {

            binding.apply {
                Glide
                    .with(itemView.context)
                    .load(data.emblem)
                    .placeholder(R.drawable.ball)
                    .into(emblemImageView)

                competitionNameTextView.text = data.name
                competitionAreaTextView.text = data.area?.name
            }

        }

    }

    private val diffCallback = object : DiffUtil.ItemCallback<Competition>() {
        override fun areItemsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Competition, newItem: Competition): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffCallback)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CompetitionsAdapter.ViewHolder {
        val view =
            CompetitionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CompetitionsAdapter.ViewHolder, position: Int) {

        val currentItem = differ.currentList[position]
        holder.onBind(currentItem)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}
