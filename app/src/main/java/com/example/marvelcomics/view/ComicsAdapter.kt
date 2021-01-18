package com.example.marvelcomics.view


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.marvelcomics.databinding.ComicItemBinding
import com.example.marvelcomics.model.Result
import com.example.marvelcomics.utils.Constants.Api.IMAGE_SIZE_MEDIUM

class ComicsAdapter(private val comicClicked: (Result?) -> Unit) : PagedListAdapter<Result,ComicsAdapter.ViewHolder>(Result.DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicsAdapter.ViewHolder {
        val binding = ComicItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ComicsAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position), comicClicked)

    }



    class ViewHolder(
        val binding: ComicItemBinding
    ):  RecyclerView.ViewHolder(
        binding.root
    ){

        fun bind(comic: Result?, comicClicked: (Result?) -> Unit):Unit = with(binding){

            val imagem : String = comic?.thumbnail?.path + IMAGE_SIZE_MEDIUM + comic?.thumbnail?.extension
            binding.tvEdition.text = comic?.issueNumber.toString()
            Glide.with(itemView.context).load(imagem).into(binding.ivComicImage)


            binding.ivComicImage.setOnClickListener{
                comicClicked(comic)

            }

        }
    }
}