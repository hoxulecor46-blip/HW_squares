package com.example.hw_squares

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class SquareAdapter(private var count: Int) :
    RecyclerView.Adapter<SquareAdapter.SquareViewHolder>() {

    class SquareViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numberTextView: TextView = view.findViewById(R.id.numberTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SquareViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_square, parent, false)
        return SquareViewHolder(view)
    }

    override fun onBindViewHolder(holder: SquareViewHolder, position: Int) {
        val number = position + 1
        holder.numberTextView.text = number.toString()

        val colorRes = if (number % 2 == 0) {
            R.color.even_red
        } else {
            R.color.odd_blue
        }

        val color = ContextCompat.getColor(holder.itemView.context, colorRes)
        holder.numberTextView.setBackgroundColor(color)
    }

    override fun getItemCount(): Int = count

    fun addSquare() {
        count++
        notifyItemInserted(count - 1)
    }

    fun getCurrentCount(): Int = count
}