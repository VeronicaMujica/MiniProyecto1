import java.util.Scanner;

import Cliente.CRUDClientes;
import Cliente.Clientes;

public class App { // Esta es la clase App, que unifica todo el proyecto para hacer que se proyecte en la terminal.
    public static void main(String[] args) { // Función principal o main, hace que la aplicación funcione de forma ordenada.
        CRUDClientes crud = new CRUDClientes();
        Scanner scanner = new Scanner(System.in);

        while (true) { // Creación del menú inicial donde se encontrarán todas las opciones con sus respectivas funciones asignadas.
            System.out.println("\n----------------------------------------");
            System.out.println("*** Bienvenidos a BanUnivalle ***");
            System.out.println("----------------------------------------");
            System.out.println("Menú principal:");
            System.out.println("----------------------------------------");
            System.out.println("1. Crear cliente");
            System.out.println("2. Insertar dinero ahorrado");
            System.out.println("3. Actualizar dinero ahorrado");
            System.out.println("4. Eliminar dinero ahorrado");
            System.out.println("5. Buscar cliente por nombre");
            System.out.println("6. Listar todos los clientes");
            System.out.println("7. Solicitud de prestamos");
            System.out.println("8. Solicitud de CDT");
            System.out.println("9. Salir");

            System.out.print("\nSeleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) { // Apartado de selección, donde se encuentran todas las posibles selecciones dentro de la aplicación y sus diálogos pre escritos.
                case 1:
                System.out.println("---------------------------------------------------");
                System.out.println("Bienvenidos al apartado de creación del cliente.");
                System.out.println("---------------------------------------------------");
                    System.out.print("Nombre del cliente: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Cédula: ");
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
                    System.out.println("----------------------------------------------------------");
                    System.out.println("Bienvenidos al apartado de insertar dinero del cliente.");
                    System.out.println("----------------------------------------------------------");
                    System.out.print("Cédula del cliente: ");
                    long Cedula = scanner.nextLong();
                    System.out.print("Dinero a insertar: ");
                    double dineroAInsertar = scanner.nextDouble();
                    scanner.nextLine();
                    
                    crud.insertarDinero(Cedula, dineroAInsertar);
                    break;
    
                case 3:
                    System.out.println("------------------------------------------------------------");
                    System.out.println("Bienvenidos al apartado de actualizar dinero del cliente.");
                    System.out.println("------------------------------------------------------------");
                    System.out.print("Ingrese la cédula: ");
                    long cedulaActualizar = scanner.nextLong();
                    System.out.print("Ingrese la cantidad de dinero a actualizar: ");
                    double dineroActualizar = scanner.nextDouble();
                    crud.actualizarDinero(cedulaActualizar, dineroActualizar);
                    break;
    
                case 4:
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("Bienvenidos al apartado de eliminiar dinero ahorrado del cliente.");
                    System.out.println("--------------------------------------------------------------------");
                    System.out.print("Ingrese la cédula: ");
                    long cedulaEliminar = scanner.nextLong();
                    System.out.print("Ingrese la cantidad de dinero a eliminar: ");
                    double dineroEliminar = scanner.nextDouble();
                    crud.eliminarDinero(cedulaEliminar, dineroEliminar);
                    break;
    
                case 5:
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Bienvenidos al apartado de buscar por el nombre del cliente.");
                    System.out.println("--------------------------------------------------------------");
                    System.out.print("Nombre del cliente a buscar: ");
                    String nombreBuscar = scanner.nextLine();
                    crud.buscarCliente(nombreBuscar);
                    break;
                case 6:
                    System.out.println("--------------------------------------------------------------");
                    System.out.println("Bienvenidos al apartado de listado de clientes registados.");
                    System.out.println("---------------------------------------------------------------");
                    crud.listarClientes();
                    break;
                case 7:
                    System.out.println("---------------------------------------------------");
                    System.out.println("Bienvenidos al apartado de préstamo del cliente");
                    System.out.println("---------------------------------------------------");
                    System.out.println("Por favor digite el número cédula del cliente quien realiza la solicitud: ");
                    long cedulaCliente = scanner.nextLong();
                    crud.SolicitudPrestamo(cedulaCliente);
                    break;
                case 8:
                    System.out.println("---------------------------------------------------");
                    System.out.println("Bienvenidos al apartado de CDT del cliente.");
                    System.out.println("---------------------------------------------------");
                    System.out.println("Por favor digite el número cédula del cliente quien realiza la solicitud: ");
                    long cedulaUsuario = scanner.nextLong();
                    crud.solicitudCdt(cedulaUsuario);
                    break;
                case 9:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción incorrecta");
                }
            }
        }
    }