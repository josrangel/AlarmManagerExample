package com.josrangel.alarmmanagerexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.media.RingtoneManager
import android.net.Uri
import android.util.Log
import android.widget.Toast


class MyBroadcastReceiver: BroadcastReceiver() {

    var mp: MediaPlayer? = null

    override fun onReceive(p0: Context?, p1: Intent?) {
        Log.i(this.javaClass.name,"onReceive");
        val alarmSound: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        mp=MediaPlayer.create(p0, alarmSound)
        mp?.start()
        Toast.makeText(p0, "Alarm", Toast.LENGTH_LONG).show();
    }

}