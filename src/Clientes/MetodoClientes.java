package Clientes;

import Colaboradores.*;
import javax.swing.JOptionPane;
import estructurasdatos.*;
import Utilidades.*;

public class MetodoClientes {

    private Pila<clsClientes> pilaCliente;
    private Pila<clsClientes> AuxCliente;
    private String cadena;
    private int contCliente;
    Validaciones validar = new Validaciones();

    public MetodoClientes() {
        pilaCliente = new Pila();
        AuxCliente = new Pila();
        cadena = "";
        contCliente = 0;
        inicializar();

    }

    public String AgregarCliente() {
        while (JOptionPane.showConfirmDialog(null,
                "¿Desea agregar un nuevo cliente?")
                == JOptionPane.YES_NO_OPTION) {
            pilaCliente.apilar(new clsClientes(preguntarTipo(),
                    validar.ValidateID(JOptionPane.showInputDialog("IDENTIFICACIÓN")),
                    validar.validatechar(JOptionPane.showInputDialog("NOMBRE COMPLETO")),
                    "",
                    validar.ValidateID(JOptionPane.showInputDialog("NÚMERO DE CONTACTO")),
                    JOptionPane.showInputDialog("CORREO"),
                    0,
                    0
            ));
            contCliente++;
        }
        cadena = "Se agregaron "
                + contCliente
                + " Colaboradores nuevos";
        return cadena;
    }

    public String ImprimirCliente() {
        cadena = "LISTADO DE CLIENTES\n\n";
        while (!pilaCliente.estaVacia()) {
            clsClientes objCliente;
            objCliente = pilaCliente.getElemento();
            cadena += "Tipo del cliente: " + objCliente.getTipoCliente() + "\n"
                    + "Identificador: " + objCliente.getIdentificacion() + "\n"
                    + "Nombre: " + objCliente.getNombre() + "\n"
                    + "Teléfono: " + objCliente.getTelefono() + "\n"
                    + "Correo: " + objCliente.getCorreo() + "\n"
                    + "---------------------------------\n";

            AuxCliente.apilar(pilaCliente.getElemento());
            pilaCliente.desapilar();

        }
        RetPila(AuxCliente);
        return cadena;
    }

    public String ModificarCliente(String identificacion) {
        boolean banderita = false;
        String datoen = "";
        cadena = "";
        while (!pilaCliente.estaVacia()) {
            ColaboradorPrincipal objColabo;
            objColabo = pilaCliente.getElemento();
            if (objColabo.getIdentificacion().equalsIgnoreCase(identificacion)) {
                banderita = true;
                String opc = MenuMod();
                cadena = opc;
                AuxCliente.apilar(pilaCliente.getElemento());
                pilaCliente.desapilar();
            } else {
                AuxCliente.apilar(pilaCliente.getElemento());
                pilaCliente.desapilar();
            }
        }

        if (banderita) {
            datoen = "El cliente fue encontrado!!!\n";
        } else {
            cadena = "Identificador no encontrado.";
        }

        RetPila(AuxCliente);
        return datoen + cadena;

    }

    public String BuscarCliente(String identificacion) {
        boolean banderita = false;
        String datoen = "";
        cadena = "";
        while (!pilaCliente.estaVacia()) {
            clsClientes objCliente;
            objCliente = pilaCliente.getElemento();
            if (objCliente.getIdentificacion().equalsIgnoreCase(identificacion)) {
                banderita = true;
                cadena += "REGISTRO DEL CLIENTE \n\n"
                        + "Tipo del cliente: " + objCliente.getTipoCliente() + "\n"
                        + "Identificador: " + objCliente.getIdentificacion() + "\n"
                        + "Nombre: " + objCliente.getNombre() + "\n"
                        + "Teléfono: " + objCliente.getTelefono() + "\n"
                        + "Correo: " + objCliente.getCorreo() + "\n"
                        + "---------------------------------\n";
                AuxCliente.apilar(pilaCliente.getElemento());
                pilaCliente.desapilar();
            } else {
                AuxCliente.apilar(pilaCliente.getElemento());
                pilaCliente.desapilar();
            }
        }
        if (banderita) {
            datoen = "¡El cliente fue encontrado éxitosamente!\n";
        } else {
            cadena = "La identificación del cliente no fue encontrada.";
        }
        RetPila(AuxCliente);
        return datoen + cadena;
    }

    public String EliminarCliente(String IDENTIFICACION) {
        boolean banderita = false;
        cadena = "";
        while (!pilaCliente.estaVacia()) {
            clsClientes objCliente;
            objCliente = pilaCliente.getElemento();
            if (objCliente.getIdentificacion().equalsIgnoreCase(IDENTIFICACION)) {
                banderita = true;
                contCliente--;
                pilaCliente.desapilar();
            } else {
                AuxCliente.apilar(pilaCliente.getElemento());
                pilaCliente.desapilar();
            }
        }
        if (banderita) {
            cadena = "El registro del colaborador fue encontrado y eliminado";
        } else {
            cadena = "El colaborador no fue encontrado";
        }
        RetPila(AuxCliente);
        return cadena;
    }

    public String MenuClien() {
        String result = "";
        int option = 0;
        try {
            while (option != 6) {
                JOptionPane.showMessageDialog(null,
                        "Menú clientes\n");
                option = Integer.parseInt(JOptionPane.showInputDialog("Seleccione lo que desea hacer\n"
                        + "1. Agregar clientes\n"
                        + "2. Mostrar clientes\n"
                        + "3. Modificar información de clientes\n"
                        + "4. Buscar clientes\n"
                        + "5. Eliminar clientes\n"
                        + "6. salir\n"));
                switch (option) {
                    case 1:
                        JOptionPane.showMessageDialog(null,
                                AgregarCliente());
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null,
                                ImprimirCliente());
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null,
                                ModificarCliente(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                        break;
                    case 4:
                        JOptionPane.showMessageDialog(null,
                                BuscarCliente(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null,
                                EliminarCliente(JOptionPane.showInputDialog("Digite la identificación del colaborador")));
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

    private void RetPila(Pila<clsClientes> AuxCliente) {

        while (!AuxCliente.estaVacia()) {
            pilaCliente.apilar(AuxCliente.getElemento());
            AuxCliente.desapilar();
        }
    }

    private String MenuMod() {
        ColaboradorPrincipal objColabo;
        objColabo = pilaCliente.getElemento();
        String opcion = "";
        switch (Integer.parseInt(JOptionPane.showInputDialog("""
                                                             Marque la opci\u00f3n deseada
                                                             1. Tipo de cliente
                                                             2. Identificador
                                                             3. Nombre
                                                             4. Tel\u00e9fono
                                                             5. Correo                                                             
                                                             -----------------------"""))) {
            case 1 -> {
                preguntarTipo();
            }
            case 2 -> {
                objColabo.setIdentificacion(validar.ValidateID(JOptionPane.showInputDialog(
                        "¿Cuál es La identificación correcta?")));
                opcion = "Identificación del cliente modificado con éxito";
            }
            case 3 -> {
                objColabo.setNombre(validar.validatechar(JOptionPane.showInputDialog(
                        "¿Cuál es nombre Correcto?")));
                opcion = "Nombre del cliente modificado con éxito";
            }
            case 4 -> {
                objColabo.setTelefono(validar.ValidateID(JOptionPane.showInputDialog(
                        "¿Cuál es el teléfono del cliente?")));
                opcion = "Teléfono del cliente modificado con éxito";
            }
            case 5 -> {
                objColabo.setCorreo(JOptionPane.showInputDialog(
                        "¿Cuál es correo del cliente?"));
                opcion = "correo del cliente modificado con éxito";

            }
            default ->
                opcion = "¡Error! la opción seleccionada no existe\n "
                        + "Intente el proceso de nuevo";
        }
        return opcion;
    }

    private int preguntarTipo() {
        Object[] options = {"Persona natural",
            "Persona juridica"};
        int n = JOptionPane.showOptionDialog(null,
                "Escoja el Tipo de Cliente",
                "ESCOGER TIPO DE CLIENE",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);
        return n + 1;

    }

    private void inicializar() {
        pilaCliente.apilar(new clsClientes(1, "1017222314", "Andrés", "", "1234567", "correo@correo.com", 0, 0));
        contCliente++;
        pilaCliente.apilar(new clsClientes(1, "101722231", "Andrés1", "", "1234561", "correo@correo.com", 0, 0));
        contCliente++;
        pilaCliente.apilar(new clsClientes(2, "017222314", "1Andrés", "", "12345611", "correo@correo.com", 0, 0));
        contCliente++;
    }
}
