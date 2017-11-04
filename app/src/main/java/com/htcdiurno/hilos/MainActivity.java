package com.htcdiurno.hilos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void mostrar_ROUT (View view){
        Intent intent = new Intent (this,ROUT.class);
        startActivity(intent);
    }

    public void mostrar_Post (View view){
        Intent intent = new Intent (this,ConPost.class);
        startActivity(intent);
    }

    public void mostrar_Handler (View view){
        Intent intent = new Intent (this,ConHandler.class);
        startActivity(intent);
    }

}