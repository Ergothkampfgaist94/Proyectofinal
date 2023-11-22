package Colaboradores;

import javax.swing.JOptionPane;

public class MetodoColaboradores {

    private Pila<ColaboradorPrincipal> pilaColabora;
    private Pila<ColaboradorPrincipal> AuxColabora;
    private String cadena;
    private int ContColab;

    public MetodoColaboradores() {
        pilaColabora = new Pila();
        AuxColabora = new Pila();
        cadena = "";
        ContColab = 0;
    }

    public String AgregarColaborador() {
        while (JOptionPane.showConfirmDialog(null,
                "¿Desea agregar un nuevo Colaborador?")
                == JOptionPane.YES_NO_OPTION) {
            pilaColabora.apilar(new ColaboradorPrincipal(
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
            ColaboradorPrincipal objColabo;
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
        RetPilaColab(AuxColabora);
        return cadena;
    }

    public String BuscarColaborador(String identificacion) {
        boolean banderita = false;
        String datoen = "";
        cadena = "";
        while (!pilaColabora.estaVacia()) {
            ColaboradorPrincipal objColabo;
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
            datoen = "¡El colaborador fue encontrado éxitosamente!\n\n";
        } else {
            cadena = "La identificación del colaborador no fue encontrada.";
        }
        RetPilaColab(AuxColabora);
        return datoen + cadena;
    }

    public String ModificarColaborador(String identificacion) {
        boolean banderita = false;
        String datoen = "";
        cadena = "";

        while (!pilaColabora.estaVacia()) {
            ColaboradorPrincipal objColabo;
            objColabo = pilaColabora.getElemento();

            if (objColabo.getIdentificacion().equalsIgnoreCase(identificacion)) {
                banderita = true;
                String opc = MenuMod();
                cadena = opc;

                AuxColabora.apilar(pilaColabora.getElemento());
                pilaColabora.desapilar();
            } else {
                AuxColabora.apilar(pilaColabora.getElemento());
                pilaColabora.desapilar();
            }
        }

        if (banderita) {
            datoen = "El Colaborador fue encontrado!!!\n\n";
        } else {
            cadena = "La identificacion no fue encontrado.";
        }

        RetPilaColab(AuxColabora);
        return datoen + cadena;

    }

    public String ImprimirColab() {
        cadena = "LISTADO DE COLABORADORES\n\n";
        while (!pilaColabora.estaVacia()) {
            ColaboradorPrincipal objColabo;
            objColabo = pilaColabora.getElemento();
            cadena += "Identificador: " + objColabo.getIdentificacion() + "\n"
                    + "Nombre: " + objColabo.getNombre() + "\n"
                    + "Apellido : " + objColabo.getApellido() + "\n"
                    + "Teléfono: " + objColabo.getTelefono() + "\n"
                    + "Correo: " + objColabo.getCorreo() + "\n"
                    + "Años : " + objColabo.getAnioIngreso() + "\n"
                    + "Área : " + objColabo.getArea() + "\n"
                    + "---------------------------------\n\n";

            AuxColabora.apilar(pilaColabora.getElemento());
            pilaColabora.desapilar();

        }
        RetPilaColab(AuxColabora);
        return cadena;
    }

    public String ContadorColab() {
        return "El total de Colaboradores es "
                + ContColab;
    }

    private String MenuMod() {
        ColaboradorPrincipal objColabo;
        objColabo = pilaColabora.getElemento();
        String opcion = "";
        switch (Integer.parseInt(JOptionPane.showInputDialog("Marque la opción deseada\n"
                + "1. Cédula\n"
                + "2. Nombre\n"
                + "3. Apellido\n"
                + "4. Teléfono\n"
                + "5. Correo\n"
                + "6. Año de ingreso\n"
                + "7. Área de trabajo\n"
                + "-----------------------"))) {
            case 1:
                objColabo.setIdentificacion(JOptionPane.showInputDialog(
                        "¿Cuál es La identificación correcta?"));
                opcion = "Identificación del Colaborador modificado con éxito";
                break;
            case 2:
                objColabo.setNombre(JOptionPane.showInputDialog(
                        "¿Cuál es nombre Correcto?"));
                opcion = "Nombre del Colaborador modificado con éxito";
                break;
            case 3:
                objColabo.setApellido(JOptionPane.showInputDialog(
                        "¿Cuál es apellido del Colaborador?"));
                opcion = "Apellido del Colaborador modificado con éxito";
                break;
            case 4:
                objColabo.setTelefono(JOptionPane.showInputDialog(
                        "¿Cuál es el teléfono del Colaborador?"));
                opcion = "Teléfono del Colaborador modificado con éxito";
                break;
            case 5:
                objColabo.setCorreo(JOptionPane.showInputDialog(
                        "¿Cuál es correo del Colaborador?"));
                opcion = "correo del Colaborador modificado con éxito";
                break;
            case 6:
                objColabo.setAnioIngreso(Integer.parseInt(JOptionPane.showInputDialog(
                        "¿Cuál es nuevo año de ingreso?")));
                opcion = "Año de ingreso modificado con éxito";
                break;
            case 7:
                objColabo.setArea(Integer.parseInt(JOptionPane.showInputDialog(
                        "¿Cuál es área del colaborador?")));
                opcion = "Área modificado con éxito";
                break;
            default:
                opcion = "¡Error! la opción seleccionada no existe\n "
                        + "Intente el proceso de nuevo";
        }
        return opcion;
    }

    private void RetPilaColab(Pila<ColaboradorPrincipal> AuxColabora) {

        while (!AuxColabora.estaVacia()) {
            pilaColabora.apilar(AuxColabora.getElemento());
            AuxColabora.desapilar();
        }
    }

    public String MenuColab() {
        String result = "";
        int option = 0;
        try {
            while (option != 6) {
                JOptionPane.showMessageDialog(null,
                        "Menú Colaboradores\n");
                option = Integer.parseInt(JOptionPane.showInputDialog("Seleccione lo que desea hacer\n"
                        + "1. Agregar colaborador\n"
                        + "2. Mostrar colaborador\n"
                        + "3. Modificar información de colaborador\n"
                        + "4. Buscar colaborador\n"
                        + "5. Eliminar colaborador\n"
                        + "6. salir\n"));
                switch (option) {
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                AgregarColaborador());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,
                                ImprimirColab());
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,
                                ModificarColaborador(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,
                                BuscarColaborador(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,
                                EliminarColaborador(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "saliendo");
                        break;
                    default:
                        result = "Opción errada";
                }
            }

        } catch (Exception e) {
            return "\n" + e;
        }
        return result;
    }

}
