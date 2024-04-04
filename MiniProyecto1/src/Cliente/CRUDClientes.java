package Cliente;
import java.util.Scanner;
import java.util.ArrayList;

public class CRUDClientes { // Este es la clase que abarca toda la funcionalidad de la aplicación como sus funciones y el vector clientes.
    private static ArrayList<Clientes> clientes; // Creación de un vector.
    Scanner scanner = new Scanner(System.in);

    public CRUDClientes() { // Función de crear un nuevo vector para los clientes cliente.
        clientes = new ArrayList<>();
    }

    public void crearCliente(Clientes cliente) { // Función crear cliente.
        clientes.add(cliente);
    }

    public static Clientes buscarCedula(long cedula) { // Función para buscar cliente por cedula.
        for (Clientes cliente : clientes) {
            if (cliente.getCedula() == cedula) {
                return cliente;
            }
        }
        return null;
    }

    public void insertarDinero(long cedula, double cantidadDinero) { // Función para insertar mas dinero a la cuenta del cliente.
        Clientes cliente = buscarCedula(cedula);
        if (cliente != null) {
            double dineroActual = cliente.getDineroAhorrado();
            cliente.setDineroAhorrado(dineroActual + cantidadDinero);
            System.out.println("Dinero agregado correctamente al cliente " + cliente.getNombre());
        } else {
            System.out.println("Cliente con la cédula " + cedula + " no encontrado.");
        }
    }

    public void actualizarDinero(long cedula, double cantidadDinero) { // Función para actualizar el dinero del cliente.
        Clientes cliente = buscarCedula(cedula);
        if (cliente != null) {
            double dineroActual = cliente.getDineroAhorrado();
            if (cantidadDinero == dineroActual || cantidadDinero <= dineroActual || cantidadDinero >= dineroActual) {
                cliente.setDineroAhorrado(dineroActual = cantidadDinero);
                System.out.println("Dinero actualizado correctamente del cliente " + cliente.getNombre());
            } else {
                System.out.println("No se puede actualizar esa cantidad de dinero!!");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void eliminarDinero(long cedula, double cantidadDinero) { // Función para eliminar dinero de la cuenta del cliente.
        Clientes cliente = buscarCedula(cedula);
        if (cliente != null) {
            double dineroActual = cliente.getDineroAhorrado();
            if (cantidadDinero <= dineroActual) {
                cliente.setDineroAhorrado(dineroActual - cantidadDinero);
                System.out.println("Dinero eliminado correctamente del cliente " + cliente.getNombre());
            } else {
                System.out.println("No se puede eliminar esa cantidad de dinero!!");
            }
        } else {
            System.out.println("Cliente no encontrado.");
        }
    }

    public void buscarCliente(String nombre) { // Función para buscar a un cliente por su nombre.
        for (Clientes cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(cliente);
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public void listarClientes() { // Función para listar todos los clientes.
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Clientes cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    public void SolicitudPrestamo(long cedula) { // Función para solicitar un préstamo.

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados en el sistema.");
        } else{
            Clientes cliente = buscarCedula(cedula);
    
            if (cliente != null) {
                double ahorroCliente = cliente.getDineroAhorrado();
                double creditoMaximo = ahorroCliente * 2;
                System.out.println("Ingrese el monto de la solicitud del préstamo: ");
                double valorPrestamo = scanner.nextDouble();
                scanner.nextLine(); 
    
                if (valorPrestamo >= 1 && valorPrestamo <= creditoMaximo) {
                    if (valorPrestamo <= ahorroCliente) {
                        double saldoFinal = ahorroCliente - valorPrestamo;
                        cliente.setDineroAhorrado(saldoFinal);
                        System.out.println("el préstamo solicitado por un valor de "+ valorPrestamo +
                        " del cliente ha sido aprobado su saldo restante es de: " + saldoFinal);
                    } else {
                        double valorExcedido = valorPrestamo - ahorroCliente;
                        ahorroCliente =0;
                        cliente.setDineroAhorrado(ahorroCliente);
                        System.out.println("el préstamo solicitado por un valor de "+ valorPrestamo +
                            " del cliente ha sido aprobado su saldo restante es de: " + ahorroCliente); 
                        System.out.println("El valor del préstamo es mayor a lo ahorrado, el excedente es: "+ valorExcedido);
                        double interesAnual = 0.02;
                        double interesMensual = (interesAnual/12);
                        double meses = 6; 
                        double interes = valorExcedido * (Math.pow(1 + (interesMensual), meses));
                        double cuotaMensual = (interes/6);
        
                        System.out.println("El valor de la cuota mensual del cliente con número de cédula "+ cedula + 
                        " es: " + cuotaMensual);
                    }
                }else{

                    System.out.println("No se puede realizar el préstamo. \nNo tienes nada ahorrado o el valor del préstamo no esta permitido o excede su crédito, solo puede ser el doble de su dinero ahorrado");
                }
            }else{
                    System.out.println("El cliente con el número cédula "+ cedula +" no se encuentra registrado, verifica nuevamente el número...");
                }
            }
        }

        public void solicitudCdt(long cedula) { // Función para solicitar un CDT.
            if (clientes.isEmpty()) {
                System.out.println("No hay clientes registrados en el sistema.");
            } else {
                Clientes cliente = buscarCedula(cedula);
    
                if (cliente != null) {
                    double ahorroActual = cliente.getDineroAhorrado();
                    
                    int eleccion;
    
                    System.out.println("\nOpciones disponibles para CDT:");
                    System.out.println("1. Solicitud de un plazo de 3 meses con tasa de interés del 3%");
                    System.out.println("2. Solicitud de un plazo de 6 meses con tasa de interés del 5%");
                    System.out.println("3. Ninguno - volver atrás");
                    System.out.print("Seleccione una opción: ");
                    eleccion = scanner.nextInt();
    
                    switch (eleccion) {
                        case 1:
                            double interesAhorro1 = ahorroActual * (0.03 / (12 / 3));
                            double total1 = ahorroActual + interesAhorro1;
                            System.out.println("En el plazo de 3 meses por el CDT recibirá un total de: " + interesAhorro1);
                            System.out.println("El ahorro total es de: " + total1);
                            break;
                        case 2:
                            double interesAhorro2 = ahorroActual * (0.05 / (12 / 6));
                            double total2 = ahorroActual + interesAhorro2;
                            System.out.println("En el plazo de 6 meses por el CDT recibirá un total de: " + interesAhorro2);
                            System.out.println("El ahorro total es de: " + total2);
                            break;
                        case 3:
                            System.out.println("Volviendo atrás...");
                            break;
                        default:
                            System.out.println("Opción inválida...");
                    }
                } else {
                    System.out.println("Cliente no encontrado...");
                }
            }
        }
    }