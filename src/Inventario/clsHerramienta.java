/**
 *
 * @author aflop
 */
package Inventario;

public class clsHerramienta {

    private String serialArticulo;
    private String nombreArticulo;
    private String tipoArtículo;
    private String estado;
    private int identificacionColaborador;

    public clsHerramienta() {
        serialArticulo = "";
        nombreArticulo = "";
        tipoArtículo = "";
        estado = "";
        identificacionColaborador = 0;
    }

    public clsHerramienta(
            String serialArticulo,
            String nombreArticulo,
            String tipoArtículo,
            String estado,
            int identificacionColaborador) {
        this.serialArticulo = serialArticulo;
        this.nombreArticulo = nombreArticulo;
        this.tipoArtículo = tipoArtículo;
        this.estado = estado;
        this.identificacionColaborador = identificacionColaborador;
    }

    public String getSerialArticulo() {
        return serialArticulo;
    }

    public void setSerialArticulo(String serialArticulo) {
        this.serialArticulo = serialArticulo;
    }

    public String getNombreArticulo() {
        return nombreArticulo;
    }

    public void setNombreArticulo(String nombreArticulo) {
        this.nombreArticulo = nombreArticulo;
    }

    public String getTipoArtículo() {
        return tipoArtículo;
    }

    public void setTipoArtículo(String tipoArtículo) {
        this.tipoArtículo = tipoArtículo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdentificacionColaborador() {
        return identificacionColaborador;
    }

    public void setIdentificacionColaborador(int identificacionColaborador) {
        this.identificacionColaborador = identificacionColaborador;
    }
}
