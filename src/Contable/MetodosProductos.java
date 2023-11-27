package Contable;

import Utilidades.*;
import javax.swing.JOptionPane;
import estructurasdatos.*;

public class MetodosProductos {
    
    private Pila<clsProductos> pilaProductos;
    private Pila<clsProductos> AuxpilaProductos;
    private String cadena;
    private int ContProductos;
    Validaciones validar = new Validaciones();
    
    public MetodosProductos() {
        pilaProductos = new Pila();
        AuxpilaProductos = new Pila();
        cadena = "";
        ContProductos = 0;
        inicializar();
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
                        validar.ValidateID(JOptionPane.showInputDialog("Identificación del producto")),
                        validar.validatechar(JOptionPane.showInputDialog("Nombre del producto")),
                        Integer.parseInt(validar.ValidateID(JOptionPane.showInputDialog("Cantidad de unidades del Producto"))),
                        Double.parseDouble(validar.ValidateID(JOptionPane.showInputDialog("Valor unitario del Producto")))));
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
    
    public String BuscarProductoVen(String identificacion) {
        try {
            while (!pilaProductos.estaVacia()) {
                clsProductos objProductos;
                objProductos = pilaProductos.getElemento();
                if (objProductos.getIdProducto().equalsIgnoreCase(identificacion)) {
                    int cantVender = Integer.parseInt(validar.ValidateID(JOptionPane.showInputDialog("Cantidad de productos a vender")));
                    cadena += " El producto "
                            + objProductos.getNombreProducto()
                            + " ha sido vendido por: $ "
                            + cantVender * objProductos.getValorVenta()
                            + " pesos\n";
                    objProductos.setCantUnidades(objProductos.getCantUnidades() - cantVender);
                    AuxpilaProductos.apilar(pilaProductos.getElemento());
                    pilaProductos.desapilar();
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
        return cadena;
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
                        + "1. Registrar almacenamiento de productos\n"
                        + "2. Mostrar productos disponibles\n"
                        + "3. Modificar información de productos disponibles\n"
                        + "4. Buscar productos\n"
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
                                ModificarInfoProd(validar.ValidateID(JOptionPane.showInputDialog("Digite el identificador del producto"))));
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,
                                BuscarProducto(validar.ValidateID(JOptionPane.showInputDialog("Digite el identificador del producto"))));
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,
                                EliminarProducto(validar.ValidateID(JOptionPane.showInputDialog("Digite el identificador del producto"))));
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Saliendo");
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
        switch (Integer.parseInt(JOptionPane.showInputDialog("Digite el número de la opción deseada\n"
                + "1. Nombre producto\n"
                + "2. Cantidad de unidades\n"
                + "3. Valor por unidad\n"
                + "-----------------------"))) {
            case 1:
                objProductos.setNombreProducto(validar.validatechar(JOptionPane.showInputDialog(
                        "¿Cuál es nombre Correcto?")));
                opcion = "Nombre del Colaborador modificado con éxito";
                break;
            case 2:
                objProductos.setCantUnidades(Integer.parseInt(validar.ValidateID(JOptionPane.showInputDialog(
                        "¿Cuál La nueva cantidad de unidades?"))));
                opcion = "unidades modificados con éxito";
                break;
            case 3:
                objProductos.setValorVenta(Double.parseDouble(validar.ValidateID(JOptionPane.showInputDialog(
                        "¿Cuál es el nuevo valor unitario?"))));
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
    
    private void inicializar() {
        
        pilaProductos.apilar(new clsProductos("1", "Producto 1", 100, 10));
        ContProductos++;
        pilaProductos.apilar(new clsProductos("2", "Producto 2", 200, 101));
        ContProductos++;
        pilaProductos.apilar(new clsProductos("3", "Producto 3", 300, 105));
        ContProductos++;
        pilaProductos.apilar(new clsProductos("4", "Producto 4", 444, 50));
        ContProductos++;
        pilaProductos.apilar(new clsProductos("5", "Producto 5", 500, 30));
        ContProductos++;
    }
}
