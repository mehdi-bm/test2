package com.example.test2.realmModel

import io.realm.Realm
import io.realm.kotlin.createObject

class UserDAO {
    private var realm=Realm.getDefaultInstance()

    fun Insert(user:User){
        realm.executeTransactionAsync({
            val realmObject=it.createObject(user::class.java,user.id)
        },
            {

            },
            {

            }
            )
    }
}