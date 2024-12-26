package com.example.psalavirtual

import android.content.pm.ActivityInfo
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Principal : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    // var posicao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_principal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        getSupportActionBar()?.hide()


        val nome = intent.getStringExtra("EXTRA_NOME")
        //val idade = intent.getStringExtra("EXTRA_IDADE")
        val imagemRodinha = findViewById<ImageView>(R.id.imageRoda)
        val roda = findViewById<AppCompatButton>(R.id.rodinha)
        val mensagemTextView = findViewById<TextView>(R.id.textMensagem)
        //val mensagemTextView2 = findViewById<TextView>(R.id.textMensagem2)
        val imageTarefa = findViewById<ImageView>(R.id.imageTarefa)
        val tarefa = findViewById<AppCompatButton>(R.id.tarefa)
        val imageLanche = findViewById<ImageView>(R.id.imageLanche)
        val lanche = findViewById<AppCompatButton>(R.id.lanche)
        val imageBrincar = findViewById<ImageView>(R.id.imageBrincar)
        val brincar = findViewById<AppCompatButton>(R.id.brincar)
        val imageHistorinha = findViewById<ImageView>(R.id.imageHistorinha)
        val historia = findViewById<AppCompatButton>(R.id.historia)
        val imageCasa = findViewById<ImageView>(R.id.imageCasa)
        val casa = findViewById<AppCompatButton>(R.id.casa)


        mensagemTextView.text = getString(R.string.ola, nome)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        fun tocarAudio(audioResId: Int) {
            mediaPlayer?.release()
            mediaPlayer = MediaPlayer.create(this, audioResId)
            mediaPlayer?.start()
        }

        fun esconderImagens() {
            imagemRodinha.visibility = View.INVISIBLE
            imageTarefa.visibility = View.INVISIBLE
            imageLanche.visibility = View.INVISIBLE
            imageBrincar.visibility = View.INVISIBLE
            imageHistorinha.visibility = View.INVISIBLE
            imageCasa.visibility = View.INVISIBLE
        }

      /*
        fun mensagemErro() {
            mensagemTextView2.text = getString(R.string.aindaNao)
            mensagemTextView2.visibility = View.VISIBLE
            tocarAudio(R.raw.audio_erro)
        }*/

        roda.setOnClickListener {
            esconderImagens()
            imagemRodinha.setImageResource(R.drawable.rodinha)
            imagemRodinha.visibility = View.VISIBLE
           // mensagemTextView2.visibility = View.INVISIBLE
            tocarAudio(R.raw.audio_roda)
        }

        roda.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    roda.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                }
                MotionEvent.ACTION_UP -> {
                    roda.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                    v.performClick()
                }
                MotionEvent.ACTION_CANCEL -> {
                    roda.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                }
            }
            true
        }

        tarefa.setOnClickListener {
            esconderImagens()
            imageTarefa.setImageResource(R.drawable.tarefa)
            imageTarefa.visibility = View.VISIBLE
            //mensagemTextView2.visibility = View.INVISIBLE
            tocarAudio(R.raw.audio_tarefa)
        }

        tarefa.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    tarefa.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                }
                MotionEvent.ACTION_UP -> {
                    tarefa.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                    v.performClick()
                }
                MotionEvent.ACTION_CANCEL -> {
                    tarefa.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                }
            }
            true
        }

        lanche.setOnClickListener {
            esconderImagens()
            imageLanche.setImageResource(R.drawable.lanche)
            imageLanche.visibility = View.VISIBLE
            //mensagemTextView2.visibility = View.INVISIBLE
            tocarAudio(R.raw.audio_lanche)
        }

        lanche.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    lanche.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                }
                MotionEvent.ACTION_UP -> {
                    lanche.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                    v.performClick()
                }
                MotionEvent.ACTION_CANCEL -> {
                    lanche.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                }
            }
            true
        }

        brincar.setOnClickListener {
            esconderImagens()
            imageBrincar.setImageResource(R.drawable.brincadeira)
            imageBrincar.visibility = View.VISIBLE
           // mensagemTextView2.visibility = View.INVISIBLE
            tocarAudio(R.raw.audio_brincar)
        }

        brincar.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    brincar.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                }
                MotionEvent.ACTION_UP -> {
                    brincar.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                    v.performClick()
                }
                MotionEvent.ACTION_CANCEL -> {
                    brincar.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                }
            }
            true
        }

        historia.setOnClickListener {
            esconderImagens()
            imageHistorinha.setImageResource(R.drawable.historinha)
            imageHistorinha.visibility = View.VISIBLE
           // mensagemTextView2.visibility = View.INVISIBLE
            tocarAudio(R.raw.audio_historia)
        }

        historia.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    historia.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                }
                MotionEvent.ACTION_UP -> {
                    historia.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                    v.performClick()
                }
                MotionEvent.ACTION_CANCEL -> {
                    historia.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                }
            }
            true
        }

        casa.setOnClickListener {
            esconderImagens()
            imageCasa.setImageResource(R.drawable.casa)
            imageCasa.visibility = View.VISIBLE
            //mensagemTextView2.visibility = View.INVISIBLE
            tocarAudio(R.raw.audio_casa)
        }

        casa.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    casa.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                }
                MotionEvent.ACTION_UP -> {
                    casa.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                    v.performClick()
                }
                MotionEvent.ACTION_CANCEL -> {
                    casa.setBackgroundColor(ContextCompat.getColor(this, R.color.black))
                }
            }
            true
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}