/**
 *
 * @author aflop
 */
package Ventas;

import javax.swing.JOptionPane;
import Ventas.MetodosProductos;
import Ventas.clsProductos;
import Ventas.clsFactura;

public class MetodosFacturas {

    private String cadena = "";
    private Double valorFactura;

    public String venderProducto() {
        clsProductos objProducto;
        MetodosProductos MetProducto = new MetodosProductos();
        MetProducto.MostrarPrdodu();
        String cosa = JOptionPane.showInputDialog("Escriba el identificador del producto a vender");
        objProducto = (clsProductos) MetProducto.BuscarProductoOb(cosa);
        MetProducto.EliminarProducto(cosa);
        valorFactura += objProducto.getCantUnidades() * objProducto.getValorVenta();
        cadena += "El producto "
                + objProducto.getNombreProducto()
                + "ha sido vendido por: $"
                + objProducto.getCantUnidades() * objProducto.getValorVenta()
                + " pesos\n";
        return cadena;
    }

    public String generarFactura() {
        clsFactura objFactura;
        objFactura = new clsFactura(valorFactura, cadena);
        String laFactura = "Factura Nro:" + objFactura.getIdRecibo()
                + "\n-----------------\n"
                + cadena
                + "\n-----------------\n"
                + "Valor total: "
                + valorFactura;

        return laFactura;
    }

    //Método venta: elimina producto y guarda recibo.
    //generar factura a pagar
    //Compra adiciona en producto genera factura a pagar
}
