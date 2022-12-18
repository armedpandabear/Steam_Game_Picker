package com.example.steamgamepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        customAdapter = CustomAdapter(mutableListOf())

        rvGameList.adapter = customAdapter
        rvGameList.layoutManager = LinearLayoutManager(this)

        buttonAddGame.setOnClickListener {
            val game = Game(editTextGameTitle.text)

            customAdapter.addGame(game)
            editTextGameTitle.setText("")
        }
    }
}