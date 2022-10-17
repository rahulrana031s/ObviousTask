package com.example.obvioustask.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.obvioustask.adapters.ItemDataAdapter
import com.example.obvioustask.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apodAdapter = ItemDataAdapter(mutableListOf(), { pos ->
            findNavController().navigate(

                MainFragmentDirections.actionMainFragmentToDetailsFragment(
                    pos
                )
            )
        }, { pos ->
            val newItems = viewModel.itemsData.value!!
            viewModel.itemsData.postValue(newItems)

        })

        viewModel.itemsData.observe(viewLifecycleOwner, {
            apodAdapter.updateItems(it)
        })

        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        binding.mainRecyclerView.apply {
            adapter = apodAdapter
            layoutManager = gridLayoutManager
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}