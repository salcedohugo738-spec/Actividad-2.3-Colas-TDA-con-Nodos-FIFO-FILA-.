/*
Morales Escobar Juan Adrian
Salcedo Alvarez Hugo Emmanuel
 */
package Nodos;
import back_end.Pagina;

public class PilaPagina {
   private Nodo tope;
   private int tamano;
   
     public PilaPagina() {
        this.tope = null;
        this.tamano = 0;
    }
public boolean estaVacia() {
        return this.tope == null;
    }
 public int obtenerTamano() {
        return this.tamano;
    }
 public void apilar(Pagina Pagina) {
        if (Pagina == null) {
            throw new IllegalArgumentException("No se puede apilar un objeto Pagina nulo.");
        }
        Nodo nuevoNodo = new Nodo(Pagina);
        nuevoNodo.setSiguiente(this.tope);
        this.tope = nuevoNodo;
        this.tamano++;
    }
 public Pagina desapilar() {
        if (estaVacia()) {
            throw new IllegalStateException("Imposible desapilar: La pila de Paginas está vacía.");
        }
        Pagina PaginaExtraida = this.tope.getDato();
        this.tope = this.tope.getSiguiente();
        this.tamano--;
        return PaginaExtraida;
    }
 public Pagina obtenerTope() {
        if (estaVacia()) {
            throw new IllegalStateException("Imposible obtener el tope: La pila de Paginas está vacía.");
        }
        return this.tope.getDato();
    }
 public void limpiar() {
        this.tope = null;
        this.tamano = 0;
    }
 public Nodo getNodoTope() {
        return this.tope;
    }
}


