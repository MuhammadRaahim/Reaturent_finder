package com.instances.resturent_finder.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.instances.resturent_finder.activities.ListActivity
import com.instances.resturent_finder.databinding.FragmentHomeBinding
import com.instances.resturent_finder.utils.Constants.Companion.BARS
import com.instances.resturent_finder.utils.Constants.Companion.CAFE
import com.instances.resturent_finder.utils.Constants.Companion.LIST_TYPE
import com.instances.resturent_finder.utils.Constants.Companion.RESTAURENT


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)

        setClickListeners()

        return binding.root
    }

    private fun setClickListeners() {
        binding.apply {
            cvResturent.setOnClickListener {
               getDataList(RESTAURENT)
            }
            cvCafay.setOnClickListener {
                getDataList(CAFE)
            }
            cvBars.setOnClickListener {
                getDataList(BARS)
            }
        }
    }

    private fun getDataList(type: String){
        var intent = Intent(requireActivity(),ListActivity::class.java)
        intent.putExtra(LIST_TYPE, type)
        startActivity(intent)
    }

}