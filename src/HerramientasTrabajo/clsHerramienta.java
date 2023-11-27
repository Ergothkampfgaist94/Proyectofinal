/**
 *
 * @author aflop
 */
package HerramientasTrabajo;

public class clsHerramienta {

    private String serialArticulo;
    private String nombreArticulo;
    private int tipoArtículo;
    private int estado;
    private String identificacionColaborador;

    public clsHerramienta() {
        serialArticulo = "";
        nombreArticulo = "";
        tipoArtículo = 0;
        estado = 0;
        identificacionColaborador = "";
    }

    public clsHerramienta(
            String serialArticulo,
            String nombreArticulo,
            int tipoArtículo,
            int estado,
            String identificacionColaborador) {
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

    public int getTipoArtículo() {
        return tipoArtículo;
    }

    public void setTipoArtículo(int tipoArtículo) {
        this.tipoArtículo = tipoArtículo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getIdentificacionColaborador() {
        return identificacionColaborador;
    }

    public void setIdentificacionColaborador(String identificacionColaborador) {
        this.identificacionColaborador = identificacionColaborador;
    }
}
