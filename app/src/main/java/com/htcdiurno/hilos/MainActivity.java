package com.htcdiurno.hilos;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText entrada;
    private TextView salida;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entrada = (EditText) findViewById(R.id.entrada);
        salida = (TextView) findViewById(R.id.salida);
    }

    public void calcularOperacion(View view) {

        int n = Integer.parseInt(entrada.getText().toString());

        salida.append(n + "! = ");
        int res = factorial(n);

        MiThread thread = new MiThread(res);

        thread.start();

    }

    public int factorial(int n) {
        int res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
            SystemClock.sleep(1000);
        }

        return res;
    }

    class MiThread extends Thread {
        private int res;

        public MiThread(int res){
            this.res = res;
        }

        @Override
        public void run() {

            //Solución con runOnUIThread================================
            runOnUiThread(new Runnable() {
                @Override public void run() {
                    salida.append(res + "\n");
                }
            });
            //==========================================================
            
        }
    }

}