package com.katy.pr2u4menumultimendia;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //forzar a que cargue el icono en el action bar
       //getSupportActionBar().setDisplayShowHomeEnabled(true);
        //cargar el icono
        //getSupportActionBar().setIcon(R.mipmap.ic_my_icon);


      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_my_icon);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        if(id==R.id.navegador){
            lanzarWeb();
        }else
         if(id==R.id.agenda){
            lanzaAgenda();
        }else
        if(id==R.id.coreo){
            enviarCorreo();
        }else
        if (id==R.id.audio){
            abrirActivityAudio();
        }else
        if(id==R.id.video){
            abrirActivityVideo();
        }



        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void abrirActivityVideo() {
        Intent intentVideo =new Intent(MainActivity.this,videoMediaActivity.class);
        startActivity(intentVideo);
    }


    private void abrirActivityAudio() {
        Intent intentAudio =new Intent(MainActivity.this,audio_Activity.class);
        startActivity(intentAudio);
    }

    private void enviarCorreo() {
        String correo="ady.jack@hotmail.com"  ;
        Intent intentCorreo= new Intent( Intent.ACTION_SENDTO,Uri.parse("mailto:"+correo));
        startActivity(intentCorreo);
    }

    private void lanzaAgenda() {
        Intent intentAgenda = new Intent(Intent.ACTION_VIEW,Uri.parse("content://contacts/people"));
        startActivity( intentAgenda);
    }

    private void lanzarWeb() {
        Intent  intentWeb = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.google.com.mx"));
        startActivity(intentWeb );
    }
}
