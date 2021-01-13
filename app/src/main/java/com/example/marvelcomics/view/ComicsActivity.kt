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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(ComicsViewModel::class.java)
        viewModel.getComics()
        setupObservables()

        binding.ivActionBar.setOnClickListener(){
            val intent = Intent(this, ComicsDetailActivity::class.java)
            startActivity(intent)
        }

    }

    fun setupObservables() {
        viewModel.comicsLiveData.observe(this,{
            it?.let { comics ->
                setupRecyclerView(comics.data.results)     //pega os dados da api
            }
        })
    }

     fun setupRecyclerView(quadrinhos: List<Result>) {
        binding.rvComicsList.apply{
            layoutManager = GridLayoutManager(this@ComicsActivity,3)
            adapter = ComicsAdapter(quadrinhos)
        }
    }

    /* viewModel.comicsLiveData.observe(this,{
         it?.let{ comics ->
             binding.rvComicsList.apply {
                 layoutManager = GridLayoutManager(this@ComicsActivity,3)
                 adapter = ComicsAdapter(comics)
             }

         }
     })*/








    }
