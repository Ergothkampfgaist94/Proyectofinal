/**
 *
 * @author aflop
 */
package proyecto_empresa;

import Colaboradores.MetodoColaboradores;
import Inventario.MetodosHerramientas;
import Clientes.MetodoClientes;
import Ventas.*;

public class Proyecto_empresa {

    public static void main(String[] args) {
//        MetodoColaboradores menu_colab = new MetodoColaboradores();
//        menu_colab.MenuColab();
//        MetodosHerramientas menu_inve = new MetodosHerramientas();
//        menu_inve.MenuInv();
//        MetodoClientes menuClientes = new MetodoClientes();
//        menuClientes.MenuClien();
        MetodosProductos menuProductos = new MetodosProductos();
        menuProductos.MenuProd();
    }
}
