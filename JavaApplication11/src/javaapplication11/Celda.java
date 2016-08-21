
package javaapplication11;

public class Celda <T>{
    
    private T dato;
    private Celda<T> siguiente;
    
    Celda(T a){
        this.dato=a;
        this.siguiente=null;
    }
 
    public T getDato() {
        return dato;
    }
    
    public void setDato(T dato) {
        this.dato = dato;
    }
    
    public Celda<T> getSiguiente() {
        return siguiente;
    }
    
    public void setSiguiente(Celda<T> siguiente) {
        this.siguiente = siguiente;
    }    
    
}
