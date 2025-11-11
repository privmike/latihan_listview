package com.example.kelas_navigation_component

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class BahanAdapter (private val listBahan : List<Bahan>
    ) : RecyclerView.Adapter<BahanAdapter.BahanViewHolder>() {

    class BahanViewHolder(view : View): RecyclerView.ViewHolder(view){
        val img = view.findViewById<ImageView>(R.id.img_bahan)
        val nama = view.findViewById<TextView>(R.id.namaBahan)
        val kategori = view.findViewById<TextView>(R.id.kategoriBahan)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BahanViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bahan, parent,false)
        return BahanViewHolder(view)
    }

    override fun onBindViewHolder(holder: BahanViewHolder, position: Int) {
        val bahan = listBahan[position]

        holder.nama.text= bahan.nama
        holder.kategori.text = bahan.kategori

        Picasso.get().load(bahan.url).resize(60,60).into(holder.img)

    }

    override fun getItemCount(): Int {
        return listBahan.size
    }


}