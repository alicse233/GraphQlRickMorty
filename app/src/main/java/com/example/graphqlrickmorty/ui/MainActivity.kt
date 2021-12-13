package com.example.graphqlrickmorty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.graphqlrickmorty.R
import com.example.graphqlrickmorty.extra.ViewState
import com.example.graphqlrickmorty.vm.CharacterViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewMode: CharacterViewModel by viewModels<CharacterViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewMode.queryCharacterList()
        observeData()
    }

    private fun observeData() {
        lifecycleScope.launchWhenResumed {
            viewMode.characterList.collectLatest { it ->
                when(it) {
                    is ViewState.Loading -> {
                        findViewById<ProgressBar>(R.id.loader).visibility = View.VISIBLE
                    }

                    is ViewState.Success -> {
                        findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                        findViewById<TextView>(R.id.txt).setText(it.data?.characters.toString())
                    }

                    is ViewState.Error -> {
                        findViewById<ProgressBar>(R.id.loader).visibility = View.GONE
                        findViewById<TextView>(R.id.txt).text = it.message
                    }
                }
            }
        }
    }
}