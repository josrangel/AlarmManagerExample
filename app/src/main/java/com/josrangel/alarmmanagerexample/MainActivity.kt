package com.josrangel.alarmmanagerexample

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.josrangel.alarmmanagerexample.databinding.ActivityMainBinding


/**
 * Source:
 * https://www.javatpoint.com/android-alarmmanager
 * https://stackoverflow.com/questions/15809399/android-notification-sound
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnStart.setOnClickListener { view -> startAlert() }
    }

    private fun startAlert() {
        val i: Int = binding.etTime.getText().toString().toInt()
        val intent = Intent(this, MyBroadcastReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this.applicationContext, 0, intent, PendingIntent.FLAG_MUTABLE
        )
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime() + (i * 1000), pendingIntent)

        Toast.makeText(this, "Alarm set in $i seconds", Toast.LENGTH_LONG).show()
    }
}