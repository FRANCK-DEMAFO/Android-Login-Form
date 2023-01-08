package com.example.registerform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {
    EditText username, password;
    Button btnSignIn;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);
        myDB = new DBHelper(this);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals("")){
                    Toast.makeText(LogInActivity.this, " Veuillez Remplir Tout les champs", Toast.LENGTH_SHORT).show();
                }
                else{
                   Boolean result = myDB.checkUsernamePassword(user,pass);

                   if (result.equals(true)){
                       Toast.makeText(LogInActivity.this, "Connexion reussit", Toast.LENGTH_SHORT).show();
                       Intent intent = new Intent(getApplicationContext(),Home.class);
                       startActivity(intent);
                   }
                   else{
                       Toast.makeText(LogInActivity.this, "Informations Incorrect.\n Inscrivez Vous si vous n'avez pas de compte", Toast.LENGTH_SHORT).show();
                   }
                }

            }
        });

    }
}