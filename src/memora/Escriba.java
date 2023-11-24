/**
 *
 * @author aflop
 */
package memora;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Escriba {

    public void CrearArchivo() throws IOException {
        File archivo = new File("Base_de_DATOS");
        archivo.createNewFile();
    }

    public String ModificarArchivo(String cadena) throws IOException {
        String Mensaje = "MODIFICADO";
        FileWriter escritor = new FileWriter("Base_de_DATOS");
        escritor.write(cadena);
        escritor.close();

        return Mensaje;
    }   

}
