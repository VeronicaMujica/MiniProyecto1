package Cliente;

import java.util.ArrayList;

public class CRUDClientes {
    private ArrayList<Clientes> clientes;

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

    public void actualizarDinero(long cedula, double cantidadDinero) {
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
}

