/**
 *
 * @author aflop
 */
package HerramientasTrabajo;

import Utilidades.Validaciones;
import javax.swing.JOptionPane;

public class MetodosHerramientas {

    clsHerramienta objHerramienta;
    Cola<clsHerramienta> colaHerramientas;
    Cola<clsHerramienta> colaHerramientasAux;
    String Cadena;
    int ContHerramienta;
    boolean Banderita;
    Validaciones validar = new Validaciones();

    public MetodosHerramientas() {
        objHerramienta = new clsHerramienta();
        colaHerramientas = new Cola();
        colaHerramientasAux = new Cola();
        Cadena = "";
        ContHerramienta = 0;
        Banderita = true;
        inicializar();
    }

    public String AgregarHerramienta() {
        try {
            while (JOptionPane.showConfirmDialog(null,
                    "¿Desea agregar una nueva herramienta?") == JOptionPane.YES_NO_OPTION) {
                colaHerramientas.Encolar(new clsHerramienta(validar.ValidateID(JOptionPane.showInputDialog("Serial del artículo")),
                        validar.validatechar(JOptionPane.showInputDialog("Nombre del artículo")),
                        preguntarTipo(),
                        preguntarEstado(),
                        validar.ValidateID(JOptionPane.showInputDialog("Id colaborador"))));
                ContHerramienta++;
            }
            Cadena = "Herramientas agregadas con éxito, fueron un total de " + ContHerramienta;
            return Cadena;
        } catch (Exception e) {
            Cadena = "Error al insertar Herramientas en el inventario: " + e.getMessage();

            return Cadena;
        }
    }

    public String MostrarHerramienta() {
        try {
            Cadena = "LISTADO DE HERAMIENTAS REGISTRADAS\n\n";
            while (!colaHerramientas.EstaVacia()) {
                objHerramienta = colaHerramientas.getElementos();
                Cadena += "Serial: " + objHerramienta.getSerialArticulo() + "\n"
                        + "Nombre artículo: " + objHerramienta.getNombreArticulo() + "\n"
                        + "Tipo de artículo: " + objHerramienta.getTipoArtículo() + "\n"
                        + "Estado: " + objHerramienta.getEstado() + "\n"
                        + "Colaborador: " + objHerramienta.getIdentificacionColaborador() + "\n"
                        + "\n---------------------------------\n\n";
                colaHerramientasAux.Encolar(colaHerramientas.getElementos());
                colaHerramientas.Desencolar();
            }
            returnColaHerramientas(colaHerramientas);
            if (ContHerramienta != 0) {
                Cadena += "TOTAL DE HERRAMIENTAS REGISTRADAS: " + ContHerramienta;
            }
            return Cadena;
        } catch (Exception e) {
            Cadena = "Error al leer el inventario: " + e.getMessage();
            return Cadena;
        }
    }

    public String ActualizarInfoHerramientas(String serial) {
        try {
            boolean banderita = false;
            Cadena = "";
            int mod = 0;
            while (!colaHerramientas.EstaVacia()) {
                objHerramienta = colaHerramientas.getElementos();
                if (objHerramienta.getSerialArticulo().equalsIgnoreCase(serial)) {
                    banderita = true;
                    mod = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el dato a modificar"
                            + "\n 1. Serial"
                            + "\n 2. Nombre"
                            + "\n 3. Tipo"
                            + "\n 4. Estado"
                            + "\n 5. Colaborador"
                            + "\n-------------"));
                    switch (mod) {
                        case 1:
                            objHerramienta.setSerialArticulo(JOptionPane.showInputDialog(
                                    "¿Cuál es nuevo Serial de la herramienta?"));
                            Cadena = "Serial modificado con éxito";
                            break;
                        case 2:
                            objHerramienta.setNombreArticulo(validar.validatechar(JOptionPane.showInputDialog(
                                    "¿Cuál es nombre del artículo?")));
                            Cadena = "Nombre del artículo modificado con éxito";
                            break;
                        case 3:
                            objHerramienta.setTipoArtículo(preguntarTipo());
                            Cadena = "El tipo de artículo modificado con éxito";
                            break;
                        case 4:
                            objHerramienta.setEstado(preguntarEstado());
                            Cadena = "Estado del artículo modificado con éxito";
                            break;
                        case 5:
                            objHerramienta.setIdentificacionColaborador(validar.ValidateID(JOptionPane.showInputDialog(
                                    "¿Cuál es el ID del colaborador?")));
                            Cadena = "ID modificado con éxito";
                            break;
                        default:
                            Cadena = "¡Error! la opción seleccionada no existe\n "
                                    + "Intente el proceso de nuevo";
                    }
                    colaHerramientasAux.Encolar(colaHerramientas.getElementos());
                    colaHerramientas.Desencolar();

                } else {
                    colaHerramientasAux.Encolar(colaHerramientas.getElementos());
                    colaHerramientas.Desencolar();
                }
            }
            if (!banderita) {
                Cadena = "No encontrado \n";
            }
            returnColaHerramientas(colaHerramientasAux);

            return Cadena;
        } catch (Exception e) {
            Cadena = "Error al mostrar inventario: " + e.getMessage();
            return Cadena;
        }
    }

    public String EliminarHerramienta(String Serial) {
        try {
            Cadena = "";
            Banderita = false;
            while (!colaHerramientas.EstaVacia()) {
                objHerramienta = colaHerramientas.getElementos();
                if (objHerramienta.getSerialArticulo().equalsIgnoreCase(Serial)) {
                    Banderita = true;
                    ContHerramienta--;
                    colaHerramientas.Desencolar();
                } else {
                    colaHerramientasAux.Encolar(colaHerramientas.getElementos());
                    colaHerramientas.Desencolar();
                }
            }
            if (Banderita) {
                Cadena = "El Registro del artículo fue encontrado y eliminado";
            } else {
                Cadena = "El artículo no fue encontrado";
            }
            returnColaHerramientas(colaHerramientasAux);
            return Cadena;
        } catch (Exception e) {
            Cadena = "Error al eliminar artículo: " + e.getMessage();
            return Cadena;
        }
    }

    public String BuscarHerramienta(String serial) {
        try {
            Cadena = "";
            String info = "";
            Banderita = false;
            while (!colaHerramientas.EstaVacia()) {
                objHerramienta = colaHerramientas.getElementos();
                if (objHerramienta.getSerialArticulo().equalsIgnoreCase(serial)) {
                    Banderita = true;
                    info = "Serial: " + objHerramienta.getSerialArticulo() + "\n"
                            + "Nombre artículo: " + objHerramienta.getNombreArticulo() + "\n"
                            + "Tipo de artículo: " + objHerramienta.getTipoArtículo() + "\n"
                            + "Estado: " + objHerramienta.getEstado() + "\n"
                            + "ID Colaborador: " + objHerramienta.getIdentificacionColaborador();
                    colaHerramientasAux.Encolar(colaHerramientas.getElementos());
                    colaHerramientas.Desencolar();
                } else {
                    colaHerramientasAux.Encolar(colaHerramientas.getElementos());
                    colaHerramientas.Desencolar();
                }
            }
            if (Banderita) {
                Cadena = "El artículo fue encontrado\n" + info;
            } else {
                Cadena = "El artículo no fue encontrado";
            }
            returnColaHerramientas(colaHerramientasAux);
            return Cadena;
        } catch (Exception e) {
            Cadena = "Error al buscar artículo en inventario: " + e.getMessage();
            return Cadena;
        }
    }

    public String MenuInv() {
        String result = "";
        int option = 0;
        try {
            while (option != 6) {
                JOptionPane.showMessageDialog(null,
                        "Menú de inventario\n");
                option = Integer.parseInt(JOptionPane.showInputDialog("Seleccione lo que desea hacer\n"
                        + "1. Agregar artículo\n"
                        + "2. Mostrar artículo\n"
                        + "3. Modificar información de artículo\n"
                        + "4. Buscar artículo\n"
                        + "5. Eliminar artículo\n"
                        + "6. salir\n"));
                switch (option) {
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                AgregarHerramienta());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,
                                MostrarHerramienta());
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,
                                ActualizarInfoHerramientas(JOptionPane.showInputDialog("Digite el serial del artículo").toUpperCase()));
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,
                                BuscarHerramienta(JOptionPane.showInputDialog("Digite el serial del artículo").toUpperCase()));
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,
                                EliminarHerramienta(JOptionPane.showInputDialog("Digite el serial del artículo").toUpperCase()));
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo");
                        break;
                    default:
                        result = "Opción errada.";
                }
            }

        } catch (Exception e) {
            return "\n" + e;
        }
        return result;
    }

    private void inicializar() {

        colaHerramientas.Encolar(new clsHerramienta("1", "Portatil", 1, 1, "1017222314"));
        ContHerramienta++;
        colaHerramientas.Encolar(new clsHerramienta("2", "Teclado", 2, 1, "1017222314"));
        ContHerramienta++;
        colaHerramientas.Encolar(new clsHerramienta("3", "Mouse", 2, 1, "1017222314"));
        ContHerramienta++;
        colaHerramientas.Encolar(new clsHerramienta("4", "Base", 3, 1, "1017222314"));
        ContHerramienta++;
        colaHerramientas.Encolar(new clsHerramienta("5", "Pantalla", 1, 2, "1017222314"));
        ContHerramienta++;
    }

    private void returnColaHerramientas(Cola<clsHerramienta> colaHerramientasAux) {
        try {
            while (!colaHerramientasAux.EstaVacia()) {
                colaHerramientas.Encolar(colaHerramientasAux.getElementos());
                colaHerramientasAux.Desencolar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al devolver la Cola de herramientas: " + e.getMessage());
        }
    }

    private int preguntarEstado() {
        Object[] options = {"Nuevo",
            "Usado",
            "Dañado"};
        int n = JOptionPane.showOptionDialog(null,
                "Seleccione el estado del Artículo",
                "ESCOGER ESTADO",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);
        return n + 1;

    }

    private int preguntarTipo() {
        Object[] options = {"Principal",
            "Periférico",
            "Complemento"};
        int n = JOptionPane.showOptionDialog(null,
                "Seleccione el estado del Artículo",
                "ESCOGER ESTADO",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);
        return n + 1;

    }
}
