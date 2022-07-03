package com.whydanu.kalkulator_sederhana;

import androidx.appcompat.app.AppCompatActivity;

//import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnpersen,btnkurang,btnkali,btntambah,btnbagi,btnhapus,btntitik,btnbackspace,btnhasil;
    TextView angkamasuk,angkakeluar;
    String process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button angka
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        //button itung, keluar masuk
        btntambah = findViewById(R.id.btntambah);
        btnkurang = findViewById(R.id.btnkurang);
        btnkali = findViewById(R.id.btnkali);
        btnbagi = findViewById(R.id.btnbagi);

        btntitik = findViewById(R.id.btntitik);
        btnpersen = findViewById(R.id.btnpersen);
        btnhasil = findViewById(R.id.btnhasil);
        btnhapus = findViewById(R.id.btnhapus);
        btnbackspace = findViewById(R.id.btnbackspace);

        angkamasuk = findViewById(R.id.angkamasuk);
        angkakeluar = findViewById(R.id.angkakeluar);

        //tombol klik button
        btnhapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                angkamasuk.setText("");
                angkakeluar.setText("");
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"9");
            }
        });
        btntambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"+");
            }
        });
        btnkurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"-");
            }
        });
        btnbagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"/");
            }
        });
        btnkali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"*");
            }
        });
        btnpersen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+"%");
            }
        });
        btnbackspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = angkamasuk.getText().toString();
                int input = word.length();
                if (input > 0){
                    angkamasuk.setText(word.substring(0,input-1));
                }
            }
        });
        btntitik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();
                angkamasuk.setText(process+".");
            }
        });

        //botton "=" untuk hasil
        btnhasil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = angkamasuk.getText().toString();

                process = process.replaceAll("x","*");
                process = process.replaceAll("%","/100");
                process = process.replaceAll(":","/");

                Context rhino = Context.enter();

                rhino.setOptimizationLevel(-1);

                String finalResult = "";

                try{
                    Scriptable scriptable = rhino.initSafeStandardObjects();
                    finalResult= rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="0";

                }
                angkakeluar.setText(finalResult);
            }
        });

    }
}