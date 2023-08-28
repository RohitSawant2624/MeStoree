package com.android.mestore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.mestore.adapter.OrdersAdapter
import com.android.mestore.Model.OrdersModel
import com.android.mestore.databinding.ActivityMyordersBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyorderActivity : AppCompatActivity() {
    lateinit var binding : ActivityMyordersBinding
    private lateinit var rvAdapterr: OrdersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyordersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val arrOrders = ArrayList<OrdersModel>()

        arrOrders.add(OrdersModel(R.drawable.img_lamp ,"Ordered on May23", "Lamp Table"))
        arrOrders.add(OrdersModel(R.drawable.img_table__3 ,"Ordered on May23", "Lamp Table"))
        arrOrders.add(OrdersModel(R.drawable.img_table__1 ,"Ordered on May23", "Lamp Table"))
        arrOrders.add(OrdersModel(R.drawable.img_workplace_table ,"Ordered on May23", "Lamp Table"))
        arrOrders.add(OrdersModel(R.drawable.dinning_table ,"Ordered on May23", "Lamp Table"))
        arrOrders.add(OrdersModel(R.drawable.img_lamp ,"Ordered on May23", "Lamp Table"))
        arrOrders.add(OrdersModel(R.drawable.img_lamp ,"Ordered on May23", "Lamp Table"))
        arrOrders.add(OrdersModel(R.drawable.img_lamp ,"Ordered on May23", "Lamp Table"))
        arrOrders.add(OrdersModel(R.drawable.img_lamp ,"Ordered on May23", "Lamp Table"))

        rvAdapterr = OrdersAdapter(this , arrOrders)
        val ordersAdapter : OrdersAdapter = OrdersAdapter(this , arrOrders)
        binding.rvOrders.setHasFixedSize(true)
        val managerr : GridLayoutManager = GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)
        binding.rvOrders.layoutManager=managerr
        binding.rvOrders.itemAnimator= DefaultItemAnimator()
        binding.rvOrders.adapter=ordersAdapter

        val fab : FloatingActionButton
        fab =findViewById(R.id.fab_backPress)
        fab.setOnClickListener {
            val intent = Intent(this,TablesHomeActivity::class.java)
            startActivity(intent)
            finish()
        }





    }
}