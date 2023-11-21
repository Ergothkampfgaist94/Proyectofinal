/**
 *
 * @author GIS_Soporte
 */
package Inventario;

import Colaboradores.ColaboradorPrincipal;
import javax.swing.JOptionPane;

public class MetodosHerramientas {

    clsHerramienta objHerramienta;
    ColaboradorPrincipal objEmpleados;
    Cola<clsHerramienta> colaHerramientas;
    Cola<clsHerramienta> colaHerramientasAux;
    Cola<ColaboradorPrincipal> colaEmpleados;
    Cola<ColaboradorPrincipal> colaEmpleadosAux;
    String Cadena;
    int ContHerramienta;
    boolean Banderita;

    public MetodosHerramientas() {
        objHerramienta = new clsHerramienta();
        objEmpleados = new ColaboradorPrincipal();
        colaHerramientas = new Cola();
        colaHerramientasAux = new Cola();
        colaEmpleados = new Cola();
        colaEmpleadosAux = new Cola();
        Cadena = "";
        ContHerramienta = 0;
        Banderita = true;
    }

    public String AgregarHerramienta() {
        try {
            while (JOptionPane.showConfirmDialog(null,
                    "¿Desea agregar una nueva herramienta?") == JOptionPane.YES_NO_OPTION) {
                colaHerramientas.Encolar(new clsHerramienta(
                        JOptionPane.showInputDialog("Serial del artículo"),
                        JOptionPane.showInputDialog("Nombre del artículo"),
                        JOptionPane.showInputDialog("Tipo de artículo"),
                        JOptionPane.showInputDialog("Tipo de artículo"),
                        Integer.parseInt(JOptionPane.showInputDialog("Id colaborador"))
                ));
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
                Cadena += "Serial " + objHerramienta.getSerialArticulo() + "\n"
                        + "Nombre artículo: " + objHerramienta.getNombreArticulo() + "\n"
                        + "Tipo de artículo: " + objHerramienta.getTipoArtículo() + "\n"
                        + "Estado: " + objHerramienta.getEstado() + "\n"
                        + "Colaborador: " + objHerramienta.getIdentificacionColaborador() + "\n"
                        + "---------------------------------\n\n";
                colaHerramientasAux.Encolar(colaHerramientas.getElementos());
                colaHerramientas.Desencolar();
            }
            returnColaHerramientas(colaHerramientas);
            if (ContHerramienta != 0) {
                Cadena += "TOTAL DE HERRAMIENTAS REGISTRADAS " + ContHerramienta;
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
                    mod = Integer.parseInt(JOptionPane.showInputDialog("Dato a modificar"
                            + "\n 1. Serial"
                            + "\n 2. Nombre"
                            + "\n 3. Tipo"
                            + "\n 4. Estado"
                            + "\n 5 Colaborador"
                            + "-------------"));
                    switch (mod) {
                        case 1:
                            objHerramienta.setSerialArticulo(JOptionPane.showInputDialog(
                                    "¿Cuál es nuevo Serial de la herramienta?"));
                            Cadena = "Serial modificado con éxito";
                            break;
                        case 2:
                            objHerramienta.setNombreArticulo(JOptionPane.showInputDialog(
                                    "¿Cuál es nombre del artículo?"));
                            Cadena = "Nombre del artículo modificado con éxito";
                            break;
                        case 3:
                            objHerramienta.setTipoArtículo(JOptionPane.showInputDialog(
                                    "¿Cuál es tipo del artículo?"));
                            Cadena = " tipo de artículo modificado con éxito";
                            break;
                        case 4:
                            objHerramienta.setEstado(JOptionPane.showInputDialog(
                                    "¿Cuál es el estado del artículo?"));
                            Cadena = "Estado del artículo modificado con éxito";
                            break;
                        case 5:
                            objHerramienta.setIdentificacionColaborador(Integer.parseInt(JOptionPane.showInputDialog(
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
            if (banderita) {
                Cadena += "encontrado\n";
            } else {
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
                    info = objHerramienta.getSerialArticulo()
                            + "\n " + objHerramienta.getNombreArticulo();
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
                Cadena = "EEl artículo no fue encontrado";
            }
            returnColaHerramientas(colaHerramientasAux);
            return Cadena;
        } catch (Exception e) {
            Cadena = "Error al buscar artículo en inventario: " + e.getMessage();
            return Cadena;
        }
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
}
