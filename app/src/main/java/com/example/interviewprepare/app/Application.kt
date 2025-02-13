package com.example.interviewprepare.app

import android.app.Application
import com.example.interviewprepare.app.service.AppContainer
import com.example.interviewprepare.app.service.DefaultAppContainer

class Application : Application() {
    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultAppContainer()
    }
}