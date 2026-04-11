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
    TextView lblint;
    EditText txt1;
    Button btn1, btn2;
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
        btn1 = findViewById(R.id.v3btnanalizar);
        btn2 = findViewById(R.id.v3btnretronar);
        btn2.setEnabled(false);
        L = 1;
        ng = (int)(Math.random()*20+1);
        lblint.setText(L+" intento");
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
if(v.getId()== R.id.v3btnanalizar){
if(txt1.getText().toString().isEmpty()){
    Toast.makeText(this, "FALTA EL NUMERO", Toast.LENGTH_SHORT).show();
}else{
    if(Integer.parseInt(txt1.getText().toString())==ng){
        Toast.makeText(this,"GANO",Toast.LENGTH_SHORT).show();
        txt1.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(true);

    }else{
        Toast.makeText(this,"NO ES EL NUMERO", Toast.LENGTH_SHORT).show();
        L++;
        if(L<=5){
            lblint.setText(L+" Intento");
            txt1.setText("");
            txt1.requestFocus();
        }else{
            Toast.makeText(this,"PERDIO, EL NUMERO ERA" +ng, Toast.LENGTH_SHORT).show();
            txt1.setEnabled(false);
            btn1.setEnabled(false);
            btn2.setEnabled(true);
        }
    }
}
}
        if(v.getId()== R.id.v3btnretronar){
finish();
        }
    }
}