package com.utmarckus.plantshandbook

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import com.utmarckus.plantshandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val plantAdapter = PlantAdapter()

    private lateinit var launcher: ActivityResultLauncher<Intent>

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val plant = it.data?.getSerializableExtra("plant", Plant::class.java)
                if (plant != null) plantAdapter.addPlant(plant)
            }
        }

        binding.apply {
            recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
            recyclerView.adapter = plantAdapter

            btnAddPlant.setOnClickListener {
                launcher.launch(Intent(this@MainActivity, EditActivity::class.java))
            }
        }
    }

}
