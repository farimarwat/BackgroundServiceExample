package com.marwatsoft.backgroundservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MyService : Service() {
    lateinit var mPlayer: MediaPlayer
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        mPlayer = MediaPlayer.create(this,Settings.System.DEFAULT_ALARM_ALERT_URI)
        mPlayer.isLooping = true
        mPlayer.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mPlayer.stop()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }
}