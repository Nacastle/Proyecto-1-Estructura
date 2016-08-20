/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexis
 */
public class JavaApplication11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //String hola = "Luis Fernando Salazar Fuentes,10011512,I-1";
        //obtenerCuenta(hola);
        //System.out.println("");
        muestraContenido("/Users/Alexis/Desktop/prueba2.txt");
    }

    public static String obtenerCuenta(String hola) {
        int pos1;
        int pos2;

        pos1 = hola.indexOf(',');
        pos2 = hola.indexOf(',', pos1 + 1);

        String respuesta = hola.substring(pos1 + 1, pos2);
        //System.out.println(respuesta);
        return respuesta;
    }

    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String cadena;
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            //System.out.println(cadena);
            obtenerCuenta(cadena);
        }
        b.close();
    }

}
