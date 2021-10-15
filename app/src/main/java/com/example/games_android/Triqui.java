package com.example.games_android;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Triqui extends AppCompatActivity implements View.OnClickListener{

    private TextView lblTurno, lblJugador1, lblJugador2 ;
    private ImageButton ibtn1,ibtn2,ibtn3,ibtn4,ibtn5,ibtn6,ibtn7,ibtn8,ibtn9;
    String player1 = "", player2 = "", ganador = "";

    int turno = 0, pts1 = 0, pts2 = 0;;
    int[][] posGanar = {{0,1,2},{3,4,5},{6,7,8}, //Filas
                        {0,3,6},{1,4,7},{2,5,8}, //Columnas
                        {0,4,8},{2,4,6}}; //Cruz
    int[] posJugador = {0,0,0,
                        0,0,0,
                        0,0,0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triqui);

        player1 = getIntent().getStringExtra("player1");
        player2 = getIntent().getStringExtra("player2");
        lblTurno = (TextView)findViewById(R.id.lblTurno2);
        lblTurno.setText("Turno " + player1);
        lblJugador1 = (TextView)findViewById(R.id.lblJugador1);
        lblJugador1.setText(player1+"\n0 pts");
        lblJugador2 = (TextView)findViewById(R.id.lblJugador2);
        lblJugador2.setText(player2+"\n0 pts");
        ibtn1 = (ImageButton)findViewById(R.id.ibtn1);
        ibtn2 = (ImageButton)findViewById(R.id.ibtn2);
        ibtn3 = (ImageButton)findViewById(R.id.ibtn3);
        ibtn4 = (ImageButton)findViewById(R.id.ibtn4);
        ibtn5 = (ImageButton)findViewById(R.id.ibtn5);
        ibtn6 = (ImageButton)findViewById(R.id.ibtn6);
        ibtn7 = (ImageButton)findViewById(R.id.ibtn7);
        ibtn8 = (ImageButton)findViewById(R.id.ibtn8);
        ibtn9 = (ImageButton)findViewById(R.id.ibtn9);

        ibtn1.setOnClickListener(this);
        ibtn2.setOnClickListener(this);
        ibtn3.setOnClickListener(this);
        ibtn4.setOnClickListener(this);
        ibtn5.setOnClickListener(this);
        ibtn6.setOnClickListener(this);
        ibtn7.setOnClickListener(this);
        ibtn8.setOnClickListener(this);
        ibtn9.setOnClickListener(this);
    }

    /*
    Evento que controla el click del boton
     */
    @Override
    public void onClick(View v) {
        cambioBoton(v,turno);
        if (ganador()==true) {
            ganador = lblTurno.getText().toString();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            if(ganador.contains(player1)){
                builder.setTitle("Triqui!!");
                builder.setMessage("Ganador: "+player2);
                builder.show();
                pts2++;
                lblJugador2.setText(player2+"\n"+pts2+" pts");
            }else{
                builder.setTitle("Triqui!!");
                builder.setMessage("Ganador: "+player1);
                builder.show();
                pts1++;
                lblJugador1.setText(player1+"\n"+pts1+" pts");
            }
            ibtn1.setEnabled(false);
            ibtn2.setEnabled(false);
            ibtn3.setEnabled(false);
            ibtn4.setEnabled(false);
            ibtn5.setEnabled(false);
            ibtn6.setEnabled(false);
            ibtn7.setEnabled(false);
            ibtn8.setEnabled(false);
            ibtn9.setEnabled(false);
        }
        if(turno == 9 && ganador()==false){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Empate");
            builder.setMessage("Intentalo de nuevo");
            builder.show();
        }
    }

    /*
    La variable pos es el iterador que recorrera las 8 filas de la matriz

    Dentro del if se verifica si el dato dentro del arreglo de posicion jugador, se encuentra
    en alguna posicion de la matriz (Filas, Columnas y Cruz)
        012
       0***
       1***
       2***
    3 primeros pasos -> recorre filas en la posicion indicada
    3 siguientes pasos -> recorre columnas en la posicion indicada
    2 ultimos pasos -> recorre en forma de cruz en la posicion indicada
     */
    public boolean ganador(){
        boolean band = false;
        for(int i=0;i<posGanar.length;i++){
            for(int j=0;j<posGanar[0].length;j++){
                if(posJugador[posGanar[i][1]] == posJugador[posGanar[i][2]]
                        && posJugador[posGanar[i][2]] == posJugador[posGanar[i][0]]
                            && posJugador[posGanar[i][1]] != 0){
                    band=true;
                }
            }
        }
        return band;
    }

    /*
    Permite hacer el cambio de la imagen en el boton, ademas de indicar la posicion
    del boton que eligio el jugador
     */
    public void cambioBoton(View v,int n){
        switch (v.getId()){
            case R.id.ibtn1:
                if(n%2==0){
                    ibtn1.setImageResource(R.drawable.circulo);
                    posJugador[0] = 1;
                    lblTurno.setText("Turno "+player2);
                }else{
                    ibtn1.setImageResource(R.drawable.cruz);
                    posJugador[0] = 2;
                    lblTurno.setText("Turno "+player1);
                }
                ibtn1.setEnabled(false);
                break;
            case R.id.ibtn2:
                if(n%2==0){
                    ibtn2.setImageResource(R.drawable.circulo);
                    posJugador[1] = 1;
                    lblTurno.setText("Turno "+player2);
                }else{
                    ibtn2.setImageResource(R.drawable.cruz);
                    posJugador[1] = 2;
                    lblTurno.setText("Turno "+player1);
                }
                ibtn2.setEnabled(false);
                break;
            case R.id.ibtn3:
                if(n%2==0){
                    ibtn3.setImageResource(R.drawable.circulo);
                    posJugador[2] = 1;
                    lblTurno.setText("Turno "+player2);
                }else{
                    ibtn3.setImageResource(R.drawable.cruz);
                    posJugador[2] = 2;
                    lblTurno.setText("Turno "+player1);
                }
                ibtn3.setEnabled(false);
                break;
            case R.id.ibtn4:
                if(n%2==0){
                    ibtn4.setImageResource(R.drawable.circulo);
                    posJugador[3] = 1;
                    lblTurno.setText("Turno "+player2);
                }else{
                    ibtn4.setImageResource(R.drawable.cruz);
                    posJugador[3] = 2;
                    lblTurno.setText("Turno "+player1);
                }
                ibtn4.setEnabled(false);
                break;
            case R.id.ibtn5:
                if(n%2==0){
                    ibtn5.setImageResource(R.drawable.circulo);
                    posJugador[4] = 1;
                    lblTurno.setText("Turno "+player2);
                }else{
                    ibtn5.setImageResource(R.drawable.cruz);
                    posJugador[4] = 2;
                    lblTurno.setText("Turno "+player1);
                }
                ibtn5.setEnabled(false);
                break;
            case R.id.ibtn6:
                if(n%2==0){
                    ibtn6.setImageResource(R.drawable.circulo);
                    posJugador[5] = 1;
                    lblTurno.setText("Turno "+player2);
                }else{
                    ibtn6.setImageResource(R.drawable.cruz);
                    posJugador[5] = 2;
                    lblTurno.setText("Turno "+player1);
                }
                ibtn6.setEnabled(false);
                break;
            case R.id.ibtn7:
                if(n%2==0){
                    ibtn7.setImageResource(R.drawable.circulo);
                    posJugador[6] = 1;
                    lblTurno.setText("Turno "+player2);
                }else{
                    ibtn7.setImageResource(R.drawable.cruz);
                    posJugador[6] = 2;
                    lblTurno.setText("Turno "+player1);
                }
                ibtn7.setEnabled(false);
                break;
            case R.id.ibtn8:
                if(n%2==0){
                    ibtn8.setImageResource(R.drawable.circulo);
                    posJugador[7] = 1;
                    lblTurno.setText("Turno "+player2);
                }else{
                    ibtn8.setImageResource(R.drawable.cruz);
                    posJugador[7] = 2;
                    lblTurno.setText("Turno "+player1);
                }
                ibtn8.setEnabled(false);
                break;
            case R.id.ibtn9:
                if(n%2==0){
                    ibtn9.setImageResource(R.drawable.circulo);
                    posJugador[8] = 1;
                    lblTurno.setText("Turno "+player2);
                }else{
                    ibtn9.setImageResource(R.drawable.cruz);
                    posJugador[8] = 2;
                    lblTurno.setText("Turno "+player1);
                }
                ibtn9.setEnabled(false);
                break;
        }
        turno++;
    }

    public void regresar(View view){
        finish();
    }

    public void reiniciar(View view){
        turno = 0;
        lblTurno.setText("Turno "+player1);
        for(int x=0;x<posJugador.length;x++){
            posJugador[x] = 0;
        }
        ibtn1.setImageResource(R.drawable.tapar);
        ibtn2.setImageResource(R.drawable.tapar);
        ibtn3.setImageResource(R.drawable.tapar);
        ibtn4.setImageResource(R.drawable.tapar);
        ibtn5.setImageResource(R.drawable.tapar);
        ibtn6.setImageResource(R.drawable.tapar);
        ibtn7.setImageResource(R.drawable.tapar);
        ibtn8.setImageResource(R.drawable.tapar);
        ibtn9.setImageResource(R.drawable.tapar);
        ibtn1.setEnabled(true);
        ibtn2.setEnabled(true);
        ibtn3.setEnabled(true);
        ibtn4.setEnabled(true);
        ibtn5.setEnabled(true);
        ibtn6.setEnabled(true);
        ibtn7.setEnabled(true);
        ibtn8.setEnabled(true);
        ibtn9.setEnabled(true);
    }
}