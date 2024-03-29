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

    public void insertarDinero() {

    }

    public void actualizarDinero() {

    }

    public void eliminarDinero() {

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

