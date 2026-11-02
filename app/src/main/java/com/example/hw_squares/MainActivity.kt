package com.example.hw_squares

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var squareAdapter: SquareAdapter

    companion object {
        private const val KEY_COUNT = "key_count"
        private const val INITIAL_COUNT = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val savedCount = savedInstanceState?.getInt(KEY_COUNT, INITIAL_COUNT) ?: INITIAL_COUNT

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val addButton: Button = findViewById(R.id.addButton)

        val columns = resources.getInteger(R.integer.span_count)

        squareAdapter = SquareAdapter(savedCount)
        recyclerView.layoutManager = GridLayoutManager(this, columns)
        recyclerView.adapter = squareAdapter

        addButton.setOnClickListener {
            squareAdapter.addSquare()
            recyclerView.smoothScrollToPosition(squareAdapter.itemCount - 1)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_COUNT, squareAdapter.getCurrentCount())
    }
}