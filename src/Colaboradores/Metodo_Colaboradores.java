package Colaboradores;

import javax.swing.JOptionPane;

public class Metodo_Colaboradores {

    private Pila<Colaborador_Principal> pilaColabora;
    private Pila<Colaborador_Principal> AuxColabora;
    private String cadena;
    private int ContColab;

    public Metodo_Colaboradores() {
        pilaColabora = new Pila();
        AuxColabora = new Pila();
        cadena = "";
        ContColab = 0;
    }

    public String AgregarColaborador() {
        while (JOptionPane.showConfirmDialog(null,
                "¿Desea agregar un nuevo Colaborador?")
                == JOptionPane.YES_NO_OPTION) {
            pilaColabora.apilar(new Colaborador_Principal(
                    JOptionPane.showInputDialog("ID"),
                    JOptionPane.showInputDialog("NOMBRE"),
                    JOptionPane.showInputDialog("APELLIDO"),
                    JOptionPane.showInputDialog("TELEFONO"),
                    JOptionPane.showInputDialog("CORREO"),
                    Integer.parseInt(JOptionPane.showInputDialog("AÑO DE INGRESO")),
                    Integer.parseInt(JOptionPane.showInputDialog("AREA"))));
            ContColab++;
        }
        cadena = "Se agregaron "
                + ContColab
                + " Colaboradores nuevos";
        return cadena;
    }

    public String EliminarColaborador(String IDENTIFICACION) {
        boolean banderita = false;
        cadena = "";
        while (!pilaColabora.estaVacia()) {
            Colaborador_Principal objColabo;
            objColabo = pilaColabora.getElemento();
            if (objColabo.getIdentificacion().equalsIgnoreCase(IDENTIFICACION)) {
                banderita = true;
                ContColab--;
                pilaColabora.desapilar();
            } else {
                AuxColabora.apilar(pilaColabora.getElemento());
                pilaColabora.desapilar();
            }
        }
        if (banderita) {
            cadena = "El registro del colaborador fue encontrado y eliminado";
        } else {
            cadena = "El colaborador no fue encontrado";
        }
        retPilaLibro(AuxColabora);
        return cadena;
    }

    public String BuscarColaborador(String identificacion) {
        boolean banderita = false;
        String datoen = "";
        cadena = "";
        while (!pilaColabora.estaVacia()) {
            Colaborador_Principal objColabo;
            objColabo = pilaColabora.getElemento();
            if (objColabo.getIdentificacion().equalsIgnoreCase(identificacion)) {
                banderita = true;
                cadena += "REGISTRO DE COLABORADOR \n\n"
                        + "IDENTIFICADOR: " + objColabo.getIdentificacion() + "\n"
                        + "Nombre COLABORADOR: " + objColabo.getNombre() + "\n"
                        + "Apellido Colaborador: " + objColabo.getApellido() + "\n"
                        + "Teléfono Colaborador: " + objColabo.getTelefono() + "\n"
                        + "Correo Colaborador: " + objColabo.getCorreo() + "\n"
                        + "Año de Ingreso: " + objColabo.getAnioIngreso() + "\n"
                        + "Área de trabajo: " + objColabo.getArea()
                        + "\n";
                AuxColabora.apilar(pilaColabora.getElemento());
                pilaColabora.desapilar();
            } else {
                AuxColabora.apilar(pilaColabora.getElemento());
                pilaColabora.desapilar();
            }
        }
        if (banderita) {
            datoen = "¡El libro fue encontrado éxitosamente!\n\n";
        } else {
            cadena = "El ISBN del libro no fue encontrado.";
        }
        retPilaLibro(AuxColabora);
        return datoen + cadena;
    }

    public String ModificarColaborador(String identificacion) {
        boolean banderita = false;
        String datoen = "";
        cadena = "";

        while (!pilaColabora.estaVacia()) {
            Colaborador_Principal objColabo;
            objColabo = pilaColabora.getElemento();

            if (objColabo.getIdentificacion().equalsIgnoreCase(identificacion)) {
                banderita = true;
                String opc = menuMod();

                AuxLibro.apilar(pilaLibro.getElemento());
                pilaLibro.desapilar();
            } else {
                AuxLibro.apilar(pilaLibro.getElemento());
                pilaLibro.desapilar();
            }
        }

        if (banderita) {
            datoen = "El libro fue encontrado!!!\n\n";
        } else {
            cadena = "El ISBN del libro no fue encontrado.";
        }

        retPilaLibro(AuxLibro);
        return datoen + cadena;

    }

    public String ImprimirLibro() {
        cadena = "LISTADO DE LIBROS DEL INVENTARIO\n\n";
        while (!pilaLibro.estaVacia()) {
            Colaborador_Principal objColabo;
            objColabo = pilaLibro.getElemento();
            cadena += "ISBN: " + objColabo.getISBN() + "\n"
                    + "Nombre Libro: " + objColabo.getNombreLib() + "\n"
                    + "Autor del Libro: " + objColabo.getAutor() + "\n"
                    + "Año de publicación: " + objColabo.getAnio() + "\n"
                    + "---------------------------------\n\n";

            AuxLibro.apilar(pilaLibro.getElemento());
            pilaLibro.desapilar();

        }
        retPilaLibro(AuxLibro);
        return cadena;
    }

    public String ContadorLibros() {
        return "El total de libros es "
                + ContColab;
    }

    private String menuMod() {
        switch (Integer.parseInt(JOptionPane.showInputDialog("Marque 1")) {
            case 1:
                objColabo.setNombreLib(JOptionPane.showInputDialog(
                        "¿Cuál es nuevo nombre del libro?"));
                cadena = "Nombre del libro modificado con éxito";
                break;
            case 2:
                objColabo.setAutor(JOptionPane.showInputDialog(
                        "¿Cuál es nuevo nombre del autor?"));
                cadena = "Autor del libro modificado con éxito";
                break;
            case 3:
                objColabo.setAnio(Integer.parseInt(JOptionPane.showInputDialog(
                        "¿Cuál es nuevo año de publicación del libro?")));
                cadena = "Año de publicación del libro modificado con éxito";
                break;
            default:
                cadena = "¡Error! la opción seleccionada no existe\n "
                        + "Intente el proceso de nuevo";
        }
    }

    private void retPilaLibro(Pila<Colaborador_Principal> AuxLib) {

        while (!AuxLib.estaVacia()) {
            pilaLibro.apilar(AuxLib.getElemento());
            AuxLib.desapilar();
        }

    }

}
