package com.android.mestore

import TableItem
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.mestore.Model.DealsModel
import com.android.mestore.adapter.TableItemAdapter
import com.android.mestore.databinding.ActivityMycartBinding
import com.android.mestore.databinding.TablesHomeActivityBinding
import com.android.mestore.utlis.model.TableCart
import com.android.mestore.viewmodel.CartViewModel
import com.google.android.material.snackbar.Snackbar


class TablesHomeActivity : AppCompatActivity(){
    lateinit var binding: TablesHomeActivityBinding
    private var adapter: TableItemAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = TablesHomeActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val arrdeals = ArrayList<DealsModel>()
        arrdeals.add(R.drawable.img_workplace_table,"TAbl",


    }
}
