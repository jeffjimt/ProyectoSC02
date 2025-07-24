/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectohotelg5;

/**
 *
 * @author bayro
 */
public class Habitacion {
    
   private int numero;
    private String tipo;
    private boolean disponible; 

    public Habitacion() {
    }

    public Habitacion(int numero, String tipo, boolean disponible) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = disponible;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
