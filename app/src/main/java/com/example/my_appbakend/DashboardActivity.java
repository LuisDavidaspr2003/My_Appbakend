package com.example.my_appbakend;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.TextureView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.my_appbakend.databinding.ActivityDashboardBinding;

import java.util.List;

public class DashboardActivity extends AppCompatActivity {


TextView nameuser;
EditText name,email,phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        nameuser = findViewById(R.id.textUser);
        name = findViewById(R.id.txtName);
        email = findViewById(R.id.txtEmail);
        phone = findViewById(R.id.txtPhone);


        Bundle bundle = getIntent().getExtras();

        nameuser.setText(bundle.getString("user"));


    }

    public void Guardar(View view) {
        String nombre = name.getText().toString().trim();
        String correo = email.getText().toString().trim();
        String telefono = phone.getText().toString().trim();

        if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            Toast.makeText(this, "Rellena todas las casillas para guardar", Toast.LENGTH_SHORT).show();
        } else {
            Usuario usuario = new Usuario(nombre, correo, telefono);
            usuario.save();

            Toast.makeText(this, "Usuario guardado correctamente", Toast.LENGTH_SHORT).show();
        }
    }

    public void Consultar(View view) {
        String telefono = phone.getText().toString().trim();

        if (telefono.isEmpty()) {
            Toast.makeText(this, "Ingresa un número de teléfono para consultar", Toast.LENGTH_SHORT).show();
        } else {
            List<Usuario> usuarios = Usuario.find(Usuario.class, "phone=" + telefono, null);
            if (usuarios.isEmpty()) {
                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
            } else {
                Usuario usuario = usuarios.get(0);
                name.setText(usuario.getNombre());
                email.setText(usuario.getEmail());
            }
        }
    }


    public void Eliminar(View view) {
        String telefono = phone.getText().toString().trim();


        if (telefono.isEmpty()) {

            Toast.makeText(this, "Ingresa un número de teléfono", Toast.LENGTH_SHORT).show();
        } else {

            List<Usuario> usuarios = Usuario.find(Usuario.class, "phone=" + telefono, null);
            if (usuarios.isEmpty()) {

                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
            } else {

                Usuario usuario = usuarios.get(0);
                usuario.delete();

                Toast.makeText(this, "Usuario eliminado con éxito", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void Actualizar(View view) {
        String nombre = name.getText().toString().trim();
        String correo = email.getText().toString().trim();
        String telefono = phone.getText().toString().trim();

        if (nombre.isEmpty() || correo.isEmpty() || telefono.isEmpty()) {
            Toast.makeText(this, "Rellena todas las casillas para actualizar", Toast.LENGTH_SHORT).show();
        } else {
            List<Usuario> usuarios = Usuario.find(Usuario.class, "phone=" + telefono, null);
            if (usuarios.isEmpty()) {

                Toast.makeText(this, "El usuario no existe", Toast.LENGTH_SHORT).show();
            } else {
                Usuario usuario = usuarios.get(0);
                usuario.setNombre(nombre);
                usuario.setEmail(correo);
                usuario.save();

                Toast.makeText(this, "Usuario actualizado con éxito", Toast.LENGTH_SHORT).show();
            }
        }
    }




}