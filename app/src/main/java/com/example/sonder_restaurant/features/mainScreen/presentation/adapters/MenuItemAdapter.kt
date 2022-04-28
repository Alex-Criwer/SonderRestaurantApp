package com.example.sonder_restaurant.features.mainScreen.presentation.adapters

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

class MenuItemAdapter(private val dishes: List<MenuItem>):
    RecyclerView.Adapter<MenuItemAdapter.MenuViewHolder>() {

    class MenuViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val dishRootLayout: CardView       = itemView.findViewById(R.id.cv_root_dish_layout)
        private val dishImageView: CircleImageView = itemView.findViewById(R.id.iv_picture_of_dish)
        private val dishNameTextView: TextView     = itemView.findViewById(R.id.tv_name_of_dish)
        private val dishPrice: TextView            = itemView.findViewById(R.id.tv_price)

        fun bind(dish: MenuItem) {
            Glide.with(itemView.context)
                 .load(dish.picture)
                 .into(dishImageView)
            dishNameTextView.text = dish.dish_name
            dishPrice.text = String.format(itemView.context.getString(R.string.app_name),
                                           dish.price.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                                     .inflate(R.layout.item_recucler_view, parent, false)
        return MenuViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(dishes[position])
    }

    override fun getItemCount() = dishes.size

}