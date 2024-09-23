package com.example.ud01_3_chronos

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    //val é pa constantes
    val RUNNING_KEY="running"
    val OFFSET_KEY="offset"
    val BASE_KEY="base"
    lateinit var chrono: Chronometer
    var running = false
    var offset=0L //variable que almacena cantos segundos pasaron desde que se lle dou a start

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(RUNNING_KEY,running)
        outState.putLong(OFFSET_KEY,offset)
        outState.putLong(BASE_KEY,chrono.base)
        super.onSaveInstanceState(outState)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        chrono= findViewById<Chronometer>(R.id.chrTemporizador)
        if (savedInstanceState!=null){
            offset=savedInstanceState.getLong("offset")
            running=savedInstanceState.getBoolean("running")
            if (running){
                chrono.base=savedInstanceState.getLong("base")
                chrono.start()
            }
        }
        val btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.setOnClickListener({
            if (!running){
                //garda en que segundo se lle dou a start
                // - Se non estaba iniciado simplemente ponlle o valor do elapsedRealTime
                // - Se estaba iniciado restalle ao elapsedRealTime o offset(o tempo que pasou dende start)
                //      1. Se o elapsedRealTime=24 e o offset=5(significa que o contador iba en 5s) entonces base=19
                //      2. Ao estar a base en 19, o que mostrará por pantalla será elapsedRealTime-base, é dicir 5,
                //          e vai facendo a mesma operación para ir actualizando o que se mostra por pantalla.
                chrono.base=SystemClock.elapsedRealtime() - offset
                chrono.start()
                running=true
            }
        })

        val btnStop=findViewById<Button>(R.id.btnStop)
        btnStop.setOnClickListener(){
            if (running){
                offset=SystemClock.elapsedRealtime() - chrono.base
                chrono.stop()
                running=false
            }
        }

        val btnRestart=findViewById<Button>(R.id.btnRestart)
        btnRestart.setOnClickListener(){
            offset=0L
            chrono.base=SystemClock.elapsedRealtime()
            chrono.stop()
            running=false
        }


    }
}