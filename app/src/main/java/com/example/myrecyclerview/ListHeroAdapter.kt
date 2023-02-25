package com.example.myrecyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListHeroAdapter(private val  listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {


    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setoOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
        /*
        onCreateViewHolder digunakan untuk membuat ViewHolder baru yang berisi layout item yang digunakan
        tapi fungsi ini tidak bertujuan untuk mengisi tampilan. hanya untuk menginisialisasi viewHolder dan view
        yang akan diatribusikan.
         */
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description
        /*
        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu memilih" + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
        }
         */
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHero[holder.adapterPosition]) }

        /*
        onBindViewHolder digunakan untuk menetapkan data yang ada kedalam ViewHolder sesuai dengan posisinya

         */

    }

    override fun getItemCount(): Int = listHero.size //digunakan untuk menetapkan ukuran dari list data yang ingin ditampilkan.

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

        /*
       digunakan untuk viewHolder dalam RecyclerView. viewholder sendiri adalah wrapper seperti view
       yang berisi layout untuk ityem dalam RecyclerView di fungsi ini adalah tempat untuk menginisialisasi
       setiap komponen pada layout item dengan menggunakan itemView.findViewByid
         */
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
        /*
        interface dibuat dengan tujuan agar ketika kita memanggil fungsi setOnItemClickCallback
        terdapat data yang dikembalikan, untuk memasukan data ke interface kita hanya cukup
        memasukkan data ke dalam fungsi onClicked didalam BindViewHolder
         */
    }



}

