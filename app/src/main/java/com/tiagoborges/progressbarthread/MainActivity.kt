package com.tiagoborges.progressbarthread

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var textView: TextView
    private var progresso : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressBar = findViewById(R.id.progressBar1)
        textView = findViewById(R.id.textViewDate)

        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.post(object : Runnable {
            override fun run() {
                aumentaProgress()
                textView.text = Calendar.getInstance().time.toLocaleString()
                mainHandler.postDelayed(this, 1000)
            }
        })
    }

    fun aumentaProgress() {
        this.progresso += 1
        this.progressBar.progress = progresso
        if(progressBar.progress == 60) {
            progressBar.progress = 0
            this.progresso = 0
        }
    }
}
