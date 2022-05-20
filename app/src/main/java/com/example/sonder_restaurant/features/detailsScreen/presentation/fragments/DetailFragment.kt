package com.example.sonder_restaurant.features.detailsScreen.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.sonder_restaurant.R
import de.hdodenhof.circleimageview.CircleImageView


class detailFragment : Fragment() {
    private lateinit var backButton: Button
    private lateinit var favouritesButton: Button
    private lateinit var dishImage: CircleImageView
    private lateinit var dishName: TextView
    private lateinit var dishPrice: TextView
    private lateinit var dishComposition: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }

    private fun initView(view: View) {
        backButton = view.findViewById(R.id.btn_back_detail_fragment)
        favouritesButton = view.findViewById(R.id.btn_likes_dish)
        dishImage = view.findViewById(R.id.iv_picture_of_dish_detail)
        dishName = view.findViewById(R.id.tv_name_of_dish_detail)
        dishPrice = view.findViewById(R.id.tv_price_detail)
        dishComposition = view.findViewById(R.id.composition_dish)
    }

}