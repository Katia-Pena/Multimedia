package com.katy.pr2u4menumultimendia;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

public class audio_Activity extends AppCompatActivity {
    ImageButton btnPlay,btnStop,btnPause,btnNext,btnPrevius;
    ArrayList<Integer> listaCanciones= new ArrayList<>();
    MediaPlayer mediaPalyer;
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_);
        btnPlay=(ImageButton)findViewById(R.id.btn_play);
        btnStop=(ImageButton)findViewById(R.id.btn_stop);
        btnPause=(ImageButton)findViewById(R.id.btn_pause);
        btnNext=(ImageButton)findViewById(R.id.btn_next);
        btnPrevius=(ImageButton)findViewById(R.id.btn_prev);
        llenarCancionnes();
        //crear el objeto media, para reproducir el audio
         mediaPalyer = MediaPlayer.create(getApplicationContext(),listaCanciones.get(pos));
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

       btnNext.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(mediaPalyer.isPlaying()){
                   mediaPalyer.stop();
                   next();
                   try {
                       mediaPalyer.prepare();

                   }catch (IOException e){
                       e.printStackTrace();
                   }
                   mediaPalyer = MediaPlayer.create(getApplicationContext(),listaCanciones.get(pos));
                   mediaPalyer.start();
               }
           }
       });

        btnPrevius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mediaPalyer.setNextMediaPlayer();
                if(mediaPalyer.isPlaying()){
                    mediaPalyer.stop();
                    previus();
                    try {
                        mediaPalyer.prepare();

                    }catch (IOException e){
                        e.printStackTrace();
                    }
                    mediaPalyer = MediaPlayer.create(getApplicationContext(),listaCanciones.get(pos));
                    mediaPalyer.start();
                }
            }
        });
    }

    private void previus() {
        if(pos-1<0){
            pos=listaCanciones.size()-1;
        }else {
            pos--;
        }
    }

    private void next() {
        if(pos+1>listaCanciones.size()-1){
            pos=0;
        }else {
            pos++;
        }
    }

    private void llenarCancionnes() {
        listaCanciones.add(R.raw.uno);
        listaCanciones.add(R.raw.gaia);
        listaCanciones.add(R.raw.jesus_nowhere);
        listaCanciones.add(R.raw.violin_del_diablo);
    }
}
