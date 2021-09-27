package com.example.test2.realmModel

import android.util.Log
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where

class UserDAO {
    private var realm=Realm.getDefaultInstance()

    fun Insert(objectUser:ObjectUser){
        realm.executeTransactionAsync({

            val realmObject=it.createObject(objectUser::class.java,objectUser.id)
            realmObject.name=objectUser.name
            realmObject.family=objectUser.family

             },
            {
                Log.i("REALM_TAG","Success")
            },
            {
                Log.i("REALM_TAG","Error: ${it.message}")
            }
            )
    }
    fun Update(objectUser: ObjectUser){
        realm.executeTransaction {
            it.copyToRealmOrUpdate(objectUser)
        }
    }

    fun readAll():RealmResults<ObjectUser> =realm.where(ObjectUser::class.java).findAll()

    fun readById(id:Int):ObjectUser? =realm.where(ObjectUser::class.java).equalTo("id",id).findFirst()

    fun deleteAll(){
        realm.executeTransaction {
            readAll().deleteAllFromRealm()
        }
    }

    fun deleteById(id:Int){
        realm.executeTransaction{
            try {
                readById(id)?.deleteFromRealm()
            }catch (ex:Exception){
                ex.printStackTrace()
            }

        }
    }

    fun CloseDB(){
        realm.close()
    }
}