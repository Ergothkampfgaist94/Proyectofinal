/**
 *
 * @author aflop
 */
package Contable;

public class clsFactura {

    private String idRecibo;
    private double Valor;
    private String Info;
    private static int CONSECUTIVO = 0;

    public clsFactura() {
        idRecibo = "";
        Valor = 0;
        Info = "";
    }

    public clsFactura(double Valor, String Info) {
        this.idRecibo = "" + (CONSECUTIVO++);
        this.Valor = Valor;
        this.Info = Info;
    }

    public String getIdRecibo() {
        return idRecibo;
    }

    public void setIdRecibo(String idRecibo) {
        this.idRecibo = idRecibo;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

}
