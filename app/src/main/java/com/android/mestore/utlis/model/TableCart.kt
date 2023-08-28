package com.android.mestore.utlis.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Table_table")
data class TableCart (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    var TableName: String,
    var TableBrand: String,
    var TableImage: Int,
    var TablePrice: Double,
    var TableQauntity: Int,
    var TotalItemPrice: Double,)



//    ) {
//    fun TableQauntity(i: Int) {
//
//    }
//}
//{
//    fun getTotalItemPrice() : Double {
//        return TotalItemPrice
//
//    }
//
//    fun getQuantity(): Int {
//        return TableQauntity
//
//    }
//
//    fun getId(): Int {
//        return id
//
//    }
//
//    fun getTablePrice(): Double {
//        return TablePrice
//
//    }
//
//    fun setTableName(tableName: String) {
//
//
//    }
//
//    fun setTotalItemPrice(d: Double) {
//
//    }
//
//    fun setTableBrandName(tableBrandName: String) {
//
//    }
//
//    fun setTablePrice(tablePrice: Double) {
//
//    }
//
//    fun setTableQauntity(tableQauntity: Int) {
//
//    }
//
//    fun setTableImage(tableImage: Int) {
//
//    }
//
//    fun setQuantity(i: Int) {
//
//    }
//}
//
