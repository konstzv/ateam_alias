package ru.androidacademy.ateam.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.model.game.Player
import ru.androidacademy.ateam.ui.adapter.TeamsRecyclerViewAdapter
import android.content.DialogInterface
import android.widget.Adapter
import android.widget.EditText
import ru.androidacademy.ateam.ui.activity.MainActivity




class TeamsFragment : Fragment() {

    private lateinit var firstTeamRecyclerView: RecyclerView
    private lateinit var secondTeamRecyclerView: RecyclerView

    private lateinit var firstTeamAdapter: TeamsRecyclerViewAdapter
    private lateinit var secondTeamAdapter: TeamsRecyclerViewAdapter

    private lateinit var addPlayerToFirstTeamButton: Button
    private lateinit var addPlayerToSecondTeamButton: Button

    private var firstTeamPlayers: ArrayList<Player> = ArrayList()
    private var secondTeamPlayers: ArrayList<Player> = ArrayList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_teams, container, false) as View

        with(view) {
            firstTeamRecyclerView = findViewById(R.id.players_first_team)
            firstTeamRecyclerView.layoutManager = LinearLayoutManager(context)
            firstTeamAdapter = TeamsRecyclerViewAdapter(firstTeamPlayers, container)
            firstTeamRecyclerView.adapter =  firstTeamAdapter

            secondTeamRecyclerView = findViewById(R.id.players_second_team)
            secondTeamRecyclerView.layoutManager = LinearLayoutManager(context)
            secondTeamAdapter = TeamsRecyclerViewAdapter(secondTeamPlayers, container)
            secondTeamRecyclerView.adapter = secondTeamAdapter

            addPlayerToFirstTeamButton = findViewById(R.id.add_player_to_first_team)
            addPlayerToSecondTeamButton = findViewById(R.id.add_player_to_second_team)

            addPlayerToFirstTeamButton.setOnClickListener {
                val layoutInflater = LayoutInflater.from(context)
                val promptView = layoutInflater.inflate(R.layout.player_dialog, null)
                val alertDialogBuilder = AlertDialog.Builder(context)
                alertDialogBuilder.setView(promptView)

                val editText = promptView.findViewById(R.id.dialog_edit_text) as EditText
                // setup a dialog window
                alertDialogBuilder.setCancelable(false)
                    .setPositiveButton("OK"
                    ) { dialog, id ->
                        run {
                            firstTeamPlayers.add(Player(editText.text.toString()))
                            firstTeamAdapter = TeamsRecyclerViewAdapter(firstTeamPlayers, container)
                        }
                    }
                    .setNegativeButton("Cancel",
                        DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

                val alert = alertDialogBuilder.create()
                alert.show()
            }

            addPlayerToSecondTeamButton.setOnClickListener {
                val layoutInflater = LayoutInflater.from(context)
                val promptView = layoutInflater.inflate(R.layout.player_dialog, null)
                val alertDialogBuilder = AlertDialog.Builder(context)
                alertDialogBuilder.setView(promptView)

                val editText = promptView.findViewById(R.id.dialog_edit_text) as EditText
                // setup a dialog window
                alertDialogBuilder.setCancelable(false)
                    .setPositiveButton("OK"
                    ) { dialog, id ->
                        secondTeamAdapter.addItem(Player(editText.text.toString()))
                    }
                    .setNegativeButton("Cancel",
                        DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

                val alert = alertDialogBuilder.create()
                alert.show()
            }
        }

        return view
    }
}