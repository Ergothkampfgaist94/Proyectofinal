/**
 *
 * @author aflop
 */
package Ventas;

public class clsProductos {

    private String IdProducto;
    private String nombreProducto;
    private int cantUnidades;

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
    }

    public clsProductos(String IdProducto, String nombreProducto, int cantUnidades) {
        IdProducto = IdProducto;
        nombreProducto = nombreProducto;
        cantUnidades = cantUnidades;
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
