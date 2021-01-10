package com.example.marvelcomics.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcomics.databinding.ComicItemBinding
import com.example.marvelcomics.model.Result

class ComicsAdapter(val comicsList: List<Result>) : RecyclerView.Adapter<ComicsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsAdapter.ViewHolder {
        val binding = ComicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
       /* val view = LayoutInflater.from(parent.context)
            .inflate()*/
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicsAdapter.ViewHolder, position: Int) {
        holder.bind(comic = comicsList[position])
    }

    override fun getItemCount(): Int {
        return comicsList.size
    }


    class ViewHolder(val binding: ComicItemBinding) :  RecyclerView.ViewHolder(binding.root){

        fun bind(comic : Result):Unit = with(itemView){


            binding.tvEdition.text = comic.title
            //Glide.with(itemView.context).load(comic.img).into(binding.ivComicImage)

        }
    }
}