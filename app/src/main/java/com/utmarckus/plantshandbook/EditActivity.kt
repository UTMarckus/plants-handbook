package com.utmarckus.plantshandbook

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.utmarckus.plantshandbook.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {

    lateinit var binding: ActivityEditBinding

    private var imgResListIndex = 0
    private val imgResList = listOf(
        R.drawable._01,
        R.drawable._02,
        R.drawable._03,
        R.drawable._04,
        R.drawable._05,
        R.drawable._06,
        R.drawable._07,
        R.drawable._08,
        R.drawable._09,
        R.drawable._10,
        R.drawable._11,
        R.drawable._12,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            btnChangeImg.setOnClickListener {
                imgResListIndex = imgResListIndex.inc() % imgResList.size
                imageView.setImageResource(imgResList[imgResListIndex])
            }
        }
    }
}