package com.example.test2.utils
import io.realm.Realm
import android.app.Application
import io.realm.RealmConfiguration

class App:Application(){
    override fun onCreate() {
        super.onCreate()

        createRealm()
    }

    private fun createRealm() {
        Realm.init(this)
        val config=RealmConfiguration.Builder()
            .name("testDB")
            .allowWritesOnUiThread(true)
            .schemaVersion(1)
            .build()

        Realm.setDefaultConfiguration(config)


    }
}