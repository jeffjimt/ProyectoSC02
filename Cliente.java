/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectohotelg5;

/**
 *
 * @author bayro
 */
public class Cliente {
    private String cedula;
    private String nombre;
    private String correo;

    // Constructor vacío (por si se quiere crear sin datos al inicio)
    public Cliente() {
    }

    // Constructor con parámetros para inicializar directamente los atributos
    public Cliente(String cedula, String nombre, String correo) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
    }

    // Métodos getter y setter para acceder/modificar los atributos
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}