

package javaapplication11;


public class PosicionInvalidaExcepcion extends RuntimeException{
    
    public PosicionInvalidaExcepcion(){
        this("La posicion ");
    }
    
    public PosicionInvalidaExcepcion(String mensage){
        super(mensage + "ingresada es invalida");
    }
}
