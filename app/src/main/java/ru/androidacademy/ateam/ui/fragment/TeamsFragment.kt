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
import android.content.Intent
import android.util.Log
import android.widget.Adapter
import android.widget.EditText
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.bumptech.glide.Glide
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.fragment_teams.*
import pl.aprilapps.easyphotopicker.DefaultCallback
import pl.aprilapps.easyphotopicker.EasyImage
import ru.androidacademy.ateam.model.game.Team
import ru.androidacademy.ateam.presentation.presenter.SettingsPresenter
import ru.androidacademy.ateam.presentation.view.SettingsView
import ru.androidacademy.ateam.ui.activity.MainActivity
import ru.androidacademy.ateam.ui.activity.SettingsActivity
import java.io.File
import java.util.jar.Manifest


class TeamsFragment : MvpAppCompatFragment(), SettingsView {
    @InjectPresenter
    lateinit var presenter: SettingsPresenter
    private lateinit var firstTeamRecyclerView: RecyclerView
    private lateinit var secondTeamRecyclerView: RecyclerView

    private lateinit var firstTeamAdapter: TeamsRecyclerViewAdapter
    private lateinit var secondTeamAdapter: TeamsRecyclerViewAdapter

    private lateinit var addPlayerToFirstTeamButton: Button
    private lateinit var addPlayerToSecondTeamButton: Button

    private var firstTeamPlayers: ArrayList<Player> = ArrayList()
    private var secondTeamPlayers: ArrayList<Player> = ArrayList()

    var lastPlayerSelected:Player? = null
    var lastAdapterSelectedL:TeamsRecyclerViewAdapter? = null

    fun photo(){
        EasyImage.openCameraForImage(this, 0)
    }
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

            firstTeamAdapter.onDeleteClickPublisher.subscribeBy (onNext = {
                firstTeamPlayers.remove(it)
                firstTeamAdapter.update(firstTeamPlayers)

            })

            secondTeamAdapter.onDeleteClickPublisher.subscribeBy (onNext = {
                secondTeamPlayers.remove(it)
                secondTeamAdapter.update(secondTeamPlayers)
            })

            firstTeamAdapter.onPhotoClickPublisher.subscribeBy (onNext = {
              lastPlayerSelected = it
                lastAdapterSelectedL = firstTeamAdapter
                photo()

            })

            secondTeamAdapter.onPhotoClickPublisher.subscribeBy (onNext = {
                lastPlayerSelected = it
                lastAdapterSelectedL = secondTeamAdapter
                photo()
            })
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
                            firstTeamAdapter.update(firstTeamPlayers)
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
                        run {
                            secondTeamPlayers.add(Player(editText.text.toString()))
                            secondTeamAdapter.update(secondTeamPlayers)
                        }
                    }
                    .setNegativeButton("Cancel",
                        DialogInterface.OnClickListener { dialog, id -> dialog.cancel() })

                val alert = alertDialogBuilder.create()
                alert.show()
            }
        }

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        next.setOnClickListener{
            (activity as SettingsActivity).onTeamFinish()
            presenter.currentGame.teams = getTeams()
        }
        EasyImage.configuration(view.context)
            .setImagesFolderName("EasyImage sample")
            .setCopyTakenPhotosToPublicGalleryAppFolder(true)
            .setCopyPickedImagesToPublicGalleryAppFolder(true)
            .setAllowMultiplePickInGallery(true)
    }

    fun getTeams(): ArrayList<Team> {
        val teams: ArrayList<Team> = ArrayList()

        val firstTeam = Team(getString(R.string.first_team_name), firstTeamPlayers)
        teams.add(firstTeam)

        val secondTeam = Team(getString(R.string.second_team_name), secondTeamPlayers)
        teams.add(secondTeam)

        return teams
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)

        //requestPermissions(arrayOf("android.permission.WRITE_EXTERNAL_STORAGE"), requestCode)

        EasyImage.handleActivityResult(requestCode, resultCode, data, activity!!, object : DefaultCallback() {
            override fun onImagePickerError(e: Exception, source: EasyImage.ImageSource, type: Int) {
                //Some error handling
                e.printStackTrace()
            }

            override fun onImagesPicked(imageFiles: List<File>, source: EasyImage.ImageSource, type: Int) {
                val path = imageFiles[0].toURI().getPath()

                lastPlayerSelected?.let { player ->
                    player.image = path
                    lastAdapterSelectedL?.let{
                     val i =   it.players.indexOf(player)
                        it.players[i] = player
                        it.notifyDataSetChanged()
                    }
                }
            }

            override fun onCanceled(source: EasyImage.ImageSource, type: Int) {
                //Cancel handling, you might wanna remove taken photo if it was canceled
                if (source === EasyImage.ImageSource.CAMERA_IMAGE) {
                    val photoFile = EasyImage.lastlyTakenButCanceledPhoto(activity!!)
                    photoFile?.delete()
                }
            }
        })
    }
}