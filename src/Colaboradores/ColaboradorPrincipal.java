/**
 *
 * @author aflop
 */
package Colaboradores;

public class ColaboradorPrincipal {

    private String Identificacion;
    private String Nombre;
    private String Apellido;
    private String Telefono;
    private String Correo;
    private int AnioIngreso;
    private int Area;

    public ColaboradorPrincipal() {
        Identificacion = "";
        Nombre = "";
        Apellido = "";
        Telefono = "";
        Correo = "";
        AnioIngreso = 0;
        Area = 0;
    }

    public ColaboradorPrincipal(String Identificacion,
            String Nombre,
            String Apellido,
            String Telefono,
            String Correo,
            int AnioIngreso,
            int Area) {
        this.Identificacion = Identificacion;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.AnioIngreso = AnioIngreso;
        this.Area = Area;
    }

    public int getAnioIngreso() {
        return AnioIngreso;
    }

    public void setAnioIngreso(int AnioIngreso) {
        this.AnioIngreso = AnioIngreso;
    }

    public int getArea() {
        return Area;
    }

    public void setArea(int Area) {
        this.Area = Area;
    }

    public String getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(String Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public int getAñoIngreso() {
        return AnioIngreso;
    }

    public void setAñoIngreso(int AnioIngreso) {
        this.AnioIngreso = AnioIngreso;
    }

}
