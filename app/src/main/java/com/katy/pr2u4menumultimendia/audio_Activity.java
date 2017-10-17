package com.katy.pr2u4menumultimendia;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;

import java.io.IOException;

public class audio_Activity extends AppCompatActivity {
    ImageButton btnPlay,btnStop,btnPause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_);
        btnPlay=(ImageButton)findViewById(R.id.btn_play);
        btnStop=(ImageButton)findViewById(R.id.btn_stop);
        btnPause=(ImageButton)findViewById(R.id.btn_pause);

        //crear el objeto media, para reproducir el audio
        final MediaPlayer mediaPalyer = MediaPlayer.create(getApplicationContext(),R.raw.uno);
       // mediaPalyer.start();
        //Toast.makeText(this,"Reprduciendo Audio",Toast.LENGTH_LONG).show();

        //BOTON PLAY

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPalyer.isPlaying()){
                    //mediaPalyer.pause();
                    //Toast.makeText(audio_Activity.this,"Pausado",Toast.LENGTH_SHORT).show();
                }else{
                    mediaPalyer.start();
                    Toast.makeText(audio_Activity.this,"Reproduciendo",Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Boton pause
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPalyer.isPlaying()) {
                    mediaPalyer.pause();
                    Toast.makeText(audio_Activity.this, "Pausado", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //boton stop
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPalyer.isPlaying()){
                    mediaPalyer.stop();
                    Toast.makeText(audio_Activity.this,"Stop",Toast.LENGTH_SHORT).show();
                    try {
                        mediaPalyer.prepare();

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }

            }
        });
    }
}
