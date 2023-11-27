/**
 *
 * @author aflop
 */
package Contable;

public class clsProductos {

    private String IdProducto;
    private String nombreProducto;
    private int cantUnidades;
    private double valorVenta;

    public int getCantUnidades() {
        return cantUnidades;
    }

    public void setCantUnidades(int cantUnidades) {
        this.cantUnidades = cantUnidades;
    }

    public clsProductos() {
        IdProducto = "";
        nombreProducto = "";
        cantUnidades = 0;
        valorVenta = 0;
    }

    public clsProductos(String IdProducto, String nombreProducto, int cantUnidades, double valorVenta) {
        this.IdProducto = IdProducto;
        this.nombreProducto = nombreProducto;
        this.cantUnidades = cantUnidades;
        this.valorVenta = valorVenta;
    }

    public double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public String getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(String IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

}
