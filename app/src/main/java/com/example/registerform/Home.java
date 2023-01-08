package com.example.registerform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnAdd = (Button) findViewById(R.id.btnSignup);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Home.this, "Chargement du formulaire", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), AddActivity.class);

                startActivity(intent);
            }
        });
    }
}