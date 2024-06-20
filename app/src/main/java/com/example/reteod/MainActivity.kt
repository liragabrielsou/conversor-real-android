package com.example.reteod

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.reteod.databinding.ActivityMainBinding
import com.example.reteod.databinding.CustomEmptyLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var customToastEmpty :  CustomEmptyLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        var Real: String
        var switchDolar : Boolean
        var converter: Double


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        customToastEmpty =  CustomEmptyLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toastEmpty = Toast(applicationContext).apply {
            duration=Toast.LENGTH_SHORT
            view = customToastEmpty.root
        }

        val imagem: ImageView = binding.imageView2

binding.calculatingButton.setOnClickListener {
    Real = binding.inputReal.text.toString()
    switchDolar = binding.switchDolar.isChecked

    if (Real.equals("")){
        toastEmpty.show()
    }else {

        if (!switchDolar) {
            //Dolar
            converter = Real.toDouble() / 5.42
            binding.outputText.text = String.format("Dolar: $ %.2f", converter)
            imagem.setImageResource(R.drawable.dolar)
            imagem.visibility = View.VISIBLE
        } else {
            //Euro
            converter = Real.toDouble() / 5.81
            binding.outputText.text = String.format("Euro: $ %.2f", converter)
            imagem.setImageResource(R.drawable.euro)
            imagem.visibility = View.VISIBLE
        }
    }

}



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}