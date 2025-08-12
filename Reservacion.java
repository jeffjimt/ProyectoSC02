/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectohotelg5;

/**
 *
 * @author bayro
 */
public class Reservacion {
    
    private String clienteCedula;
    private int numeroHabitacion;
    private String fechaEntrada;
    private String fechaSalida;

    public Reservacion() {
    }

    public Reservacion(String clienteCedula, int numeroHabitacion, String fechaEntrada, String fechaSalida) {
        this.clienteCedula = clienteCedula;
        this.numeroHabitacion = numeroHabitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public String getClienteCedula() {
        return clienteCedula;
    }

    public void setClienteCedula(String clienteCedula) {
        this.clienteCedula = clienteCedula;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
   // Método para mostrar información de la reservación
    public String mostrarInformacion() {
        return "Cédula cliente: " + clienteCedula +
               "\nHabitación: " + numeroHabitacion +
               "\nFecha entrada: " + fechaEntrada +
               "\nFecha salida: " + fechaSalida;
    }

    // Método para cambiar fechas
    public void cambiarFechas(String nuevaEntrada, String nuevaSalida) {
        fechaEntrada = nuevaEntrada;
        fechaSalida = nuevaSalida;
    }
}