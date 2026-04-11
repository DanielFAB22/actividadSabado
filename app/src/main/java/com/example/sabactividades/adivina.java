package com.example.sabactividades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class adivina extends AppCompatActivity implements View.OnClickListener {
    TextView lblint, lblpista;
    EditText txt1;
    Button btn1, btn2, btn3;
    int L, ng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_adivina);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txt1 = findViewById(R.id.v3etnum);
        lblint = findViewById(R.id.v3tvint);
        lblpista = findViewById(R.id.v3tvpista);
        btn1 = findViewById(R.id.v3btnanalizar);
        btn2 = findViewById(R.id.v3btnretronar);
        btn3 = findViewById(R.id.v3btnnuevo);

        btn3.setEnabled(false);
        btn2.setEnabled(false);
        L = 1;
        ng = (int) (Math.random() * 20 + 1);
        lblint.setText(L + " intento");
        lblpista.setText("Pista: -");

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.v3btnanalizar) {
            String valorIngresado = txt1.getText().toString();

            if (valorIngresado.isEmpty()) {
                Toast.makeText(this, "FALTA EL NUMERO", Toast.LENGTH_SHORT).show();
            } else {
                int numUsuario = Integer.parseInt(valorIngresado);

                if (numUsuario < 1 || numUsuario > 20) {
                    Toast.makeText(this, "SOLO NÚMEROS ENTRE 1 Y 20", Toast.LENGTH_SHORT).show();
                    txt1.setText("");
                    txt1.requestFocus();
                } else {
                    if (numUsuario == ng) {
                        Toast.makeText(this, "GANO", Toast.LENGTH_SHORT).show();
                        lblpista.setText("¡Correcto!");
                        terminarJuego();
                    } else {

                        int diferencia = Math.abs(numUsuario - ng);

                        if (diferencia <= 3) {
                            lblpista.setText("Pista: ¡Caliente!");
                        } else {
                            lblpista.setText("Pista: Frío");
                        }

                        Toast.makeText(this, "NO ES EL NUMERO", Toast.LENGTH_SHORT).show();
                        L++;
                        if (L <= 5) {
                            lblint.setText(L + " Intento");
                            txt1.setText("");
                            txt1.requestFocus();
                        } else {
                            Toast.makeText(this, "PERDIO, EL NUMERO ERA: " + ng, Toast.LENGTH_SHORT).show();
                            lblpista.setText("Fin del juego");
                            terminarJuego();
                        }
                    }
                }
            }
        } else if (v.getId() == R.id.v3btnretronar) {
            finish();
        } else if (v.getId() == R.id.v3btnnuevo) {
            reiniciarJuego();
        }
    }

    private void terminarJuego() {
        txt1.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
    }

    private void reiniciarJuego() {
        L = 1;
        ng = (int) (Math.random() * 20 + 1);

        lblint.setText(L + " intento");
        lblpista.setText("Pista: -");
        txt1.setText("");
        txt1.setEnabled(true);
        txt1.requestFocus();

        btn1.setEnabled(true);
        btn3.setEnabled(false);
        btn2.setEnabled(false);
    }
}