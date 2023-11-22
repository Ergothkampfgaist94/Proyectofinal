/**
 *
 * @author aflop
 */
package Ventas;

public class clsContaduria {

    private String idRecibo;
    private double Valor;
    private String Info;

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

    public clsContaduria() {
        idRecibo = "";
        Valor = 0;
        Info = "";
    }

    public clsContaduria(String idRecibo, double Valor, String Info) {
        idRecibo = idRecibo;
        Valor = Valor;
        Info = Info;
    }

}
