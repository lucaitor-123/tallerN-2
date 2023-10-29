import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Arriendo {
    private String RUTcliente;
    private String patenteVehiculo;
    private String fechaInicio;
    private String fechaTermino;

    public Arriendo(String RUTcliente, String patenteVehiculo, String fechaInicio, String fechaTermino) {
        this.RUTcliente = RUTcliente;
        this.patenteVehiculo = patenteVehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }

    class RegistroClientes {
        private List<Cliente> clientes = new ArrayList<>();

        public boolean inscribirCliente(Cliente cliente) {
            // Validar si el cliente ya está inscrito
            if (clientes.stream().anyMatch(c -> c.getRUT().equals(cliente.getRUT()))) {
                System.out.println("El cliente ya está inscrito en el sistema.");
                return false;
            }

            // Si el cliente no está inscrito, agregarlo a la lista de clientes
            clientes.add(cliente);
            System.out.println("Cliente inscrito exitosamente.");
            return true;
        }

        public Optional<Cliente> buscarClientePorRUT(String rut) {
            // Buscar un cliente por su RUT y devolverlo si se encuentra
            return clientes.stream()
                    .filter(c -> c.getRUT().equals(rut))
                    .findFirst();
        }

        public void listarClientes() {
            // Listar todos los clientes en el registro
            for (Cliente cliente : clientes) {
                System.out.println("RUT: " + cliente.getRUT() + ", Nombre: " + cliente.getNombre() +
                        " Apellido: " + cliente.getApellido());
            }
        }

        public boolean eliminarCliente(String rut) {
            // eliminar cliente por su rut
            Optional<Cliente> clienteAEliminar = buscarClientePorRUT(rut);
            if (clienteAEliminar.isPresent()) {
                System.out.println("cliente eliminado existosamente");
                return true;
            } else {
                System.out.println("el cliente no se encontro en el registro");
                return false;
            }
        }

        public boolean actualizarInformacionCliente(String rut, String nombre, String apellido) {
            // actualizar informacion del cliente por su rut
            Optional<Cliente> clienteAActualizar = buscarClientePorRUT(rut);
            if (clienteAActualizar.isPresent()) {
                Cliente cliente = clienteAActualizar.get();
                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                System.out.println("informacion del cliente existosamente actualizado");
                return true;

            } else {
                System.out.println("el cliente no se encontro con existo");
                return false;
            }
        }

    }
}