/**
 *
 * @author aflop
 */
package Contable;

import javax.swing.JOptionPane;
import Utilidades.*;
import estructurasdatos.Pila;

public class MetodosFacturas {

    private String cadena = "";
    private Double valorFactura;
    Validaciones validar = new Validaciones();

    public String VenderProducto() {
        try {
            MetodosProductos MetProducto = new MetodosProductos();
            String identificadorProducto = JOptionPane.showInputDialog(MetProducto.MostrarPrdodu()
                    + "\nEscriba el identificador del producto a vender");
            cadena = MetProducto.BuscarProductoVen(identificadorProducto);
        } catch (Exception e) {
            cadena = "Error: " + e;
        }
        return cadena;
    }

    public String GenerarFactura(double valorFactura, String cadena) {
        String laFactura = "";
        try {
            clsFactura objFactura;
            objFactura = new clsFactura(valorFactura, cadena);
            laFactura = "Factura Nro:" + objFactura.getIdRecibo()
                    + "\n-----------------\n"
                    + cadena
                    + "\n-----------------\n"
                    + "Valor total: "
                    + valorFactura;
        } catch (Exception e) {
            cadena = "Error: " + e;
        }

        return laFactura;
    }

    public String MenuFacturacion() {
        cadena = "";
        int option = 0;
        try {
            while (option != 3) {
                JOptionPane.showMessageDialog(null,
                        "Menú Contabilidad\n");
                option = Integer.parseInt(validar.ValidateID(JOptionPane.showInputDialog("Seleccione lo que desea hacer\n"
                        + "1. Vender producto\n"
                        + "2. Generar factura\n"
                        + "3. salir\n")));
                switch (option) {
                    case 1:
                        JOptionPane.showMessageDialog(null, VenderProducto());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, GenerarFactura(valorFactura(), cadena));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Saliendo");
                        break;
                    default:
                        cadena = "Opción errada";
                }
            }

        } catch (Exception e) {
            cadena = "Error\n" + e;
        }
        return cadena;
    }

    private int valorFactura() {
        int valor = 0;
        return valor;
    }
}
