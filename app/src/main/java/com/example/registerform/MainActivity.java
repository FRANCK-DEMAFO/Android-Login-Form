package com.example.registerform;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usernname, password, repassword;
    Button btnSignup,btnSignIn;
    DBHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usernname = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        repassword = (EditText)findViewById(R.id.repassword);
        btnSignup =(Button) findViewById(R.id.btnSignup);
        btnSignIn =(Button) findViewById(R.id.btnSignIn);

        myDB = new DBHelper(this);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = usernname.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("") || repass.equals("")){
                    Toast.makeText(MainActivity.this, " Veillez remplir tout les champs", Toast.LENGTH_SHORT).show();
                    
                }
                else{
                    if (pass.equals(repass)){
                      Boolean userchekresult =  myDB.checkusername(user);

                      if(userchekresult==false){

                        Boolean regResult = myDB.insertData(user,pass);

                        if (regResult==true){

                            Toast.makeText(MainActivity.this, "Inscription reussi", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(),LogInActivity.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Inscription non reussit \n reessayer svp", Toast.LENGTH_SHORT).show();
                        }
                      }
                      else{
                          Toast.makeText(MainActivity.this, "Cet utilisateur existe deja.\n effectuer plutot une connection ", Toast.LENGTH_SHORT).show();
                      }
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Mot de passe incorect", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),LogInActivity.class);
                startActivity(intent);

            }
        });

    }
}