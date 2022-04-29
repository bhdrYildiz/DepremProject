package com.yildiz.depremproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yildiz.depremproject.R
import com.yildiz.depremproject.model.DepremModel
import kotlinx.android.synthetic.main.item_layout.view.*

class DepremAdapter : RecyclerView.Adapter<DepremAdapter.DepremViewHolder>() {
    private var depremlist: ArrayList<DepremModel.DepremModelItem> = arrayListOf()

    inner class DepremViewHolder(view : View) : RecyclerView.ViewHolder (view){
        fun bind(s : DepremModel.DepremModelItem){
            itemView.tv_item_layout.text = s.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DepremViewHolder (
        LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
    )

    override fun onBindViewHolder(holder: DepremAdapter.DepremViewHolder, position: Int) {
        holder.bind(depremlist[position])
    }

    override fun getItemCount(): Int = depremlist.size

    fun setDepremData(listdeprem: ArrayList<DepremModel.DepremModelItem>){
        depremlist.addAll(listdeprem)
        notifyDataSetChanged()
    }

}