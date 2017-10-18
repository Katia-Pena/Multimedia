package com.katy.pr2u4menumultimendia;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IllegalFormatException;

public class videoMediaActivity extends AppCompatActivity {
    SurfaceHolder surfaceHolder;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_media);
        //crear un objeto Uri,para cargar el objeto mediaPlayer
        Uri miUri = Uri.parse("android.resourse://"+getPackageName()+"/"+R.raw.video);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        //loop
        mediaPlayer .setLooping(true);
        try{
            mediaPlayer.setDataSource(getApplicationContext(),miUri);
        }catch (IOException e){
            e.printStackTrace();

        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }catch (SecurityException e){
            e.printStackTrace();
        }
        //cargar el surfaceView al video
        SurfaceView surfaceView = (SurfaceView)findViewById(R.id.surface);
        surfaceHolder = surfaceView.getHolder();
        //Evitar que el dispositivo entre a musica
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer.setDisplay(surfaceHolder);
                try{
                    mediaPlayer.prepare();
                }catch (IOException e){
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });{

        }
    }
}
