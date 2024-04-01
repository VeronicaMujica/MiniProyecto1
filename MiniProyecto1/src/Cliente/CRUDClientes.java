package Cliente;
import java.util.Scanner;
import java.util.ArrayList;

public class CRUDClientes {
    private ArrayList<Clientes> clientes;
    Scanner scanner = new Scanner(System.in);

    public CRUDClientes() {
        clientes = new ArrayList<>();
    }

    public void crearCliente(Clientes cliente) {
        clientes.add(cliente);
    }

    public Clientes buscarCedula(long cedula) {
        for (Clientes cliente : clientes) {
            if (cliente.getCedula() == cedula) {
                return cliente;
            }
        }
        return null;
    }

    public void insertarDinero(long cedula, double cantidadDinero) {
        Clientes cliente = buscarCedula(cedula);
        if (cliente != null) {

            double dineroActual = cliente.getDineroAhorrado();
            cliente.setDineroAhorrado(dineroActual + cantidadDinero);
            System.out.println("Dinero agregado correctamente al cliente " + cliente.getNombre());
        } else {
            System.out.println("Cliente con la cedula " + cedula + " no encontrado.");
        }
    }

    public void actualizarDinero() {

    }

    public void eliminarDinero(long cedula, double cantidadDinero) {
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

    public void buscarCliente(String nombre) {
        for (Clientes cliente : clientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(cliente);
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Clientes cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }


    public void SolicitudPrestamo(long cedula) {

        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados en el sistema.");
        } else{
            Clientes cliente = buscarCedula(cedula);
    
            if (cliente != null) {
                double ahorroCliente = cliente.getDineroAhorrado();
                double creditoMaximo = ahorroCliente * 2;
    
                System.out.println("Ingrese el monto de la solicitud del prestamo: ");
                double valorPrestamo = scanner.nextDouble();
                scanner.nextLine(); 
    
                if (valorPrestamo >= 1 && valorPrestamo <= creditoMaximo) {
                    if (valorPrestamo <= ahorroCliente) {
                        double saldoFinal = ahorroCliente - valorPrestamo;
                        cliente.setDineroAhorrado(saldoFinal);
                        System.out.println("el prestamo solicitado por un valor de "+ valorPrestamo + " del cliente ha sido aprobado su saldo restante es de: " + saldoFinal);
                    } 
                } else {
                    System.out.println("El valor del prestamo es mayor a lo ahorrado");
    
                    double interesAnual = 0.02;
                    double interesMensual = (interesAnual/12);
                    double meses = 6; 
                    double interes = valorPrestamo * (Math.pow(1 + (interesMensual), meses));
                    double cuotaMensual = (interes/6);
    
                    System.out.println("El valor de la cuota mensual del cliente con numero de cedula"+cedula+"es: " + cuotaMensual);
                    }
                }else{
                    System.out.println("El cliente con el numero cedula "+ cedula +" no se encuentra registrado, verifica nuevamente el numero...");
                }
            }
        }
    }





