package com.example.feni.share;

import android.app.Service;
import android.content.Intent;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.toolbox.Volley;
import javax.swing.*;
import java.lang.ref.ReferenceQueue;
import java.net.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;

import static android.R.id.text1;

public class MainActivity extends AppCompatActivity {

        Button b1;
       public EditText ed2;
       public String Pass1;
    String val1;
       static String port="4907";
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            b1 = (Button)findViewById(R.id.button);
            ed2 = (EditText)findViewById(R.id.editText2);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Pass1= ed2.getText().toString();
                 new InitConnection(Integer.parseInt(port),Pass1);
                    ReferenceQueue request1;

                }
            });
        }
 /*   public void actionPerformed(ActionEvent ae) {
        Pass1 = ed2.getText().toString();
       // dispose();
        new InitConnection(Integer.parseInt(port), Pass1);
    }*/
            public String getValue_1(){
                return Pass1;
            }
  }
