package com.example.nested_recycler_view

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.list_item_main.view.*

class MainAdapter(
    val mainHeadingData: ArrayList<MainHeadingData>,
    val clickListener: View.OnClickListener
) : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_main, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.tag = position
        holder.itemView.setOnClickListener(clickListener)
        holder.tvAnimalType?.text = mainHeadingData.get(position).mainHeading

        val childLayoutManager = LinearLayoutManager(holder.itemView.rvSub.context, LinearLayout.VERTICAL, false)

        holder.itemView.rvSub.apply {
            layoutManager = childLayoutManager
            adapter = SubAdapter(mainHeadingData.get(position))
            setRecycledViewPool(viewPool)
        }
    }

    override fun getItemCount(): Int {
        return mainHeadingData.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAnimalType = view.tvMain
    }
}

