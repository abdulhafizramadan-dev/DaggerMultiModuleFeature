package com.gojek.detail_screen

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.gojek.daggermultimodulefeature.MainApplication
import com.gojek.detail_screen.databinding.ActivityDetailScreenBinding
import com.gojek.detail_screen.di.DaggerDetailScreenComponent
import com.gojek.detail_screen.di.DetailScreenComponent
import javax.inject.Inject

class DetailScreenActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailScreenBinding
    lateinit var detailScreenComponent: DetailScreenComponent
    @Inject
    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        val appComponent = (application as MainApplication).applicationComponent
        detailScreenComponent = DaggerDetailScreenComponent.factory().create(component = appComponent)
        detailScreenComponent.inject(this)
        super.onCreate(savedInstanceState)
        binding = ActivityDetailScreenBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initAction()
        initObserver()
    }

    private fun initAction() {
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun initObserver() {
        viewModel.user.observe(this) { user ->
            binding.tvName.text = user.name
            binding.tvAge.text = user.age.toString()
        }
    }
}