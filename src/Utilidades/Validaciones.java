/**
 *
 * @author aflop
 */
package Utilidades;

import javax.swing.JOptionPane;

public class Validaciones {

    public String ValidateID(String identificacion) {
        String charesp = "[0-9]+";
        while (!identificacion.matches(charesp)) {
            identificacion = JOptionPane.showInputDialog(null,
                    "Identificación con caracteres diferentes a números, intente nuevamente ");

        }
        return identificacion;
    }

    public String validatechar(String name) {
        String charesp = "[a-zA-Z]+";
        while (!name.matches(charesp)) {
            name = JOptionPane.showInputDialog(null,
                    "Caracteres especiales, intente nuevamente ");
        }
        return name;
    }

    public int anio(String anionacimiento) {
        int edad = 2023 - Integer.parseInt(anionacimiento);
        return (edad);
    }

}
