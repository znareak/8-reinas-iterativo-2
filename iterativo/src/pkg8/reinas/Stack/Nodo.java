/* 
 * Ejercicio que realiza las operaciones básicas de una Pila.
 * Utiliza tipos de datos Genericos.
 * Cumple con los principios básicos de la Poo.
 * ¡OJO!, la aplicacion se ejecuta desde el fichero EjecutorPila.java.
 */
package pkg8.reinas.Stack;

public class Nodo<T> {

    private T elemento;
    private Nodo<T> siguiente;

    public Nodo(T elemento, Nodo<T> siguiente) {
        this.elemento = elemento;
        this.siguiente = siguiente;

    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public Nodo<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo<T> siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return elemento + "\n";
    }

}
