package com.myu.randomdogpictures.ui.feeddogimages

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.myu.randomdogpictures.R
import com.myu.randomdogpictures.adapter.DogImagesAdapter
import com.myu.randomdogpictures.databinding.FragmentFeedDogImagesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.math.log

@AndroidEntryPoint
class FeedDogImagesFragment : Fragment(),SwipeRefreshLayout.OnRefreshListener,View.OnClickListener{
    private val TAG = "FeedDogBreedsFragment"
    private lateinit var dogImagesAdapter: DogImagesAdapter
    private var _binding: FragmentFeedDogImagesBinding? = null
    private val binding get() = _binding!!
    private val viewModel: FeedDogImagesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentFeedDogImagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        setupObservers()

        binding.refreshLay.setOnRefreshListener(this)
        binding.btnCustomDogImages.setOnClickListener(this)
    }

    private fun setupRecyclerView() {
        dogImagesAdapter = DogImagesAdapter()
        binding.dogsRv.apply {
            adapter = dogImagesAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),LinearLayoutManager.VERTICAL,
                false
            )
            setHasFixedSize(true)
        }

    }

    private fun setupObservers() {
        viewModel.responseDogBreeds.observe(viewLifecycleOwner) { response ->
            dogImagesAdapter.dogImages = response.message
        }
    }

    override fun onRefresh() {
        viewModel.getAllDogImages()
        binding.refreshLay.isRefreshing = false
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnCustomDogImages -> {

            }
        }
    }

}