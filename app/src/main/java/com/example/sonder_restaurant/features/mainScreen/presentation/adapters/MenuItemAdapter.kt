package com.example.sonder_restaurant.features.mainScreen.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.sonder_restaurant.R
import com.example.sonder_restaurant.features.mainScreen.data.retrofit.entities.MenuItem
import de.hdodenhof.circleimageview.CircleImageView

class MenuItemAdapter(private val onItemClick: () -> Unit):
    RecyclerView.Adapter<MenuItemAdapter.MenuViewHolder>() {

    private val _dishes: MutableList<MenuItem> = ArrayList()

    class MenuViewHolder(itemView: View, onItemClick: () -> Unit): RecyclerView.ViewHolder(itemView) {
        private val dishRootLayout: CardView       = itemView.findViewById(R.id.cv_root_dish_layout)
        private val dishImageView: CircleImageView = itemView.findViewById(R.id.iv_picture_of_dish)
        private val dishNameTextView: TextView     = itemView.findViewById(R.id.tv_name_of_dish)
        private val dishPrice: TextView            = itemView.findViewById(R.id.tv_price)

        fun bind(dish: MenuItem) {
            Glide.with(itemView.context)
                 .load(dish.picture)
                 .into(dishImageView)
            dishNameTextView.text = dish.dish_name
            dishPrice.text = String.format(itemView.context.getString(R.string.dish_price),
                                           dish.price.toString())
        }

        init {
            dishRootLayout.setOnClickListener {
                onItemClick.invoke()
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun initData(dishes: List<MenuItem>) {
        _dishes.clear()
        _dishes.addAll(dishes)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                                     .inflate(R.layout.item_recucler_view, parent, false)
        return MenuViewHolder(itemView, onItemClick)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(_dishes[position])
    }

    override fun getItemCount() = _dishes.size

}