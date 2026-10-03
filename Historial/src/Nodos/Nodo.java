/*
Morales Escobar Juan Adrian
Salcedo Alvarez Hugo Emmanuel
 */
package Nodos;
import back_end.Pagina;

public class Nodo {
   private Pagina dato;
   private Nodo siguiente;

    public Nodo(Pagina dato) {
        setDato(dato);
        this.siguiente = null;
    }

    public Pagina getDato() {
        return dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setDato(Pagina dato) {
        if(dato==null){
         throw new IllegalArgumentException("El nodo node pagina no puede ser nulo");
        }
        this.dato = dato;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

 
}
