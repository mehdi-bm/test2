package com.example.test2.realmModel

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ObjectUser:RealmObject() {
    @PrimaryKey
    var id:Int?=null

    lateinit var name:String

    lateinit var family:String
}