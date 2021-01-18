package com.example.marvelcomics.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue


@Parcelize
data class Result(
 //   val characters: Characters,
 //   val collectedIssues: List<CollectedIssue>,
 //   val collections: List<Any>,
   // val creators: Creators,
    val dates: List<Date>,
    val description: String?,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
   // val events: Events,
    val format: String,
    val id: Int,
  //  val images: List<Image>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<Price>,
    val resourceURI: String,
   // val series: Series,
  //  val stories: Stories,
  //  val textObjects: List<TextObject>,

    val thumbnail: @RawValue Thumbnail,
    val title: String,
    val upc: String,
   // val urls: List<Url>,
    val variantDescription: String
  //  val variants: List<Variant>
) : Parcelable {


    companion object{

        var DIFF_CALLBACK: DiffUtil.ItemCallback<Result> = object : DiffUtil.ItemCallback<Result>(){
            override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}