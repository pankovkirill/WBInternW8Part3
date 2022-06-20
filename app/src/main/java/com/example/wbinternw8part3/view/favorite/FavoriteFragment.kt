package com.example.wbinternw8part3.view.favorite

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wbinternw8part3.R
import com.example.wbinternw8part3.databinding.FragmentFavoriteBinding
import com.example.wbinternw8part3.model.AppState
import com.example.wbinternw8part3.view.favorite.adapter.FavoriteAdapter
import com.example.wbinternw8part3.viewmodel.FavoriteViewModel

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {

    private lateinit var binding: FragmentFavoriteBinding

    private val adapter: FavoriteAdapter by lazy { FavoriteAdapter() }

    private val viewModel: FavoriteViewModel by lazy {
        ViewModelProvider(this)[FavoriteViewModel::class.java]
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFavoriteBinding.bind(view)
        initViewModel()
        initView()
    }

    private fun initView() {
        binding.favoriteRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.favoriteRecyclerView.adapter = adapter
    }

    private fun initViewModel() {
        viewModel.liveData.observe(viewLifecycleOwner) { renderData(it) }
        viewModel.getData()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.SuccessFavorite -> {
                if (appState.favoriteData.isNotEmpty())
                    adapter.setData(appState.favoriteData)
                else
                    Toast.makeText(context, "No data available", Toast.LENGTH_SHORT).show()
            }
            is AppState.Loading -> {
                Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
            }
            is AppState.Error -> {
                Toast.makeText(context, appState.e.message, Toast.LENGTH_SHORT).show()
            }
        }

    }
}