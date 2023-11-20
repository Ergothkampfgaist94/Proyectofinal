package Colaboradores;

public class NodoSimple<Object> {
    
    // Esta clase no se modifica, ni se altera
    
    private Object elemento;
    private NodoSimple siguiente;
    
    /*Construye el nodo, que está dividido en 2, 
    uno para el elemento y otro para el siguiente que 
    es la dirección de memoria del nodo con el que se enlaza*/
    public NodoSimple(Object elemento){
        this.elemento = elemento;
        this.siguiente = null;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public NodoSimple getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoSimple siguiente) {
        this.siguiente = siguiente;
    }
    
}
