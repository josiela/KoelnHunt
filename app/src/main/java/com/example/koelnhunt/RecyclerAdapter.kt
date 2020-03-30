package com.example.koelnhunt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koelnhunt.models.CardStructure
import kotlinx.android.synthetic.main.recycleview_card_layout.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<CardStructure> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        //Jeder Recyclerview wird genau so aussehen:
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycleview_card_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            //Bind data to particular view-holder:
            is ViewHolder -> {
                holder.bind(items[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(blogList: List<CardStructure>) {
        items = blogList
    }

    class ViewHolder constructor(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        val card_title = itemView.station
        val card_number = itemView.stationNumber

        //Bind Method: Taking each individual card object and bind it to the views in the layout
        fun bind(cardStructure: CardStructure) {
            card_title.text = cardStructure.title
            card_number.text = cardStructure.number.toString()
        }
    }

}