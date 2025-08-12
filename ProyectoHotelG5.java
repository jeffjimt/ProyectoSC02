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
    
    // Variables globales para guardar datos
    public static Cliente[] clientes = new Cliente[100];
    public static int clientesCount = 0;

    public static Habitacion[] habitaciones = new Habitacion[50];
    public static int habitacionesCount = 0;

    public static Reservacion[] reservaciones = new Reservacion[100];
    public static int reservacionesCount = 0;

    public static Servicio[] servicios = new Servicio[50];
    public static int serviciosCount = 0;

    public static Factura factura = new Factura();
    private static int serviciosPorClienteCount;
    private static String[] serviciosPorCliente;
    
    

    public static void main(String[] args) {
        
        inicializarDatos();
        
        
        
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
    
    static void inicializarDatos() {
        
        habitaciones[0] = new Habitacion(101, "Simple", true);
        habitaciones[1] = new Habitacion(102, "Doble", true);
        habitaciones[2] = new Habitacion(103, "Suite", true);
        habitacionesCount = 3;

        servicios[0] = new Servicio("Spa", 15000);
        servicios[1] = new Servicio("Desayuno", 8000);
        servicios[2] = new Servicio("Taxi", 10000);
        serviciosCount = 3;
        serviciosPorCliente = new String[100];  
        serviciosPorClienteCount = 0;
    }
    
    
    // Submenú de clientes
    static void menuClientes() {
        String opcion = JOptionPane.showInputDialog(
            "Gestión de Clientes:\n" +
            "1. Registrar cliente\n" +
            "2. Consultar historial del cliente\n" +
            "3. Volver"
        );
        switch (opcion) {
            case "1":
                registrarCliente();
                break;
            case "2":
                consultarHistorialCliente();
                break;
            case "3":
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    static void registrarCliente() {
        if (clientesCount >= clientes.length) {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más clientes");
            return;
        }
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
        // Validar si ya existe
        for (int i = 0; i < clientesCount; i++) {
            if (clientes[i].getCedula().equals(cedula)) {
                JOptionPane.showMessageDialog(null, "Ya existe un cliente con esa cédula.");
                return;
            }
        }

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del cliente:");
        String correo = JOptionPane.showInputDialog("Ingrese el correo del cliente:");
        clientes[clientesCount++] = new Cliente(cedula, nombre, correo);
        JOptionPane.showMessageDialog(null, "Cliente registrado");
    }

    static void consultarHistorialCliente() {
    String cedula = JOptionPane.showInputDialog("Ingrese la cedula del cliente:");
    Cliente c = buscarClientePorCedula(cedula);
    if (c != null) {
        // Información base del historial
        String historial = c.mostrarHistorial();

        // Añadir reservaciones reales del cliente
        historial += "\nReservaciones realizadas:\n";
        boolean tieneReservaciones = false;
        for (int i = 0; i < reservacionesCount; i++) {
            if (reservaciones[i].getClienteCedula().equals(cedula)) {
                tieneReservaciones = true;
                historial += "- Habitación No. " + reservaciones[i].getNumeroHabitacion() +
                             ", desde " + reservaciones[i].getFechaEntrada() +
                             " hasta " + reservaciones[i].getFechaSalida() + "\n";
            }
        }
        if (!tieneReservaciones) {
            historial += "No se han realizado reservaciones\n";
        }

        JOptionPane.showMessageDialog(null, historial);
    } else {
        JOptionPane.showMessageDialog(null, "Cliente no encontrado");
    }
}

    static Cliente buscarClientePorCedula(String cedula) {
        for (int i = 0; i < clientesCount; i++) {
            if (clientes[i].getCedula().equals(cedula)) {
                return clientes[i];
            }
        }
        return null;
    
    }

    // Submenú de habitaciones
    public static void menuHabitaciones() {
        String opcion = JOptionPane.showInputDialog(
            "Gestión de Habitaciones:\n" +
            "1. Mostrar todas las habitaciones para elegir\n" +
            "2. Consultar disponibilidad\n" +
            "3. Volver"       
        );
        
        switch (opcion) {
            case "1":
                mostrarTodasHabitaciones();
                break;
            case "2":
                consultarDisponibilidad();
                break;
            case "3":
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    public static Habitacion buscarHabitacionPorNumero(int numero) {
        for (int i = 0; i < habitacionesCount; i++) {
            if (habitaciones[i].getNumero() == numero) {
                return habitaciones[i];
            }
        }
        return null;
    }
    
    public static void mostrarTodasHabitaciones() {
        if (habitacionesCount == 0) {
            JOptionPane.showMessageDialog(null, "No hay habitaciones registradas.");
            return;
         }
        String info = "";
        for (int i = 0; i < habitacionesCount; i++) {
            info += habitaciones[i].mostrarInformacion() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, info);
    
        
    }
    
    public static void consultarDisponibilidad() {
        String numStr = JOptionPane.showInputDialog("Ingrese número de habitación:");
        try {
            int num = Integer.parseInt(numStr);
            Habitacion h = buscarHabitacionPorNumero(num);
            if (h != null) {
                JOptionPane.showMessageDialog(null, "Habitación " + num + " está " + (h.isDisponible() ? "Disponible" : "Ocupada"));
            } else {
                JOptionPane.showMessageDialog(null, "Habitación no encontrada");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Número no válido");
        }
    }

    // Submenú de reservaciones
    
    public static void menuReservaciones() {
        String opcion = JOptionPane.showInputDialog(
            "Reservaciones:\n" +
            "1. Realizar reservación\n" +
            "2. Volver"
        );
        
        switch (opcion) {
            case "1":
                realizarReservacion();
                break;
            case "2":
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opción no válida");
        }
    }

    public static void realizarReservacion() {
        if (reservacionesCount >= reservaciones.length) {
            JOptionPane.showMessageDialog(null, "No se pueden agregar más reservaciones.");
            return;
        }
        String cedula = JOptionPane.showInputDialog("Ingrese cédula del cliente:");
        Cliente c = buscarClientePorCedula(cedula);
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            return;
        }
        String numHabStr = JOptionPane.showInputDialog("Ingrese número de habitación:");
        int numHab;
        try {
            numHab = Integer.parseInt(numHabStr);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Número inválido");
            return;
        }
        Habitacion hab = buscarHabitacionPorNumero(numHab);
        if (hab == null) {
            JOptionPane.showMessageDialog(null, "Habitación no encontrada");
            return;
        }
        if (!hab.isDisponible()) {
            JOptionPane.showMessageDialog(null, "Habitación no disponible");
            return;
        }
        String fechaEntrada = JOptionPane.showInputDialog("Ingrese fecha de entrada (Dia/Mes/Año):");
        String fechaSalida = JOptionPane.showInputDialog("Ingrese fecha de salida (Dia/Mes/Año):");
        if (fechaEntrada.isEmpty() || fechaSalida.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Las fechas no pueden estar vacías.");
            return;
        }
        reservaciones[reservacionesCount++] = new Reservacion(cedula, numHab, fechaEntrada, fechaSalida);
        hab.setDisponible(false);
        JOptionPane.showMessageDialog(null, "Reservación realizada");
    
    }

    // Submenú de servicios adicionales
    public static void menuServicios() {
        String opcion = JOptionPane.showInputDialog(
            "Servicios Adicionales:\n" +
            "1. Mostrar servicios disponibles para elegir\n" +
            "2. Agregar servicio a cliente\n" + 
            "3. Eliminar servicio\n" +
            "4. Volver"
        );
        
        
        
        switch (opcion) {
            case "1":
                mostrarServicios();
                break;
            case "2":
                agregarServicioAlCliente(); 
                break;
            case "3":
            eliminarServicio();
                break;
            case "4":
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opción no valida");
        }
    }
    
    public static void mostrarServicios() {
        if (serviciosCount == 0) {
            JOptionPane.showMessageDialog(null, "No hay servicios disponibles.");
            return;
        }
        String info = "";
        for (int i = 0; i < serviciosCount; i++) {
            info += servicios[i].mostrarInformacion() + "\n";
        }
        JOptionPane.showMessageDialog(null, info);
    }
   

  static void agregarServicioAlCliente() {
    String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente:");
    Cliente c = buscarClientePorCedula(cedula);
    if (c == null) {
        JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        return;
    }

    String listaServicios = "Seleccione el número del servicio a agregar:\n";
    for (int i = 0; i < serviciosCount; i++) {
        listaServicios += (i + 1) + ". " + servicios[i].getNombre() + "\n";
    }

    String opcionServicioStr = JOptionPane.showInputDialog(listaServicios);
    int opcionServicio;
    try {
        opcionServicio = Integer.parseInt(opcionServicioStr);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Opción inválida.");
        return;
    }

    if (opcionServicio < 1 || opcionServicio > serviciosCount) {
        JOptionPane.showMessageDialog(null, "Número de servicio fuera de rango.");
        return;
    }

    String nombreServicio = servicios[opcionServicio - 1].getNombre();

    if (serviciosPorClienteCount < serviciosPorCliente.length) {
        serviciosPorCliente[serviciosPorClienteCount++] = cedula + "-" + nombreServicio;
        JOptionPane.showMessageDialog(null, "Servicio '" + nombreServicio + "' agregado al cliente.");
        return;  // Evita seguir ejecutando y posibles errores
    } else {
        JOptionPane.showMessageDialog(null, "No se pueden agregar más servicios a clientes.");
        return;
    }
}

    public static void eliminarServicio() {
        String nombre = JOptionPane.showInputDialog("Ingrese nombre del servicio a eliminar:");
        boolean eliminado = false;
        for (int i = 0; i < serviciosCount; i++) {
            if (servicios[i].getNombre().equalsIgnoreCase(nombre)) {
                for (int j = i; j < serviciosCount - 1; j++) {
                    servicios[j] = servicios[j + 1];
                }
                serviciosCount--;
                eliminado = true;
                break;
            }
        }
        if (eliminado) {
            JOptionPane.showMessageDialog(null, "Servicio eliminado.");
        } else {
            JOptionPane.showMessageDialog(null, "Servicio no encontrado.");
        }
    
    }

    // Submenú de facturación
    public static void menuFacturacion() {
        String opcion = JOptionPane.showInputDialog(
            "Factura:\n" +
            "1. Generar factura\n" +
            "2. Mostrar factura\n" +
            "3. Volver"
        );
        switch (opcion) {
            case "1":
                generarFactura();
                break;
            case "2":
                mostrarFactura();
                break;
            case "3":
                return;
            default:
                JOptionPane.showMessageDialog(null, "Opción no valida");
        }
    }

    public static void generarFactura() {
        String cedula = JOptionPane.showInputDialog("Ingrese la cédula del cliente para generar factura:");
        Cliente c = buscarClientePorCedula(cedula);
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado");
            return;
        }
        factura.setClienteCedula(cedula);
        factura.generarFactura(reservaciones, servicios, reservacionesCount, serviciosCount, serviciosPorCliente, serviciosPorClienteCount);
        JOptionPane.showMessageDialog(null, "Factura generada");
    }

    public static void mostrarFactura() {
        if (factura.getClienteCedula() == null || factura.getClienteCedula().equals("")) {
            JOptionPane.showMessageDialog(null, "No hay factura generada.");
        } else {
            JOptionPane.showMessageDialog(null, factura.mostrarFactura());
        }
    }
}