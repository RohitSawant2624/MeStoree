package com.android.mestore.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.android.mestore.dao.CartDAO
import com.android.mestore.database.CartDatabase
import com.android.mestore.repository.CartRepo
import com.android.mestore.utlis.model.TableCart

class CartViewModel(application: Application) : AndroidViewModel(application) {
    private val cartRepo: CartRepo

    init {
        val cartDAO = CartDatabase.getDatabase(
            application
        ).cartDao()
        cartRepo= CartRepo(cartDAO)

    }

    val allCartItems: LiveData<List<TableCart>>
        get() = cartRepo.allCartItems

    fun insertCartItem(tableCart: TableCart) {
        cartRepo.insertCartItem(tableCart)
    }

    fun updateQuantity(id: Int, quantity: Int) {
        cartRepo.updateQuantity(id, quantity)
    }

    fun updatePrice(id: Int, price: Double) {
        cartRepo.updatePrice(id, price)
    }

    fun deleteCartItem(tableCart: TableCart) {
        cartRepo.deleteCartItem(tableCart)
    }

    fun deleteAllCartItems() {
        cartRepo.deleteAllCartItems()
    }
}