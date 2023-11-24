package Clientes;

import Colaboradores.*;
import javax.swing.JOptionPane;
import estructurasdatos.*;

public class MetodoClientes extends MetodoColaboradores {

    private Pila<ColaboradorPrincipal> pilaColabora;
    private Pila<ColaboradorPrincipal> AuxColabora;
    private String cadena;
    private int ContColab;

    public MetodoClientes() {
        pilaColabora = new Pila();
        AuxColabora = new Pila();
        cadena = "";
        ContColab = 0;
    }

    public String MenuClien() {
        String result = "";
        int option = 0;
        try {
            while (option != 6) {
                JOptionPane.showMessageDialog(null,
                        "Menú clientes\n");
                option = Integer.parseInt(JOptionPane.showInputDialog("Seleccione lo que desea hacer\n"
                        + "1. Agregar clientes\n"
                        + "2. Mostrar clientes\n"
                        + "3. Modificar información de clientes\n"
                        + "4. Buscar clientes\n"
                        + "5. Eliminar clientes\n"
                        + "6. salir\n"));
                switch (option) {
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                AgregarColaborador());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,
                                ImprimirColab());
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,
                                ModificarColaborador(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,
                                BuscarColaborador(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,
                                EliminarColaborador(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "saliendo");
                        break;
                    default:
                        result = "Opción errada";
                }
            }

        } catch (Exception e) {
            return "\n" + e;
        }
        return result;
    }
}
