package Ventas;

import javax.swing.JOptionPane;
import estructurasdatos.*;

public class MetodosProductos {

    private Pila<clsProductos> pilaProductos;
    private Pila<clsProductos> AuxpilaProductos;
    private String cadena;
    private int ContProductos;

    public MetodosProductos() {
        pilaProductos = new Pila();
        AuxpilaProductos = new Pila();
        cadena = "";
        ContProductos = 0;
    }

    public MetodosProductos(Pila<clsProductos> pilaProductos,
            Pila<clsProductos> AuxpilaProductos,
            String cadena,
            int ContProductos) {
        pilaProductos = pilaProductos;
        AuxpilaProductos = AuxpilaProductos;
        cadena = cadena;
        ContProductos = ContProductos;
    }

    public String AgregarProducto() {
        try {
            while (JOptionPane.showConfirmDialog(null,
                    "¿Desea agregar un nuevo producto?")
                    == JOptionPane.YES_NO_OPTION) {
                pilaProductos.apilar(new clsProductos(
                        JOptionPane.showInputDialog("Identificación del producto"),
                        JOptionPane.showInputDialog("Nombre del producto"),
                        Integer.parseInt(JOptionPane.showInputDialog("Cantidad de unidades del Producto")),
                        Double.parseDouble(JOptionPane.showInputDialog("Valor unitario del Producto"))));
                ContProductos++;
            }
            cadena = "Se agregaron "
                    + ContProductos
                    + " Productos nuevos";

        } catch (Exception e) {
            cadena = "Error al insertar Herramientas en el inventario: " + e.getMessage();

            return cadena;
        }
        return cadena;
    }

    public String MostrarPrdodu() {
        try {
            cadena = "LISTADO DE PRODUCTOS\n\n";
            while (!pilaProductos.estaVacia()) {
                clsProductos objProdu;
                objProdu = pilaProductos.getElemento();
                cadena += "Identificador: " + objProdu.getIdProducto() + "\n"
                        + "Nombre: " + objProdu.getNombreProducto() + "\n"
                        + "Unidades disponibles : " + objProdu.getCantUnidades() + "\n"
                        + "---------------------------------\n\n";
                AuxpilaProductos.apilar(pilaProductos.getElemento());
                pilaProductos.desapilar();
            }
            RetPilaProd(AuxpilaProductos);
        } catch (Exception e) {
            cadena = "Error al leer el inventario: " + e.getMessage();
            return cadena;
        }
        return cadena;
    }

    public String ModificarInfoProd(String identificacion) {
        try {
            boolean banderita = false;
            String datoen = "";
            cadena = "";

            while (!pilaProductos.estaVacia()) {
                clsProductos objProducto;
                objProducto = pilaProductos.getElemento();

                if (objProducto.getIdProducto().equalsIgnoreCase(identificacion)) {
                    banderita = true;
                    String opc = MenuMod();
                    cadena = opc;
                    AuxpilaProductos.apilar(pilaProductos.getElemento());
                    pilaProductos.desapilar();
                } else {
                    AuxpilaProductos.apilar(pilaProductos.getElemento());
                    pilaProductos.desapilar();
                }
            }

            if (banderita) {
                datoen = "Producto fue encontrado!!!\n\n";
            } else {
                cadena = "Producto encontrado.";
            }

            RetPilaProd(AuxpilaProductos);
            return datoen + cadena;
        } catch (Exception e) {
            cadena = "Error al modificar inventario: " + e.getMessage();
            return cadena;
        }
    }

    public String BuscarProducto(String identificacion) {
        try {
            boolean banderita = false;
            String datoen = "";
            cadena = "";
            while (!pilaProductos.estaVacia()) {
                clsProductos objProductos;
                objProductos = pilaProductos.getElemento();
                if (objProductos.getIdProducto().equalsIgnoreCase(identificacion)) {
                    banderita = true;
                    cadena += "INVENTARIO.\n\n"
                            + "IDENTIFICADOR: " + objProductos.getIdProducto() + "\n"
                            + "Nombre producto: " + objProductos.getNombreProducto() + "\n"
                            + "Cantidad de unidades: " + objProductos.getCantUnidades() + "\n"
                            + "Valor unitario: " + objProductos.getValorVenta() + "\n"
                            + "-------------------------\n";
                    AuxpilaProductos.apilar(pilaProductos.getElemento());
                    pilaProductos.desapilar();
                } else {
                    AuxpilaProductos.apilar(pilaProductos.getElemento());
                    pilaProductos.desapilar();
                }
            }
            if (banderita) {
                datoen = "¡El producto fue encontrado éxitosamente!\n\n";
            } else {
                cadena = "El producto no fue encontrado.";
            }
            RetPilaProd(AuxpilaProductos);
        } catch (Exception e) {
            cadena = "Error al leer el inventario: " + e.getMessage();
            return cadena;
        }
        return cadena;
    }

    public Object BuscarProductoOb(String identificacion) {
        try {
            while (!pilaProductos.estaVacia()) {
                clsProductos objProductos;
                objProductos = pilaProductos.getElemento();
                if (objProductos.getIdProducto().equalsIgnoreCase(identificacion)) {
                    AuxpilaProductos.apilar(pilaProductos.getElemento());
                    pilaProductos.desapilar();
                    return objProductos;
                } else {
                    AuxpilaProductos.apilar(pilaProductos.getElemento());
                    pilaProductos.desapilar();
                }
            }
            RetPilaProd(AuxpilaProductos);
        } catch (Exception e) {
            cadena = "Error al leer el inventario: " + e.getMessage();
            return cadena;
        }
        return "null";
    }

    public String EliminarProducto(String ID) {
        boolean banderita = false;
        cadena = "";
        while (!pilaProductos.estaVacia()) {
            clsProductos objProducto;
            objProducto = pilaProductos.getElemento();
            if (objProducto.getIdProducto().equalsIgnoreCase(ID)) {
                banderita = true;
                ContProductos--;
                pilaProductos.desapilar();
            } else {
                AuxpilaProductos.apilar(pilaProductos.getElemento());
                pilaProductos.desapilar();
            }
        }
        if (banderita) {
            cadena = "El registro fue encontrado y eliminado";
        } else {
            cadena = "El registro no fue encontrado";
        }
        RetPilaProd(AuxpilaProductos);
        return cadena;
    }

    public String MenuProd() {
        String result = "";
        int option = 0;
        try {
            while (option != 6) {
                JOptionPane.showMessageDialog(null,
                        "Invetario de producctos\n");
                option = Integer.parseInt(JOptionPane.showInputDialog("Seleccione lo que desea hacer\n"
                        + "1. Agregar Productos\n"
                        + "2. Mostrar Productos\n"
                        + "3. Modificar información de Productos\n"
                        + "4. Buscar Productos\n"
                        + "5. Eliminar Productos\n"
                        + "6. salir\n"));
                switch (option) {
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                AgregarProducto());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,
                                MostrarPrdodu());
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,
                                ModificarInfoProd(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,
                                BuscarProducto(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,
                                EliminarProducto(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
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

    private String MenuMod() {
        clsProductos objProductos;
        objProductos = pilaProductos.getElemento();
        String opcion = "";
        switch (Integer.parseInt(JOptionPane.showInputDialog("Marque la opción deseada\n"
                + "1. Nombre producto\n"
                + "2. Cantidad de unidades\n"
                + "3. Valor por unidad\n"
                + "-----------------------"))) {

            case 1:
                objProductos.setNombreProducto(JOptionPane.showInputDialog(
                        "¿Cuál es nombre Correcto?"));
                opcion = "Nombre del Colaborador modificado con éxito";
                break;
            case 2:
                objProductos.setCantUnidades(Integer.parseInt(JOptionPane.showInputDialog(
                        "¿Cuál La nueva cantidad de unidades?")));
                opcion = "unidades modificados con éxito";
                break;
            case 3:
                objProductos.setValorVenta(Double.parseDouble(JOptionPane.showInputDialog(
                        "¿Cuál es el nuevo valor unitario?")));
                opcion = "valor modificado con éxito";
                break;
            default:
                opcion = "¡Error! la opción seleccionada no existe\n "
                        + "Intente el proceso de nuevo";
        }
        return opcion;
    }

    private void RetPilaProd(Pila<clsProductos> AuxpilaProductos) {

        while (!AuxpilaProductos.estaVacia()) {
            pilaProductos.apilar(AuxpilaProductos.getElemento());
            AuxpilaProductos.desapilar();
        }
    }
}
