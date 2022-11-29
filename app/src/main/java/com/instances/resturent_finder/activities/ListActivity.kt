package com.instances.resturent_finder.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.instances.resturent_finder.adapter.Adapter
import com.instances.resturent_finder.databinding.ActivityListBinding
import com.instances.resturent_finder.utils.BaseUtils.Companion.getData
import com.instances.resturent_finder.utils.Constants.Companion.LIST_TYPE
import com.instances.resturent_finder.utils.Data


class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private lateinit var adapter: Adapter
    private lateinit var listType: String
    private lateinit var dataList: ArrayList<Data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        setDataAdapter()
        setSearch()

    }

    private fun initViews() {
        listType = intent.getStringExtra(LIST_TYPE)!!
        dataList = getData(this).single { s -> s.key == listType }.data
    }

    private fun setDataAdapter() {
        binding.rvData.layoutManager =  LinearLayoutManager(this,  RecyclerView.VERTICAL, false)
        adapter = Adapter(dataList)
        binding.rvData.adapter = adapter
    }

    private fun setSearch() {
        binding.etSearch.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                filter(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable) {}
        })
    }

    private fun filter(text: String) {
        val filteredlist: ArrayList<Data> = ArrayList()
        for (item in dataList) {
            if (item.name!!.toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item)
            }
        }
        if (filteredlist.isEmpty()) {
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
        } else {
            adapter.updateList(filteredlist)
        }
    }

}