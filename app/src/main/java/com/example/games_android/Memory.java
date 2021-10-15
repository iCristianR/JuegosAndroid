package com.example.games_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Memory extends AppCompatActivity implements View.OnClickListener{

    private TextView lblTurno, lblJugador1, lblJugador2;
    private Button btnA,btnB,btnC,btnD,btnE,btnF,btnG,btnH,btnI;

    String player1 = "", player2 = "", cadena = "", cadenaAux = "";
    int turno = 0, pts1 = 0, pts2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        player1 = getIntent().getStringExtra("player1");
        player2 = getIntent().getStringExtra("player2");
        lblTurno = (TextView) findViewById(R.id.lblTurno);
        lblTurno.setText("Turno "+player1);
        lblJugador1 = (TextView)findViewById(R.id.lblJugador1);
        lblJugador1.setText(player1+"\n0 pts");
        lblJugador2 = (TextView)findViewById(R.id.lblJugador2);
        lblJugador2.setText(player2+"\n0 pts");
        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        btnE = (Button) findViewById(R.id.btnE);
        btnF = (Button) findViewById(R.id.btnF);
        btnG = (Button) findViewById(R.id.btnG);
        btnH = (Button) findViewById(R.id.btnH);
        btnI = (Button) findViewById(R.id.btnI);

        btnA.setOnClickListener(this);
        btnB.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnD.setOnClickListener(this);
        btnE.setOnClickListener(this);
        btnF.setOnClickListener(this);
        btnG.setOnClickListener(this);
        btnH.setOnClickListener(this);
        btnI.setOnClickListener(this);
    }

    //Evento del boton
    @Override
    public void onClick(View v) {
        if (!cadenaAux.equals("")) {
            juegoMemory(v);
        }else{
            cadenaMem(v);
            cadenaAux = cadena;
            turno++;
            lblTurno.setText("Turno "+player2);
            cadena = "";
        }
    }

    //Metodo donde esta contenido toda la logica del juego
    public void juegoMemory(View v){
        //Player 1
        if(turno%2==0){
            lblTurno.setText("Turno "+player1);
            cadenaMem(v);
            //Se valida si la cadena ingresada por el jugador es igual a la del anterio jugador
            //Se corta la cadena una letra antes de terminar
            if (cadena.substring(0, cadena.length()-1).equals(cadenaAux)) {
                cadenaAux = cadena;
                turno++;
                cadena = "";
                lblTurno.setText("Turno "+player2);
            }else{
                //Se valida si la longitud de la cadena ya se supero
                //o es diferente de la cadena del jugador anterior
                if(cadena.length() > cadenaAux.length() && !cadenaAux.equals(cadena)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Secuencia Incorrecta!!");
                    builder.setMessage("Ganador: "+player2);
                    builder.show();
                    pts2++;
                    lblJugador2.setText(player2+"\n"+pts2+" pts");
                    btnA.setEnabled(false);
                    btnB.setEnabled(false);
                    btnC.setEnabled(false);
                    btnD.setEnabled(false);
                    btnE.setEnabled(false);
                    btnF.setEnabled(false);
                    btnG.setEnabled(false);
                    btnH.setEnabled(false);
                    btnI.setEnabled(false);
                }
            }
            //Player 2
        }else{
            lblTurno.setText("Turno "+player2);
            cadenaMem(v);
            if (cadena.substring(0, cadena.length()-1).equals(cadenaAux)) {
                cadenaAux = cadena;
                turno++;
                cadena = "";
                lblTurno.setText("Turno "+player1);
            }else{
                if(cadena.length() > cadenaAux.length() && !cadenaAux.equals(cadena)){
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Secuencia Incorrecta!!");
                    builder.setMessage("Ganador: "+player1);
                    builder.show();
                    pts1++;
                    lblJugador1.setText(player1+"\n"+pts1+" pts");
                    btnA.setEnabled(false);
                    btnB.setEnabled(false);
                    btnC.setEnabled(false);
                    btnD.setEnabled(false);
                    btnE.setEnabled(false);
                    btnF.setEnabled(false);
                    btnG.setEnabled(false);
                    btnH.setEnabled(false);
                    btnI.setEnabled(false);
                }
            }
        }
    }

    //Este metodo nos permite asignar una letra dentro del boton a la cadena
    public void cadenaMem(View v){
        switch (v.getId()){
            case R.id.btnA:
                cadena += btnA.getText().toString();
                break;
            case R.id.btnB:
                cadena += btnB.getText().toString();
                break;
            case R.id.btnC:
                cadena += btnC.getText().toString();
                break;
            case R.id.btnD:
                cadena += btnD.getText().toString();
                break;
            case R.id.btnE:
                cadena += btnE.getText().toString();
                break;
            case R.id.btnF:
                cadena += btnF.getText().toString();
                break;
            case R.id.btnG:
                cadena += btnG.getText().toString();
                break;
            case R.id.btnH:
                cadena += btnH.getText().toString();
                break;
            case R.id.btnI:
                cadena += btnI.getText().toString();
                break;
        }
    }

    public void reiniciar(View view){
        cadena = "";
        cadenaAux = "";
        turno = 0;
        lblTurno.setText("Turno "+player1);
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
        btnE.setEnabled(true);
        btnF.setEnabled(true);
        btnG.setEnabled(true);
        btnH.setEnabled(true);
        btnI.setEnabled(true);
    }

    public void regresar(View view){
        finish();
    }

}