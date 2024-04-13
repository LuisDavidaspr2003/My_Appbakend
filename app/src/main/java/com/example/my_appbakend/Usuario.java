package com.example.my_appbakend;

import com.orm.SugarRecord;

public class Usuario extends SugarRecord<Usuario> {

    private String nombre;
   private String email;
   private String phone;


    public Usuario(String nombre, String email, String phone) {
        this.nombre = nombre;
        this.email = email;
        this.phone = phone;
    }

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
