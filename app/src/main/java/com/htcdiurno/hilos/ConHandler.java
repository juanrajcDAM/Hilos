package com.htcdiurno.hilos;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ConHandler extends AppCompatActivity {
    private EditText entrada;
    private TextView salida;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con_post);
        entrada = (EditText) findViewById(R.id.entrada3);
        salida = (TextView) findViewById(R.id.salida3);
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

            //Solución con Handler======================================
            Message msg = new Message();
            msg.obj=(res+"\n");
            puente.sendMessage(msg);

        }
    }

    private Handler puente = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            salida.append((String)msg.obj);
        }
    };
    //===================================================================
}
