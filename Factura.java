/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectohotelg5;

/**
 *
 * @author bayro
 */
public class Factura {
    
   private String clienteCedula;
    private double montoTotal;
    private String detalle;

    public Factura() {
    }

    public Factura(String clienteCedula, double montoTotal, String detalle) {
        this.clienteCedula = clienteCedula;
        this.montoTotal = montoTotal;
        this.detalle = detalle;
    }

    public String getClienteCedula() {
        return clienteCedula;
    }

    public void setClienteCedula(String clienteCedula) {
        this.clienteCedula = clienteCedula;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
    
    
    
  public void generarFactura(Reservacion[] reservaciones, Servicio[] servicios, int reservacionesCount, int serviciosCount,
                          String[] serviciosPorCliente, int serviciosPorClienteCount) {
    double total = 0;
    StringBuilder sbDetalle = new StringBuilder();

    // Sumar reservaciones 
    for (int i = 0; i < reservacionesCount; i++) {
        if (reservaciones[i].getClienteCedula().equals(this.clienteCedula)) {
            Reservacion r = reservaciones[i];
            double costoHabitacion = 25000;  
            total += costoHabitacion;
            sbDetalle.append("Habitación No. ").append(r.getNumeroHabitacion())
                .append(" desde ").append(r.getFechaEntrada())
                .append(" hasta ").append(r.getFechaSalida())
                .append(" - ₡").append(costoHabitacion).append("\n");
        }
    }

    // sumar servicios solicitados por el cliente
    boolean encontroServicio;
    for (int i = 0; i < serviciosCount; i++) {
        Servicio s = servicios[i];
        encontroServicio = false;
        for (int j = 0; j < serviciosPorClienteCount; j++) {
            String sc = serviciosPorCliente[j];
            if (sc.equals(this.clienteCedula + "-" + s.getNombre())) {
                encontroServicio = true;
                break;
            }
        }
        if (encontroServicio) {
            total += s.getPrecio();
            sbDetalle.append("Servicio: ").append(s.getNombre())
                .append(" - ₡").append(s.getPrecio()).append("\n");
        }
    }

    this.montoTotal = total;
    this.detalle = sbDetalle.toString();
}

    // Método para mostrar la factura
    public String mostrarFactura() {
        return "Factura para cliente cédula: " + clienteCedula + "\n" +
               "Detalle:\n" + detalle + "\n" +
               "Monto total: ₡" + montoTotal;
    }
}