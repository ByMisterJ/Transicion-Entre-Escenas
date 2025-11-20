package com.example.transicion_entre_escenas

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


// Imagen principal (réplica del fotograma)
        val img = findViewById<ImageView>(R.id.sceneImage)
        img.setOnClickListener { v ->
            val intent = Intent(this, DetailActivity::class.java)
// Shared element transition
            val options = ActivityOptions.makeSceneTransitionAnimation(this, v, "shared_scene")
            startActivity(intent, options.toBundle())
        }
    }
}