package com.instances.resturent_finder.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.instances.resturent_finder.R
import com.instances.resturent_finder.databinding.ActivityDetailBinding
import com.instances.resturent_finder.utils.Constants.Companion.DATA
import com.instances.resturent_finder.utils.Data

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private lateinit var data: Data

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        setOnClickListeners()
    }

    private fun setOnClickListeners() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
        binding.ivMap.setOnClickListener {
            var intent = Intent(this,MapActivity::class.java)
            intent.putExtra(DATA,data)
            startActivity(intent)
        }
    }

    private fun initViews() {
        data = intent.getSerializableExtra(DATA) as Data
        setData()
    }

    private fun setData() {
        binding.apply {
            Glide.with(this@DetailActivity).load(data.url)
                .placeholder(R.drawable.img_profile_cover_placeholder)
                .diskCacheStrategy(DiskCacheStrategy.DATA)
                .into(ivEvent)
            tvEventName.text = data.name
            tvDescription.text = data.description
        }
    }
}