package com.example.sonder_restaurant.features.mainScreen.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sonder_restaurant.R
import com.example.sonder_restaurant.features.mainScreen.domain.MainViewMadelFactory
import com.example.sonder_restaurant.features.mainScreen.domain.MainViewModel
import com.example.sonder_restaurant.features.mainScreen.presentation.adapters.MenuItemAdapter
import com.google.android.material.tabs.TabLayout


class MainFragment : Fragment() {

    private lateinit var mainInfoBtn: Button
    private lateinit var cartBtn: Button
    private lateinit var searchEditText: EditText
    private lateinit var menuTabLayout: TabLayout
    private lateinit var rvFoods: RecyclerView
    private var adapterMenuFoods = MenuItemAdapter()
    private lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initRv()
        initSubscribe()
        loadData()
    }

    private fun initView(view: View) {
        mainInfoBtn    = view.findViewById(R.id.btn_info)
        cartBtn        = view.findViewById(R.id.btn_cart)
        searchEditText = view.findViewById(R.id.et_search)
        menuTabLayout  = view.findViewById(R.id.tl_menu)
        rvFoods        = view.findViewById(R.id.rv_menu_foods)
        mainViewModel = ViewModelProvider(this, MainViewMadelFactory()).get(MainViewModel::class.java)
    }

    private fun initRv() {
        rvFoods.apply {
            adapter = adapterMenuFoods
            layoutManager = LinearLayoutManager(context)
        }
    }

    private fun initSubscribe() {
        mainViewModel.foodsMenu.observe(viewLifecycleOwner, Observer(adapterMenuFoods::initData))
    }

    private fun loadData() {
        mainViewModel.getFoodsInfo()
    }
}