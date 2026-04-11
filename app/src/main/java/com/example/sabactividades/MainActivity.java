package com.example.sabactividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txt1, txt2;
    TextView lbltel, lblnom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt1 = findViewById(R.id.v1etnom);
        txt2 = findViewById(R.id.v1ettel);
        lblnom = findViewById(R.id.v1tvnom);
        lbltel = findViewById(R.id.v1tvtel);

    }

    public void onClick(View view) {
        Intent abrir = null;
        if(view.getId()==R.id.v1btncargar){
            if(validar()==1){
                lblnom.setText("Nombre: "+txt1.getText().toString());
                lbltel.setText("Nombre: "+txt2.getText().toString());
                borrar();
            }
        }
        if(view.getId()==R.id.v1btnenviar){
            if(validar()==1){
                abrir = new Intent(this, Desarrollador.class);
                        Bundle datos= new Bundle();
                datos.putString("nom",txt1.getText().toString());
                datos.putString("tel",txt2.getText().toString());
                abrir.putExtras(datos);
                startActivity(abrir);
                borrar();
            }

        }
        if(view.getId()==R.id.v1btnadivina){
            abrir= new Intent(this, adivina.class);
            startActivity(abrir);

        }



    }
    public int validar(){
        int b= 0;
        if(!txt1.getText().toString().isEmpty() && !txt2.getText().toString().isEmpty()){
            b=1;
        }else if(txt1.getText().toString().isEmpty()){
            Toast.makeText(this, "FALTA NOMBRE", Toast.LENGTH_SHORT).show();
            txt1.requestFocus();
        }else{
            Toast.makeText(this, "FALTA TELEFONO", Toast.LENGTH_SHORT).show();
            txt2.requestFocus();
        }
        return b;
    }
    public void borrar(){
        txt1.setText("");
        txt2.setText("");
        txt1.requestFocus();

    }
}