package com.example.wbinternw8part3.view.main

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.wbinternw8part3.R
import com.example.wbinternw8part3.databinding.FragmentMainBinding
import com.example.wbinternw8part3.model.AppState
import com.example.wbinternw8part3.model.remote.dto.ImageResponse
import com.example.wbinternw8part3.model.remote.dto.MessageResponse
import com.example.wbinternw8part3.model.remote.dto.VoteRequest
import com.example.wbinternw8part3.viewmodel.MainViewModel

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var post: ImageResponse

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMainBinding.bind(view)

        initViewModel()
        buttonClick()
    }

    private fun buttonClick() {
        binding.cardViewLike.setOnClickListener {
            viewModel.postVote(createBody(LIKE))
            viewModel.saveFavoriteCatToDB(post)
            viewModel.getData()
        }

        binding.cardViewDislike.setOnClickListener {
            viewModel.postVote(createBody(DISLIKE))
            viewModel.getData()
        }
    }

    private fun createBody(params: Int): VoteRequest {
        return VoteRequest(
            post.id,
            SUB_ID,
            params
        )
    }

    private fun initViewModel() {
        viewModel = MainViewModel()
        viewModel.liveDataPost.observe(viewLifecycleOwner) { renderData(it) }
        viewModel.liveDataVote.observe(viewLifecycleOwner) { showToast(it) }
        viewModel.getData()
    }

    private fun showToast(messageRequest: MessageResponse) {
        Log.d("POST", messageRequest.message)
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.SuccessMain -> {
                post = appState.imageResponse[FIRST]
                val uri = Uri.parse(post.url)
                binding.image.setImageURI(uri)
            }
            is AppState.Loading -> {
                Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
            }
            is AppState.Error -> {
                Toast.makeText(context, appState.e.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        private const val FIRST = 0
        private const val SUB_ID = "from-phone"
        private const val LIKE = 1
        private const val DISLIKE = 0
    }
}