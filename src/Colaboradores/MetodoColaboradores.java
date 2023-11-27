package Colaboradores;

import Utilidades.Validaciones;
import javax.swing.JOptionPane;
import estructurasdatos.*;

public class MetodoColaboradores {

    private Pila<ColaboradorPrincipal> pilaColabora;
    private Pila<ColaboradorPrincipal> AuxColabora;
    private String cadena;
    private int ContColab;
    Validaciones validar = new Validaciones();

    public MetodoColaboradores() {
        pilaColabora = new Pila();
        AuxColabora = new Pila();
        cadena = "";
        ContColab = 0;
        inicializar();
    }

    public String AgregarColaborador() {
        while (JOptionPane.showConfirmDialog(null,
                "¿Desea agregar un nuevo Colaborador?")
                == JOptionPane.YES_NO_OPTION) {
            pilaColabora.apilar(new ColaboradorPrincipal(
                    validar.ValidateID(JOptionPane.showInputDialog("ID")),
                    validar.validatechar(JOptionPane.showInputDialog("NOMBRE")),
                    validar.validatechar(JOptionPane.showInputDialog("APELLIDO")),
                    validar.ValidateID(JOptionPane.showInputDialog("TELEFONO")),
                    JOptionPane.showInputDialog("CORREO"),
                    Integer.parseInt(validar.ValidateID(JOptionPane.showInputDialog("AÑO DE INGRESO"))),
                    preguntarArea()));
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
            datoen = "¡El colaborador fue encontrado éxitosamente!\n";
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
            datoen = "El Colaborador fue encontrado!!!\n";
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
                    + "---------------------------------\n";

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

    public String MenuColab() {
        String result = "";
        int option = 0;
        try {
            while (option != 6) {
                JOptionPane.showMessageDialog(null,
                        "Menú Colaboradores\n");
                option = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                      Seleccione lo que desea hacer
                                                                      1. Agregar colaborador
                                                                      2. Mostrar colaborador
                                                                      3. Modificar informaci\u00f3n de colaborador
                                                                      4. Buscar colaborador
                                                                      5. Eliminar colaborador
                                                                      6. salir
                                                                      """));
                switch (option) {
                    case 1 ->
                        JOptionPane.showMessageDialog(null,
                                AgregarColaborador());
                    case 2 ->
                        JOptionPane.showMessageDialog(null,
                                ImprimirColab());
                    case 3 ->
                        JOptionPane.showMessageDialog(null,
                                ModificarColaborador(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                    case 4 ->
                        JOptionPane.showMessageDialog(null,
                                BuscarColaborador(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                    case 5 ->
                        JOptionPane.showMessageDialog(null,
                                EliminarColaborador(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                    case 6 ->
                        JOptionPane.showMessageDialog(null, "saliendo");
                    default ->
                        result = "Opción errada";
                }
            }

        } catch (Exception e) {
            return "\n" + e;
        }
        return result;
    }

    private String MenuMod() {
        ColaboradorPrincipal objColabo;
        objColabo = pilaColabora.getElemento();
        String opcion;

        switch (Integer.parseInt(JOptionPane.showInputDialog("""
                                                             Marque la opci\u00f3n deseada
                                                             1. C\u00e9dula
                                                             2. Nombre
                                                             3. Apellido
                                                             4. Tel\u00e9fono
                                                             5. Correo
                                                             6. A\u00f1o de ingreso
                                                             7. \u00c1rea de trabajo
                                                             -----------------------"""))) {
            case 1 -> {
                objColabo.setIdentificacion(validar.ValidateID(JOptionPane.showInputDialog(
                        "¿Cuál es La identificación correcta?")));
                opcion = "Identificación del Colaborador modificado con éxito";
            }
            case 2 -> {
                objColabo.setNombre(validar.validatechar(JOptionPane.showInputDialog(
                        "¿Cuál es nombre Correcto?")));
                opcion = "Nombre del Colaborador modificado con éxito";
            }
            case 3 -> {
                objColabo.setApellido(validar.validatechar(JOptionPane.showInputDialog(
                        "¿Cuál es apellido del Colaborador?")));
                opcion = "Apellido del Colaborador modificado con éxito";
            }
            case 4 -> {
                objColabo.setTelefono(validar.ValidateID(JOptionPane.showInputDialog(
                        "¿Cuál es el teléfono del Colaborador?")));
                opcion = "Teléfono del Colaborador modificado con éxito";
            }
            case 5 -> {
                objColabo.setCorreo(JOptionPane.showInputDialog(
                        "¿Cuál es correo del Colaborador?"));
                opcion = "correo del Colaborador modificado con éxito";
            }
            case 6 -> {
                objColabo.setAnioIngreso(Integer.parseInt(validar.ValidateID(JOptionPane.showInputDialog(
                        "¿Cuál es nuevo año de ingreso?"))));
                opcion = "Año de ingreso modificado con éxito";
            }
            case 7 -> {
                objColabo.setArea(preguntarArea());
                opcion = "Área modificado con éxito";
            }
            default ->
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

    private int preguntarArea() {
        Object[] options = {"Administración",
            "Operativo",
            "Oficios Varios"};
        int n = JOptionPane.showOptionDialog(null,
                "Escoja el área de trabajo",
                "ESCOGER área",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);
        return n + 1;
    }

    private void inicializar() {

        pilaColabora.apilar(new ColaboradorPrincipal("1017222314", "Andrés", "López", "1234567", "correo@correo.com", 2015, 1));
        ContColab++;
        pilaColabora.apilar(new ColaboradorPrincipal("1017222315", "Andrés1", "López1", "2234567", "correo1@correo.com", 2016, 2));
        ContColab++;
        pilaColabora.apilar(new ColaboradorPrincipal("1017222312", "Andrés2", "López2", "2234568", "correo2@correo.com", 2017, 3));
        ContColab++;
        pilaColabora.apilar(new ColaboradorPrincipal("1017222311", "Andrés3", "López3", "2234578", "correo3@correo.com", 2017, 4));
        ContColab++;
        pilaColabora.apilar(new ColaboradorPrincipal("1017222316", "Andrés4", "López4", "2234579", "correo4@correo.com", 2008, 5));
        ContColab++;
    }

}
