/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyectohotelg5;
import javax.swing.JOptionPane;
/**
 *
 * @author bayro
 */
public class ProyectoHotelG5 {

    public static void main(String[] args) {
        
        while (true) {
            // Menú principal del sistema
            String opcion = JOptionPane.showInputDialog(
                "¡Bienvenido al Menú Principal del Hotel!\n" +
                "Seleccione el numero de la opción que desea consultar:\n" +
                "-------------------------------------------------------\n" +
                "1. Gestión de Clientes\n" +
                "2. Gestión de Habitaciones\n" +
                "3. Reservaciones\n" +
                "4. Servicios Adicionales\n" +
                "5. Factura\n" +
                "6. Salir"
            );

            switch (opcion) {
                case "1":
                    menuClientes(); // Llama al submenú de clientes
                    break;
                case "2":
                    menuHabitaciones(); // Llama al submenú de habitaciones
                    break;
                case "3":
                    menuReservaciones(); // Llama al submenú de reservaciones
                    break;
                case "4":
                    menuServicios(); // Llama al submenú de servicios
                    break;
                case "5":
                    menuFacturacion(); // Llama al submenú de facturación
                    break;
                case "6":
                    System.exit(0); // Finaliza el programa
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }

    // Submenú de clientes
    static void menuClientes() {
        String opcion = JOptionPane.showInputDialog(
            "Gestión de Clientes:\n" +
            "1. Registrar cliente\n" +
            "2. Consultar historial del cliente\n"
        );
    }

    // Submenú de habitaciones
    static void menuHabitaciones() {
        String opcion = JOptionPane.showInputDialog(
            "Gestión de Habitaciones:\n" +
            "1. Consultar disponibilidad\n" +
            "2. Mostrar todas las habitaciones\n"
        );
    }

    // Submenú de reservaciones
    static void menuReservaciones() {
        String opcion = JOptionPane.showInputDialog(
            "Reservaciones:\n" +
            "1. Realizar reservación\n"
        );
    }

    // Submenú de servicios adicionales
    static void menuServicios() {
        String opcion = JOptionPane.showInputDialog(
            "Servicios Adicionales:\n" +
            "1. Agregar servicio al cliente\n" +
            "2. Mostrar servicios disponibles\n" +
            "3. Eliminar servicio\n"
        );
    }

    // Submenú de facturación
    static void menuFacturacion() {
        String opcion = JOptionPane.showInputDialog(
            "Factura:\n" +
            "1. Generar factura\n" +
            "2. Mostrar factura\n"
        );
    }
}