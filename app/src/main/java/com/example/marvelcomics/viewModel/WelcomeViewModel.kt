package com.example.marvelcomics.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WelcomeViewModel : ViewModel() {

    val onNameChange: MutableLiveData<String> = MutableLiveData()

}