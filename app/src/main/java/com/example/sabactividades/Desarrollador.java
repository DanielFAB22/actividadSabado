package com.example.sabactividades;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Desarrollador extends AppCompatActivity {
    TextView lblnom, lbltel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_desarrollador);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        lblnom = findViewById(R.id.v2tvnom);
        lblnom = findViewById(R.id.v2tvtel);
        Bundle datos = this.getIntent().getExtras();
        lblnom.setText("Nombre: "+datos.getString("nom"));
        lbltel.setText("Telefono: "+datos.getString("tel"));
    }

    public void onClick(View view) {
        finish();
    }
}