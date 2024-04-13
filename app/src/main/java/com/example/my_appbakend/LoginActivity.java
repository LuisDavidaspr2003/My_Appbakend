package com.example.my_appbakend;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.my_appbakend.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private EditText usuario,clave;
    private Button btnIngresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usuario = findViewById(R.id.txtUsuario);
        clave = findViewById(R.id.txtClave);

        btnIngresar = findViewById(R.id.btn_Mensaje);


    }
    public void Ingresar(View view){

        String user = usuario.getText().toString();
        String pass = clave.getText().toString();

        if (user.equals("luis") && pass.equals("1234")){
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            intent.putExtra("user", user);
            startActivity(intent);

        }else{
            Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_LONG).show();

        }

    }

    public void Salir(View view) {

        finish();


    }
}