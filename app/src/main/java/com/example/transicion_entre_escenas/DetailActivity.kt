package com.example.transicion_entre_escenas

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilitar transiciones de ventana (después de super)
        window.sharedElementEnterTransition = TransitionInflater.from(this)
            .inflateTransition(R.transition.change_image_transform)
        window.sharedElementReturnTransition = TransitionInflater.from(this)
            .inflateTransition(R.transition.change_image_transform)

        setContentView(R.layout.activity_detail)

        val image = findViewById<ImageView>(R.id.detailImage)
        // Aseguramos el mismo transitionName en la vista destino
        image.transitionName = "shared_scene"
    }
}