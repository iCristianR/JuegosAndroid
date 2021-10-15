package com.example.games_android;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Seleccion extends AppCompatActivity {

    private ListView listView;
    private ArrayList<String> listaActividades;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion);

        String player1 = getIntent().getStringExtra("player1");
        String player2 = getIntent().getStringExtra("player2");
        listView = (ListView) findViewById(R.id.listActividades);
        listaActividades = new ArrayList<>();

        listaActividades.add("Memory");
        listaActividades.add("Triqui");
        listaActividades.add("Créditos");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaActividades);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        intent = new Intent(view.getContext(),Memory.class);
                        break;
                    case 1:
                        intent = new Intent(view.getContext(),Triqui.class);
                        break;
                    case 2:
                        intent = new Intent(view.getContext(),Creditos.class);
                        break;
                }
                intent.putExtra("player1",player1);
                intent.putExtra("player2",player2);
                startActivity(intent);

            }
        });
    }

    public void regresar(View view){
        finish();
    }

}