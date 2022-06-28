package com.example.kakaobus_clone

import android.app.Application
import androidx.work.Configuration


class MainApplication : Application(), Configuration.Provider {
    override fun getWorkManagerConfiguration(): Configuration =
        Configuration.Builder().build()

}