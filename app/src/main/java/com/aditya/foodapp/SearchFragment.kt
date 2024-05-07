package com.aditya.foodapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.aditya.foodapp.activity.MainActivity
import com.aditya.foodapp.adapter.CategoryMealAdapter
import com.aditya.foodapp.adapter.MealItemAdapter
import com.aditya.foodapp.databinding.FragmentSearchBinding
import com.aditya.foodapp.viewModel.HomeViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SearchFragment : Fragment() {

    lateinit var binding:FragmentSearchBinding
    lateinit var viewModel: HomeViewModel
    private lateinit var mealItemAdapter: MealItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
 viewModel=(requireActivity() as MainActivity).viewModel
        mealItemAdapter= MealItemAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding=FragmentSearchBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initUI()
        subscribeToObserver()
    }

    private fun subscribeToObserver() {
                viewModel.observeSearchMeal().observe(viewLifecycleOwner){
                    if (it.meals==null){
                        noDataViewVisible()
                    }
                    else{
                        noDataViewHide()
                        mealItemAdapter.sumbitList(it.meals)
                    }

                }
    }



    private fun initUI() {
        binding.rvSearch.apply {
            layoutManager=GridLayoutManager(requireContext(),2,GridLayoutManager.VERTICAL,false)
            adapter=mealItemAdapter
        }
        binding.ivSearch.setOnClickListener {
            viewModel.getSearchMeal(binding.etSearch.text.toString())
        }

        var searchJob: Job?=null

        binding.etSearch.addTextChangedListener {
            searchJob?.cancel()
            searchJob=lifecycleScope.launch {
                delay(500)
                viewModel.getSearchMeal(it.toString())
            }

        }


    }
    private fun noDataViewVisible() {
        binding.rvSearch.isGone=true
        binding.noResult.isGone=false
    }
    private fun noDataViewHide() {
        binding.rvSearch.isGone=false
        binding.noResult.isGone=true
    }
}