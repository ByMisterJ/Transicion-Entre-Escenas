package com.example.transicion_entre_escenas

import android.net.Uri
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.MediaController
import android.widget.VideoView


class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
// Habilitar transiciones de ventana desde styles.xml
        window.sharedElementEnterTransition = TransitionInflater.from(this)
            .inflateTransition(R.transition.change_image_transform)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val image = findViewById<ImageView>(R.id.detailImage)
        image.transitionName = "shared_scene"


    }
}