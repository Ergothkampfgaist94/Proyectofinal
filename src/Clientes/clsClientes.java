/**
 *
 * @author aflop
 */
package Clientes;

public class clsClientes extends Colaboradores.ColaboradorPrincipal {

    private int tipoCliente;

    public clsClientes() {
        this.tipoCliente = 0;
    }

    public clsClientes(int tipoCliente,
            String Identificacion,
            String Nombre,
            String Apellido,
            String Telefono,
            String Correo,
            int AnioIngreso,
            int Area) {
        super(Identificacion, Nombre, Apellido, Telefono, Correo, AnioIngreso, Area);
        AnioIngreso = 0;
        Area = 0;
        this.tipoCliente = tipoCliente;
    }

    public int getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(int tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

}
