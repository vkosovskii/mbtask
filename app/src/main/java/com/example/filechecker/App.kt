package com.example.filechecker

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.example.filechecker.di.AppComponent
import com.example.filechecker.di.AppModule
import com.example.filechecker.di.DaggerAppComponent

class App : Application() {

    companion object {
       const val CHANNEl_1_ID = "channel1"
    }


    private val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .appModule(AppModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEl_1_ID,
                "Channal1",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "This is notification"

            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }

    fun getComponent() = appComponent
}