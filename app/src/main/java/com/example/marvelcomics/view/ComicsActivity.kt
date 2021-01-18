package com.example.marvelcomics.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcomics.databinding.ActivityComicsBinding
import com.example.marvelcomics.model.Comics
import com.example.marvelcomics.model.Result
import com.example.marvelcomics.viewModel.ComicsViewModel

class ComicsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicsBinding
    private lateinit var viewModel: ComicsViewModel
    private val comicsAdapter: ComicsAdapter by lazy{
        ComicsAdapter{
            val comicClicked = it
            val intent = Intent(this@ComicsActivity, ComicsDetailActivity::class.java)
            intent.putExtra("comicss", comicClicked)
            startActivity(intent)
            //chama outra activity
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        setupRecyclerView()
        loadContents()

    }



    fun loadContents(){
        viewModel = ViewModelProvider(this).get(ComicsViewModel::class.java)
        viewModel.comicsPagedList?.observe(this) {pagedList ->
            comicsAdapter.submitList(pagedList)}
    }

     fun setupRecyclerView() {
        binding.rvComicsList.apply{
            layoutManager = GridLayoutManager(this@ComicsActivity,3)
            adapter = comicsAdapter

            }
        }











    }


