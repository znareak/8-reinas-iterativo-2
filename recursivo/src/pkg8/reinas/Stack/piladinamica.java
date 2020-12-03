/* 
 * Ejercicio que realiza las operaciones básicas de una Pila.
 * Utiliza tipos de datos Genericos.
 * Cumple con los principios básicos de la Poo.
 * ¡OJO!, la aplicacion se ejecuta desde el fichero EjecutorPila.java.
 */
package pkg8.reinas.Stack;

public class piladinamica<T> {

    private Nodo<T> top;
    private int tamanio;

    public piladinamica() {
        top = null;
        this.tamanio = 0;

    }

    public boolean IsEmpty() {
        return top == null;
    }

    public int size() {
        return this.tamanio;
    }

    public T top() {
        if (IsEmpty()) {
            return null;
        } else {
            T elemento = top.getElemento();
            return elemento;
        }
    }

    public T pop() {
        if (IsEmpty()) {
            return null;
        } else {
            T elemento = top.getElemento();
            Nodo<T> aux = top.getSiguiente();
            top = null; // liberar memoria
            top = aux;
            this.tamanio--;
            return elemento;
        }
    }

    public void push(T elemento) {
        Nodo<T> aux = new Nodo<>(elemento, top);
        top = aux;
        this.tamanio++;
    }

    @Override
    public String toString() {
        if (IsEmpty()) {
            return "La pila esta Vacia";
        } else {
            String resultado = "";
            Nodo<T> aux = top;
            while (aux != null) {
                resultado += aux.toString();
                aux = aux.getSiguiente();

            }
            return resultado;
        }
    }
}
