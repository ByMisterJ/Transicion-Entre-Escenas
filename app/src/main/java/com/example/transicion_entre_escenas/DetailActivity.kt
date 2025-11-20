package com.example.transicion_entre_escenas

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.view.ViewTreeObserver

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        // retrasamos la transición hasta tener la imagen lista
        postponeEnterTransition()

        super.onCreate(savedInstanceState)

        window.sharedElementEnterTransition = TransitionInflater.from(this)
            .inflateTransition(R.transition.change_image_transform)
        window.sharedElementReturnTransition = TransitionInflater.from(this)
            .inflateTransition(R.transition.change_image_transform)

        setContentView(R.layout.activity_detail)

        val image = findViewById<ImageView>(R.id.detailImage)
        // Aseguramos el mismo transitionName en la vista destino
        image.transitionName = "shared_scene"

        // Recuperamos el id del drawable enviado desde MainActivity
        val imageRes = intent.getIntExtra("image_res", -1)
        if (imageRes != -1) {
            image.setImageResource(imageRes)
        } else {
            // fallback: si quieres que use el recurso local como fallback
            image.setImageResource(R.drawable.escena_frame0)
        }

        // Esperamos a que la vista esté lista para arrancar la transición
        image.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
            override fun onPreDraw(): Boolean {
                image.viewTreeObserver.removeOnPreDrawListener(this)
                startPostponedEnterTransition()
                return true
            }
        })
    }
}