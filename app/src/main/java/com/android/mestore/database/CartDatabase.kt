package com.android.mestore.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.android.mestore.dao.CartDAO
import com.android.mestore.utlis.model.TableCart

@Database(entities = [TableCart::class], version = 1 )
abstract class CartDatabase: RoomDatabase() {

    abstract fun cartDao(): CartDAO
    companion object{
        @Volatile
        private var INSTANCE: CartDatabase?=null

        fun getDatabase(context: Context): CartDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CartDatabase::class.java,
                    "cart_database"
                ).build()
                INSTANCE= instance
                return instance
            }
        }


    }




}