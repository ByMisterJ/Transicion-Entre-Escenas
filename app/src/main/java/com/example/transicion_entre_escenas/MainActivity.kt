package com.example.transicion_entre_escenas

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Imagen principal (origen del shared element)
        val img = findViewById<ImageView>(R.id.sceneImage)
        // Aseguramos que la vista de origen tiene el mismo transitionName
        img.transitionName = "shared_scene"

        img.setOnClickListener {
            val intent = Intent(this, DetailActivity::class.java)
            // pasamos el drawable correcto que nos indicaste
            intent.putExtra("image_res", R.drawable.escena_frame0)

            // Shared element transition usando el transitionName de la imagen
            val options = ActivityOptions.makeSceneTransitionAnimation(this, img, img.transitionName)
            startActivity(intent, options.toBundle())
        }
    }
}