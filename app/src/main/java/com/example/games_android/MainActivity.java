package com.example.games_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private EditText player1, player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1 = (EditText) findViewById(R.id.etxtPlayer1);
        player2 = (EditText) findViewById(R.id.etxtPlayer2);
    }

    public void jugar(View view){
        String p1 = player1.getText().toString();
        String p2 = player2.getText().toString();

        if(!p1.equals("") && !p2.equals("")){
            Intent intent = new Intent(this, Seleccion.class);
            intent.putExtra("player1", p1);
            intent.putExtra("player2", p2);
            startActivity(intent);
        }else{
            Toast.makeText(this,"Ingrese un nick",Toast.LENGTH_SHORT).show();
        }
    }
}