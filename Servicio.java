/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectohotelg5;

/**
 *
 * @author bayro
 */
// Clase que representa un servicio adicional del hotel (como spa, gimnasio, etc.)
public class Servicio {
    
    private String nombre;
    private double precio;

    public Servicio() {
    }

    public Servicio(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   // Método para mostrar información del servicio
    
    public String mostrarInformacion() {
        return "Servicio: " + nombre + " - Precio: ₡" + precio;
        
    }
}
