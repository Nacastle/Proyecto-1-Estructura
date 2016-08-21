package javaapplication11;


public class Lista <T>{
   
    Celda<T> inicio;
    int tamaño=1;
        
    Lista(){
        inicio=null;
    }
     
    public int localizar(T x){
        Celda <T> navegador=inicio;
        int verificador=1;
        int posicion=1;       
        
        while(verificador==1){
            if(navegador.getDato().equals(x)){
                return posicion;
            }
            navegador=navegador.getSiguiente();
            posicion++;
            if(posicion==this.tamaño){
                verificador=2;
            }
        }
        return tamaño;
    }
    
    public T recuperar(int p)throws PosicionInvalidaExcepcion{
        if((p<1)||(p>=this.tamaño)){
            throw new PosicionInvalidaExcepcion();
        }else{
            Celda<T> navegador=this.inicio;
            for(int i=1;i<p;i++){
                navegador=navegador.getSiguiente();
            }
            return navegador.getDato();
        }        
    }
    
    public void suprimir(int p)throws PosicionInvalidaExcepcion{
        if((p<1)||(p>=this.tamaño)){
            throw new PosicionInvalidaExcepcion();
        }else{
            Celda<T> navegador=inicio;
            Celda<T> ref;
            if(p==1){
                this.inicio=inicio.getSiguiente();
                this.tamaño--;
            }else{
                for(int i=1;i<p-1;i++){
                    navegador=navegador.getSiguiente();
                }
                ref=navegador.getSiguiente();
                navegador.setSiguiente(ref.getSiguiente());
                this.tamaño--;
            } 
        }           
      
    }
    
    public void anular(){
        this.inicio.setSiguiente(null);
        this.inicio=null;
        this.tamaño=1;
    }
    
    public void insertar(T x,int p)throws PosicionInvalidaExcepcion{
        if((p<1)||(p>this.tamaño)){
            throw new PosicionInvalidaExcepcion();
        }else{
            Celda<T> navegador=this.inicio;
            Celda<T> nuevo=new Celda<T>(x);
            Celda<T> referencia=null;
        
            if(this.tamaño==1){
                this.inicio=nuevo;            
                this.tamaño++;
            }else{
                if(p==1){
                    nuevo.setSiguiente(inicio);
                    this.inicio=nuevo;
                    this.tamaño++;
                }else{
                    for(int i=1;i<(p-1);i++){
                        navegador=navegador.getSiguiente();                    
                    }
                    referencia=navegador.getSiguiente();
                    navegador.setSiguiente(nuevo);
                    nuevo.setSiguiente(referencia);
                    this.tamaño++;
                }            
            }
        }        
    }
    
    public void imprimir(){
        if(this.tamaño>1){
            Celda<T> ref=inicio;
            for(int i=1;i<tamaño;i++){
                System.out.print("["+ref.getDato()+"]"+" ");
                ref=ref.getSiguiente();
            }
            System.out.println(" ");
        }
        
    }
    
    public int fin(){
        return this.tamaño;
    }
    
}
