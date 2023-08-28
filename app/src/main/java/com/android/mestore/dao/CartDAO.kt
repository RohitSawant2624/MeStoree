package com.android.mestore.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.android.mestore.utlis.model.TableCart

@Dao
interface CartDAO {

    @Insert
    fun insertCartItem(table: TableCart)

    @Query("SELECT * FROM TABLE_TABLE")
    fun getAllCartItems(): LiveData<List<TableCart>>

    @Delete
    fun deleteCartItem(table: TableCart)

    @Query("UPDATE Table_table SET TableQauntity=:quantity WHERE id=:id" )
    fun updateQuantity(
        id:Int,
        quantity:Int,
    )

    @Query("UPDATE Table_table SET totalitemprice=:totalitemprice WHERE id=:id" )
    fun updateTotalItemPrice(
        id:Int,
        totalitemprice:Double,
    )

    @Query("DELETE FROM Table_table")
    fun deleteAllItems ()


}