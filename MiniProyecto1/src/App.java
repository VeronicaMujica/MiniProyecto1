import java.util.Scanner;

import Cliente.CRUDClientes;
import Cliente.Clientes;

public class App {
    public static void main(String[] args) {
        CRUDClientes crud = new CRUDClientes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Crear cliente");
            System.out.println("2. Insertar dinero ahorrado");
            System.out.println("3. Actualizar dinero ahorrado");
            System.out.println("4. Eliminar dinero ahorrado");
            System.out.println("5. Buscar cliente por nombre");
            System.out.println("6. Listar todos los clientes");
            System.out.println("7. Solicitud de prestamos");
            System.out.println("9. Salir");

            System.out.print("\nSeleccione una opcion: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cedula: ");
                    long cedula = scanner.nextLong();
                    System.out.print("Dinero ahorrado inicial: ");
                    double dineroAhorrado = scanner.nextDouble();
                    System.out.print("Nivel de ingresos: ");
                    double nivelIngresos = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Fecha de creación: ");
                    String fechaCreacion = scanner.nextLine();
    
                    Clientes nuevoCliente = new Clientes(nombre, cedula, dineroAhorrado, nivelIngresos, fechaCreacion);
                    crud.crearCliente(nuevoCliente);
                    System.out.println("Cliente creado correctamente.");
                    break;
    
                case 2:
                    System.out.print("Cedula del cliente: ");
                    long Cedula = scanner.nextLong();
                    System.out.print("Dinero a insertar: ");
                    double dineroAInsertar = scanner.nextDouble();
                    scanner.nextLine();
                    
                    crud.insertarDinero(Cedula, dineroAInsertar);
                    break;
    
                case 3:
                //ACTUALIZAR DINERO AHORRADO
                break;
    
                case 4:
                System.out.print("Ingrese la cedula: ");
                long cedulaEliminar = scanner.nextLong();
                System.out.print("Ingrese la cantidad de dinero a eliminar: ");
                double dineroEliminar = scanner.nextDouble();
                crud.eliminarDinero(cedulaEliminar, dineroEliminar);
                break;
    
                case 5:
                    System.out.print("Nombre del cliente a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    crud.buscarCliente(nombreBuscar);
                    break;
                case 6:
                    crud.listarClientes();
                    break;
                case 7:
                    System.out.println("Bienvenidos al apartado de prestamo.");
                    System.out.println("Ingrese la cedula del cliente quien solicita el prestamo: ");
                    long cedulaCliente = scanner.nextLong();
                    crud.SolicitudPrestamo(cedulaCliente);
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opcion incorrecta");
                }
            }
        }
    }
    
    