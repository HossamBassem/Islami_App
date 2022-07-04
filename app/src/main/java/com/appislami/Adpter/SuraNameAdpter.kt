package com.appislami.Adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appislami.R
import org.w3c.dom.Text

class SuraNameAdpter(val SuraList:List<sura>): RecyclerView.Adapter<SuraNameAdpter.viewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraNameAdpter.viewHolder {
val view=LayoutInflater.from(parent.context).inflate(R.layout.item_sura_name,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: SuraNameAdpter.viewHolder, position: Int) {
        val suraName=SuraList.get(position)
holder.name.setText(suraName.name)
if (onItemClickLisetner!=null){
    holder.itemView.setOnClickListener{
onItemClickLisetner?.onItemClick(position,suraName)
    }
}
    }

    override fun getItemCount(): Int =SuraList.size
    var onItemClickLisetner: onItemClickListener?=null
    interface onItemClickListener{
fun onItemClick(position: Int,item:sura)
    }
    class viewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
val name:TextView=itemview.findViewById(R.id.chapternamelable)
    }
}