package com.example.steamgamepicker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.game_layout.view.*


class CustomAdapter(
    private val gamesList: MutableList<Game>
    ) : RecyclerView.Adapter<CustomAdapter.GameViewHolder>() {
    class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.game_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomAdapter.GameViewHolder, position: Int) {
        //TODO("Not yet implemented")
        val curGame = gamesList[position]
        holder.itemView.apply {
            txGameTitle.text = curGame.gameName
            cbGame.isChecked = curGame.isChecked
            val deleteButton = buttonDeleteGame
            if(deleteButton == null) {
                Toast.makeText(this.context, "ButtonDeleteGae returned null",Toast.LENGTH_SHORT)
                    .show()
            }
            cbGame.setOnCheckedChangeListener { _, isChecked ->

            }
        }
    }

    private fun lookForCheckedGames(): Boolean {
        for(game in gamesList) {
            if(game.isChecked) {
                return true
            }
        }
        return false
    }
    fun addGame(game: Game) {
        gamesList.add(game)
        notifyItemInserted(gamesList.size-1)
    }

    fun removeGame(game: Game) {
        val gamePosition = gamesList.indexOf(game)
        gamesList.remove(game)
        notifyItemRemoved(gamePosition)
    }

    override fun getItemCount(): Int {
        return gamesList.size
    }

}



