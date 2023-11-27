/**
 *
 * @author aflop
 */
package proyecto_empresa;

import Contable.MetodosFacturas;
import Contable.MetodosProductos;
import Colaboradores.MetodoColaboradores;
import HerramientasTrabajo.MetodosHerramientas;
import Clientes.MetodoClientes;
import javax.swing.JOptionPane;

public class Proyecto_empresa {

    public static void main(String[] args) {

        MetodoColaboradores menu_colab = new MetodoColaboradores();
        MetodosHerramientas menu_inve = new MetodosHerramientas();
        MetodoClientes menuClientes = new MetodoClientes();
        MetodosProductos menuProductos = new MetodosProductos();
        MetodosFacturas menuFacturas = new MetodosFacturas();
        String result = "";
        int option = 0;
        try {
            while (option != 6) {
                JOptionPane.showMessageDialog(null,
                        "BIENVENIDO AL SISTEMA SIMPLE DE GESTIÓN EMPRESARIAL (SSGE)\n");
                option = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la funcionalidad que desea usar\n"
                        + "1. Sistema de directorio activo\n"
                        + "2. Sistema de clientes\n"
                        + "3. Inventario de herramientas de trabajo\n"
                        + "4. Sistema de Almacen\n"
                        + "5. Ventas y facturación\n"
                        + "6. salir\n"));
                switch (option) {
                    case 1:
                        menu_colab.MenuColab();
                        break;
                    case 2:
                        menuClientes.MenuClien();
                        break;
                    case 3:
                        menu_inve.MenuInv();
                        break;
                    case 4:
                        menuProductos.MenuProd();
                        break;
                    case 5:
                        menuFacturas.MenuFacturacion();
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo del sistema");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción errada");
                }
            }

        } catch (Exception e) {
            result += e;
        }
    }
}
